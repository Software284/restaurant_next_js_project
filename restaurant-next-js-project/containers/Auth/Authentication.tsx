import { useState } from 'react';
import classes from './Authentication.module.css';
import Input from '../../components/UI/Input/Input';
import Button from '../../components/UI/Button/Button';
import { useDispatch, useSelector } from "react-redux";
import * as ActionCreators from "../../store/actions/auth/action-creators";
import { bindActionCreators } from "redux";
import { State } from "../../store/reducers/rootReducers";
import axios from 'axios';
import { User } from '../../models/classes/User';
const Authentication = () => {

  const [formValidation, setFormValidation] = useState<boolean>(false);

  const [isSignUp,setIsSignUp]  = useState(false);

  const [AuthForm, setAuthForm]:any = useState({
    username: {
      elementType: "input",
      elementConfig: {
        type: "email",
        placeholder: "Your Mail",
      },
      value: "",
      validation: {
        required: true,
        isEmail: true,
      },
      valid: false,
      touched: false,
    },
    password: {
      elementType: "input",
      elementConfig: {
        type: "password",
        placeholder: "Your Password",
      },
      value: "",
      validation: {
        required: true,
        minLength:6,
      },
      valid: false,
      touched: false,
    },
  });

 


  const formElementsArray = [];
  for (let ke in AuthForm) {
    formElementsArray.push({
      id: ke,
      config: AuthForm[ke],
    });
  }

  const checkValidity = (value: string, rules: any): boolean => {
    let isValid = true;
    if (rules.required) {
      isValid = value.trim() !== "" && isValid;
    }
    if (rules.minLength) {
      isValid = value.length >= rules.minLength && isValid;
    }
    if (rules.maxLength) {
      isValid = value.length <= rules.maxLength && isValid;
    }
    if (rules.isEmail) {
      const pattern =
        /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/;
      isValid = pattern.test(value) && isValid;
    }

    if (rules.isNumeric) {
      const pattern = /^\d+$/;
      isValid = pattern.test(value) && isValid;
    }
    return isValid;
  };

  const inputChangedHandler = (event: any, inputIdentifier: string) => {
    const updatedForm = {
      ...AuthForm,
    };
    const updatedFormElement = {
      ...updatedForm[inputIdentifier],
    };

    updatedFormElement.value = event.target.value;
    updatedFormElement.valid = checkValidity(
      updatedFormElement.value,
      updatedFormElement.validation
    );
    updatedFormElement.touched = true;
    updatedForm[inputIdentifier] = updatedFormElement;
    let formIsValid = true;
    for (let inputIdentifier in updatedForm) {
      formIsValid = updatedForm[inputIdentifier].valid && formIsValid;
    }
    setFormValidation(formIsValid);
    setAuthForm(updatedForm);
  };

    const dispatch = useDispatch();
    const { settoken } = bindActionCreators(
      ActionCreators,
      dispatch
    );

    const token = useSelector((state: State) => state.authreducer);

  const loginHandler = (event:any) => {
    event.preventDefault();
    const user_obj:any = {};
    for(let key in AuthForm){
      user_obj[key] = AuthForm[key].value;
    }

    const user = new User(user_obj.username,user_obj.password,true);
    console.log(user.getUsername);
    console.log(user.getPassword);
    console.log(user.getEnabled);
    let url = "http://localhost:8080/login";
    if(isSignUp){
      url= "http://localhost:8080/register";
    }
    axios
      .post(url, user)
      .then((res) => {
        const full_token = res.headers.authorization;
        const final_token = full_token.replace("Bearer","");
        settoken(final_token);
      })
      .catch((err) => {
        return console.log(err);
      });
  }

  const switchAuthModeHandler = (event:any) => {
    event.preventDefault();
    const current_val = isSignUp;
    setIsSignUp(!current_val);
  }

  const form = (formElementsArray.map((formElement) => (
          <Input
            changed={(event) => inputChangedHandler(event, formElement.id)}
            key={formElement.id}
            elementType={formElement.config.elementType}
            elementConfig={formElement.config.elementConfig}
            value={formElement.config.value}
            invalid={!formElement.config.valid}
            shouldValidate={formElement.config.validation}
            touched={formElement.config.touched}
          />
        )));




  return (
    <div className={classes.FormData}>
      <form>
        {form}
        <Button btnType="Success" disabled={!formValidation} clicked={(event) => loginHandler(event)}>
          SUBMIT
        </Button>
      </form>
      <Button btnType="Danger" clicked={(event) => {switchAuthModeHandler(event)}}> SWITCH TO {isSignUp ? 'SIGN IN':'LOG IN'}</Button>
    </div>
  );
};
export default Authentication;