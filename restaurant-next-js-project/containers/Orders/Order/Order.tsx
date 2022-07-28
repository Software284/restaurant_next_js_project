/* eslint-disable @next/next/no-img-element */
import classes from './Order.module.css';
import {Customer} from '../../../models/interfaces/Customer';
import { CartProduct } from '../../../models/classes/CartProduct';

interface Props{
    data:Customer;
}
const Order = (props:Props) => {
    return (
      <div className={classes.Order}>
        <table className={classes.OrderTable}>
          <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
          </tr>
            {
              props.data.order.cartdata.map((data,index) => {
                return <tr key={data.id}>
                  <td>
                    <div>
                      <img src={data.image} alt = "Order Photo"/>
                    </div>
                  </td>
                  <td>{data.name}</td>
                  <td>{data.price}</td>
                  <td>{data.quantity}</td>
                  </tr>
              })
            }
        </table>
        <span>Total=$ {props.data.order.totalprice}</span>
      </div>
    );
    
};
export default Order;