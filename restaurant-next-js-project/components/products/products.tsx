/* eslint-disable @next/next/no-img-element */
import classes from './products.module.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHeart } from '@fortawesome/free-solid-svg-icons';
import { faEye,faStar } from '@fortawesome/free-solid-svg-icons';
import {Product} from '../../models/Product';
import { CartProduct } from '../../models/classes/CartProduct';
import { FavouritesProduct } from '../../models/classes/FavouritesProduct';
import Axios from '../../axios';
import { useDispatch, useSelector } from "react-redux";
import * as ActionCreators from "../../store/actions/cart/action-creators";
import * as FavouritesActionCreators from "../../store/actions/favourites/action-creators";
import { bindActionCreators } from "redux";
import { State } from "../../store/reducers/rootReducers";
import {useRouter} from 'next/router';


interface Props {
  products: Product[];
}


function Products({products}:Props){

  const dispatch = useDispatch();
  const { addItem} = bindActionCreators(
    ActionCreators,
    dispatch
  );
  const { addFavouriteItem } = bindActionCreators(FavouritesActionCreators, dispatch);

  const list = useSelector((state: State) => state.cartreducer);
  const auth = useSelector((state:State) => state.authreducer);
  const favourites = useSelector((state: State) => state.favouritereducer);
   const router = useRouter();

  
  const addDataToCard = (event:any,obj:Product) => {
    event.preventDefault();
    const pro = new CartProduct(obj.id,obj.name,obj.price,1,obj.img);
    addItem(pro);
  }

  const addDataToFavourites = (event:any,obj:Product) => {
    event.preventDefault();
     const pro_for_auth = new FavouritesProduct(
       obj.id,
       obj.name,
       obj.price,
       1,
       obj.img,
       auth.user
     );
    if(auth.token){
      Axios.post("favouritesproduct", pro_for_auth)
        .then((response) => {
          // setLoading(false);
        })
        .catch((error) => {});
    }
    addFavouriteItem(pro_for_auth);
  }

  const viewProductHandler = (event:any,id:number) => {
    event.preventDefault();
    router.push(`/${id}`);
  }

    return (
      <div className={classes.Dishes}>
        <h1>Popular Dishes</h1>
        <div className={classes.BoxContainer}>
            {
                products.map((data:Product,id) => {
                    return (
                      <div className={classes.Box} key={data.id}>
                        <a
                          className={classes.Heart}
                          onClick={(event) => addDataToFavourites(event, data)}
                        >
                          <FontAwesomeIcon icon={faHeart} />
                        </a>
                        <a className={classes.Eye}  onClick={(event) => viewProductHandler(event,data.id)}>
                          <FontAwesomeIcon icon={faEye} />
                        </a>
                        <img src={"/"+data.img} alt=""></img>
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
                          <a
                            className={classes.Btn}
                            onClick={(event) => addDataToCard(event, data)}
                          >
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