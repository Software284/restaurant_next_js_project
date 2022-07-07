/* eslint-disable @next/next/no-img-element */
import classes from './products.module.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHeart } from '@fortawesome/free-solid-svg-icons';
import { faEye,faStar } from '@fortawesome/free-solid-svg-icons';
import {Product} from '../../models/Product';

import { useDispatch, useSelector } from "react-redux";
import * as ActionCreators from "../../store/actions/action-creators";
import { bindActionCreators } from "redux";
import { State } from "../../store/reducers/rootReducers";

interface Props {
  products: Product[];
}


function Products({products}:Props){

  const dispatch = useDispatch();
  const { addItem, removeItem, decreamentItem } = bindActionCreators(
    ActionCreators,
    dispatch
  );

  const list = useSelector((state: State) => state.cartreducer);

  
  const addDataToCard = (obj:Product) => {
    addItem({id:obj.id,name:obj.name,price:obj.price,quantity:1});
  }

    return (
      <div className={classes.Dishes}>
        <h1>Popular Dishes</h1>
        <div className={classes.BoxContainer}>
            {
                products.map((data:Product,id) => {
                    return (
                      <div className={classes.Box} key={data.img}>
                        <a className={classes.Heart}>
                          <FontAwesomeIcon icon={faHeart} />
                        </a>
                        <a className={classes.Eye}>
                          <FontAwesomeIcon icon={faEye} />
                        </a>
                        <img src={data.img} alt=""></img>
                        <h3>{data.name}</h3>

                        <div className={classes.Stars}>
                          <i>
                            <FontAwesomeIcon icon={faStar} />
                          </i>
                          <i>
                            <FontAwesomeIcon icon={faStar} />
                          </i>
                          <i>
                            <FontAwesomeIcon icon={faStar} />
                          </i>
                          <i>
                            <FontAwesomeIcon icon={faStar} />
                          </i>
                        </div>
                        <div className={classes.ProductBottom}>
                          <span>{"$" + `${data.price}`}</span>
                          <a  className={classes.Btn} onClick={()=> addDataToCard(data)}>
                            add to cart
                          </a>
                        </div>
                      </div>
                    );
                })
            };
        </div>
      </div>
    );
}
export default Products;