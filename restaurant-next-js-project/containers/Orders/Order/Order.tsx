/* eslint-disable @next/next/no-img-element */
import classes from './Order.module.css';
import {Order} from '../../../models/interfaces/Order';
interface Props{
    data:Order;
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
              props.data.cartdata.map(data => {
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
        <span>Total=$ {props.data.totalprice}</span>
      </div>
    );
    
};
export default Order;