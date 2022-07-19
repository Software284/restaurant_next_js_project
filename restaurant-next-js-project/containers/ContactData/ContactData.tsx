import classes from './ContactData.module.css';
import Button from '../../components/UI/Button/Button';
import React, { useState,useEffect } from 'react';
import { useRouter } from "next/router";
import Input from "../../components/UI/Input/Input";
import { useSelector } from "react-redux";
import { State } from "../../store/reducers/rootReducers";
import Spinner from '../../components/UI/Spinner/Spinner';
import Axios from "../../axios";
import {Address} from '../../models/classes/Address';
import { Customer } from '../../models/classes/Customer';
import { OrderDemo } from '../../models/classes/OrderDemo';
import { DemoCartProduct } from '../../models/classes/DemoCartProduct';

interface Props{
  click: (event:any) => void;
}


const ContactData : React.FC<Props> = (props) => {

  const router = useRouter();

  const list = useSelector((state: State) => state.cartreducer);

  const [loading,setLoading] = useState<boolean>(false);

  const [price, setPrice] = useState<number>(0);

  const [formValidation,setFormValidation] = useState<boolean>(false);

  useEffect(() => {
    total();
  }, []);

 


  const [MyForm, setMyForm]: any = useState({
    name: {
      elementType: "input",
      elementConfig: {
        type: "text",
        placeholder: "Your Name",
      },
      value: "",
      validation: {
        required: true,
      },
      valid: false,
      touched: false,
    },
    street: {
      elementType: "input",
      elementConfig: {
        type: "text",
        placeholder: "Your Street",
      },
      value: "",
      validation: {
        required: true,
      },
      valid: false,
      touched: false,
    },
    zipcode: {
      elementType: "input",
      elementConfig: {
        type: "number",
        placeholder: "Your Zipcode",
      },
      value: "",
      validation: {
        required: true,
        minLength: 5,
        maxLength: 5,
      },
      valid: false,
      touched: false,
    },
    district: {
      elementType: "input",
      elementConfig: {
        type: "text",
        placeholder: "Your Country",
      },
      value: "",
      validation: {
        required: true,
      },
      valid: false,
      touched: false,
    },
    gender: {
      elementType: "select",
      elementConfig: {
        options: [
          { value: "male", displayValue: "Male" },
          { value: "female", displayValue: "Female" },
        ],
      },
      value: "",
      validation:{

      },
      valid:true,
    },
    email: {
      elementType: "input",
      elementConfig: {
        type: "email",
        placeholder: "Your Email",
      },
      value: "",
      validation: {
        required: true,
      },
      valid: false,
      touched: false,
    },
  });

 


 const formElementsArray = [];
 for (let ke in MyForm) {
   formElementsArray.push({
     id: ke,
     config: MyForm[ke],
   });
 }




  const orderHandle = (event:any) => {
    event.preventDefault();
    setLoading(true);
    const formData:any = {};

    for(let formElementIdentifier in MyForm){
      formData[formElementIdentifier] = MyForm[formElementIdentifier].value;
    }

    const data:DemoCartProduct[] = [];
    list.carts.map((deta) => {
      const d = new DemoCartProduct(deta.getName,deta.price,deta.quantity,deta.image);
      data.push(d);
    })


    const add = new Address(formData.street,formData.zipcode,formData.district);
    const customer = new Customer(formData.name,formData.email,formData.gender,add);
    console.log("Price="+price);
    const or = new OrderDemo(price,data,customer);

    const orderdemo = or;



  Axios
    .post<OrderDemo>("order", orderdemo)
    .then((response) => {
      console.log("Success");
      setLoading(false);
      // setMyForm({
      //   name: "",
      //   email: "",
      //   address: { street: "", postalCode: "" },
      // });
    })
    .catch((error) => {
      setLoading(false);
      // setMyForm({
      //   name: "",
      //   email: "",
      //   address: { street: "", postalCode: "" },
      // });
    });


}

  

  const total = () => {
       let price:number = 0;
       list.carts.map((ele, k) => { 
         price += ele.price * ele.quantity;
       });
       setPrice(price);
     };

     const checkValidity = (value:string,rules:any): boolean => {
      let isValid = true;
      if(rules.required){
        isValid = value.trim() !== '' && isValid;
      }
      if(rules.minLength){
        isValid = value.length >= rules.minLength && isValid;
      }
      if(rules.maxLength){
        isValid = value.length <= rules.maxLength && isValid;
      }
      return isValid;
     }

     function inputChangedHandler(event:any,inputIdentifier:any) {
      const updatedForm = {
        ...MyForm
      };
      const updatedFormElement = {
        ...updatedForm[inputIdentifier]
      };

      updatedFormElement.value= event.target.value; 
      updatedFormElement.valid = checkValidity(updatedFormElement.value,updatedFormElement.validation);
      updatedFormElement.touched = true;
      updatedForm[inputIdentifier] = updatedFormElement;
      let formIsValid = true;
      for (let inputIdentifier in updatedForm){
        formIsValid = updatedForm[inputIdentifier].valid && formIsValid;
      }
      setFormValidation(formIsValid);
      setMyForm(updatedForm);

     }

     let form = (
       <form onSubmit={orderHandle}>
         {formElementsArray.map((formElement, index) => (
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
         ))}

         <Button btnType="Success" disabled={!formValidation} clicked={props.click}>
           Order
         </Button>
       </form>
     );
     if(loading){
      form = <Spinner/>
     }
    return (
      <div className={classes.ContactData}>
        <h4>Enter Your Contact Data</h4>
        {form}
      </div>
    );
}
export default ContactData;