import { useState } from 'react';
import classes from './Authentication.module.css';
import Input from '../../components/UI/Input/Input';
import Button from '../../components/UI/Button/Button';
import { useDispatch, useSelector } from "react-redux";
import * as ActionCreators from "../../store/actions/auth/action-creators";
import { bindActionCreators } from "redux";
import { State } from "../../store/reducers/rootReducers";
import axios from 'axios';
import Spinner from '../../components/UI/Spinner/Spinner';
import { User } from '../../models/classes/User';
import Router, { useRouter } from 'next/router';
const Authentication = () => {

  const [formValidation, setFormValidation] = useState<boolean>(false);

  const [isSignUp,setIsSignUp]  = useState(false);
  const [loading,setLoading] = useState(false);

  const route = useRouter();

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
    const { settoken,setuser,logout} = bindActionCreators(
      ActionCreators,
      dispatch
    );

    const checkAuthTimeout = (expiresIn: string) => {
      console.log("I am Here="+expiresIn);
      setTimeout(() => {
        logout();
      }, +expiresIn);
    };



    const auth_reducer = useSelector((state: State) => state.authreducer);

  const loginHandler = async (event:any) => {
    event.preventDefault();
    const user_obj:any = {};
    for(let key in AuthForm){
      user_obj[key] = AuthForm[key].value;
    }

    const user = new User(user_obj.username,user_obj.password);
    setLoading(true);
    
    if(isSignUp){
      let url = "http://localhost:8080/login";
      axios
        .post(url, user)
        .then((res) => {
          setLoading(false);
          console.log(JSON.stringify(res.headers));
          const full_token = res.headers.authorization;
          const final_token = full_token.replace("Bearer", "");
          const user = res.headers.user;
          checkAuthTimeout(res.headers.expiresin);
          setuser(user);
          settoken(final_token);
          Router.push("/");
        })
        .catch((err) => {
          return console.log(err);
        });
    }
    if(!isSignUp){
       let url2 = "http://localhost:8080/restaurant/register";
       const new_user = {...user};
       const password = new_user.password;
       const bcrypt = require("bcryptjs");
       const salt = await bcrypt.genSalt(10);
       const sec_pass = await bcrypt.hash(password,salt);
       new_user.password = sec_pass;
       axios
         .post(url2, new_user)
         .then((res) => {
            axios
             .post("http://localhost:8080/login", user)
             .then((res) => {
               setLoading(false);
               const full_token = res.headers.authorization;
               const final_token = full_token.replace("Bearer ", "");
               const user = res.headers.user;
               const expirationDate:any = new Date(new Date().getTime() + (parseInt(res.headers.expiresin) * 1000));
               localStorage.setItem('token', final_token);
               localStorage.setItem('expirationDate', expirationDate);
               localStorage.setItem('user',user);
               checkAuthTimeout(res.headers.expiresin);
               setuser(user);
               settoken(final_token);
               Router.push("/");
             })
             .catch((err) => {
               return console.log(err);
             });
         })
         .catch((err) => {
           return console.log(err);
         });
    }
  }

  const switchAuthModeHandler = (event:any) => {
    event.preventDefault();
    const current_val = isSignUp;
    setIsSignUp(!current_val);
  }

  let form:any = (formElementsArray.map((formElement) => (
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

  if(loading){
    form = <Spinner/>
  }



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