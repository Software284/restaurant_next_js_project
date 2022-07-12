import classes from './ContactData.module.css';
import Button from '../../../components/UI/Button/Button';
import React, { useState } from 'react';
import { useSelector } from "react-redux";
import { State } from "../../../store/reducers/rootReducers";
import axios from "../../../axios";

const ContactData = (props:any) => {

  const list = useSelector((state: State) => state.cartreducer);

  const [price, setPrice] = useState<number>(0);

  const [order, setOrder] = useState({
    name: "",
    email: "",
    address: {
      street: "",
      postalCode: "",
    },
    loading: false,
    purchasing:false
  });

  





  const orderHandle = (event:any) => {
    event.preventDefault();
    console.log("Hello");
    setOrder({loading:true,name:"",email:"",address:{street:"",postalCode:""},purchasing:false});
    

    const order = {
      ingredients:list.carts,
      totalPrice:price,
      customer:{
        name:'Mahesh Lamichhane',
        address:{
          street:"balewa airport",
          zipcode:"344334",
          country:"Nepal"
        },
        gender:"Male",
        email:"mahesh@gmail.com",
      }
  }

  axios
    .post("/order.json", order)
    .then((response) => {
      setOrder({
        loading: false,
        purchasing: false,
        name: "",
        email: "",
        address: { street: "", postalCode: "" },
      });
    })
    .catch((error) => {
      setOrder({
        loading: false,
        purchasing: false,
        name: "",
        email: "",
        address: { street: "", postalCode: "" },
      });
    });

}

  

  const total = () => {
       let price:number = 0;
       list.carts.map((ele, k) => {
         price += ele.price * ele.quantity;
       });
       setPrice(price);
     };

  




    return (
      <div className={classes.ContactData}>
        <h4>Enter Your Contact Data</h4>
        <form>
          <input
            className={classes.Input}
            type="text"
            name="name"
            placeholder="Your Name"
          />
          <input
            className={classes.Input}
            type="email"
            name="email"
            placeholder="Your Email"
          />
          <input
            className={classes.Input}
            type="text"
            name="street"
            placeholder="Your Street"
          />
          <input
            className={classes.Input}
            type="text"
            name="postalcode"
            placeholder="Your Postalcode"
          />
          <Button btnType="Success" clicked={orderHandle}>
            Order
          </Button>
        </form>
      </div>
    );
}
export default ContactData;