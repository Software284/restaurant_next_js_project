import OrderModel from "./Order/Order";
import classes from './Order.module.css';
import { useEffect, useState } from "react";
import Axios from '../../axios';
import { Customer } from "../../models/interfaces/Customer";
import Spinner from '../../components/UI/Spinner/Spinner';
import ErrorAlert from "../../components/UI/ErrorAlert/ErrorAlert";
import { useSelector } from "react-redux";
import { State } from "../../store/reducers/rootReducers";

const Orders = () => {

    const[orders,setOrders] = useState<Customer[]>([]);
    const[loading,setLoading] = useState<boolean>(true);

      const list = useSelector((state: State) => state.authreducer);

     useEffect(() => {
       Axios.get<Customer[]>(`/customerbyname/${list.user}`,{
         headers: {
           'Authorization': "Bearer" + list.token,
         },
       })
         .then((res) => {
          console.log(res.data);
           setLoading(false);
           setOrders(res.data);
         })
         .catch((err) => {
           setLoading(false);
         });
     }, []);

    

    let order_data = (
      <div className={classes.OrdersContainer}>
        <h1>Your Orders</h1>
        {
          orders.length > 0 ? orders.map((data,index) => {
            return <OrderModel key ={index} data= {data}/>
          }): <ErrorAlert>Order is Empty</ErrorAlert>
        }
      </div>
    );



    if(loading){
      order_data= <Spinner/>
    }


    return (
      <>
      {order_data}
      </>
    );
}
export default Orders;