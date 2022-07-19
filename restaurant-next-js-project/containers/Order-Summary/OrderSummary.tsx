/* eslint-disable @next/next/no-img-element */
import classes from './OrderSummary.module.css';
import Button from '../../components/UI/Button/Button';
import { useState,useEffect } from 'react';
import { useDispatch, useSelector } from "react-redux";
import { State } from "../../store/reducers/rootReducers";
import * as ActionCreators from "../../store/actions/cart/action-creators";
import { bindActionCreators } from "redux";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faTrashAlt} from '@fortawesome/free-solid-svg-icons'

interface Props{
  modalClosed: () => void;
  purchaseContinued: () => void;
}

function OrderSummary (props:Props) {

    const [price, setPrice] = useState<number>(0);

    const dispatch = useDispatch();
    const { addItem, removeItem, decreamentItem } = bindActionCreators(
      ActionCreators,
      dispatch
    );

    const list = useSelector((state: State) => state.cartreducer);

     // eslint-disable-next-line react-hooks/exhaustive-deps
     const total = () => {
       let price:number = 0;
       list.carts.map((ele, k) => {
         price += ele.price * ele.quantity;
       });
       setPrice(price);
     };

     useEffect(() => {
       total();
     }, [total]);

    return (
      <div className={classes.OrderSummary}>
        <table>
          <thead>
            <tr>
              <th>Photo</th>
              <th>Restaurant Name</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>
            {list.carts.map((data, index) => {
              return (
                <>
                  <tr>
                    <td>
                      <div className={classes.ImageContainer}>
                        <img src={data.image} alt=" Product Image" />
                      </div>
                    </td>
                    <td>
                      <p>{data.name}</p>
                      <p>Price : ${data.price}</p>
                      <p>Quantity : {data.quantity}</p>
                    </td>
                    <td>
                      <p
                        style={{
                          color: "red",
                          fontSize: 20,
                          cursor: "pointer",
                        }}
                        onClick={() => removeItem(data.id)}
                      >
                        <FontAwesomeIcon icon={faTrashAlt}></FontAwesomeIcon>
                      </p>
                    </td>
                  </tr>
                </>
              );
            })}
          </tbody>
        </table>
        <div className={classes.ModalFooter}>
          <p>Total $ {price}</p>
          <div className={classes.MyButtons}>
            <Button btnType="Danger" clicked={props.modalClosed}>
              CANCEL
            </Button>
            <Button btnType="Success" clicked={props.purchaseContinued}>
              CONTINUE
            </Button>
          </div>
        </div>
      </div>
    );
    
}
export default OrderSummary;