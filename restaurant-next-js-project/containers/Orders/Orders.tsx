import OrderModel from "./Order/Order";
import classes from './Order.module.css';
import { useEffect, useState } from "react";
import Axios from '../../axios';
import { Order } from "../../models/classes/Order";
const Orders = () => {

    const[orders,setOrders] = useState<Order>();
    const[loading,setLoading] = useState<boolean>(true);

    useEffect(() => {
        Axios.get<Order>("/order")
        .then(res => {
            // console.log(res.data);
            setLoading(false);
            setOrders(res.data);
            console.log(orders?.totalprice);
        })
        .catch(err => {
            setLoading(false);
        })
    },[]);
    return (
      <div className={classes.OrdersContainer}>
        <OrderModel />
        <OrderModel />
      </div>
    );
}
export default Orders;