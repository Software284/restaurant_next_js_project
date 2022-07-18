import OrderModel from "./Order/Order";
import classes from './Order.module.css';
import { useEffect, useState } from "react";
import Axios from '../../axios';
import {Order} from '../../models/interfaces/Order';
import Spinner from '../../components/UI/Spinner/Spinner';
const Orders = () => {

    const[orders,setOrders] = useState<Order[]>([]);
    const[loading,setLoading] = useState<boolean>(true);

     useEffect(() => {
       Axios.get<Order[]>("order")
         .then((res) => {
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
          }): <p>Orders Empty</p>
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