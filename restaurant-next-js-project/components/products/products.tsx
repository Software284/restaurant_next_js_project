/* eslint-disable @next/next/no-img-element */
import classes from './products.module.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHeart } from '@fortawesome/free-solid-svg-icons';
import { faEye,faStar } from '@fortawesome/free-solid-svg-icons';
import {Product} from '../../models/Product';
interface Props {
  allproduct: Product[];
}
function Products(props:any){
    return (
      <div className={classes.Dishes}>
        <h1>Popular Dishes</h1>
        <div className={classes.BoxContainer}>
            {
                props.products.map((data:any) => {
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
                        <span>{"$" + `${data.price}`}</span>
                        <a href="#" className={classes.Btn}>
                          add to cart
                        </a>
                      </div>
                    );
                })
            };
        </div>
      </div>
    );
}
export default Products;