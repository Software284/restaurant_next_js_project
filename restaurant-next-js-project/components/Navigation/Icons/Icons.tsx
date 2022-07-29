import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import classes from './Icons.module.css';
import { useState } from "react";
import {useSelector} from "react-redux";
import { faBars,faSearch,faShoppingCart,faHeart,faUser } from "@fortawesome/free-solid-svg-icons";
import { State } from "../../../store/reducers/rootReducers";
import OrderSummary from "../../../containers/Order-Summary/OrderSummary";
import Modal from "../../UI/Modal/Modal";
import ContactData from "../../../containers/ContactData/ContactData";
import { FavouritesProduct } from "../../../models/classes/FavouritesProduct";
import { cartreducer } from "../../../store/reducers/cartReducer";

const Icons = () => {

  const [modal, setModal] = useState(false);
  const [switching, setSwitching] = useState<boolean>(false);
  const[data,setData]:any = useState([]);

  const list = useSelector((state: State) => state.cartreducer);
  const auth_reducer = useSelector((state: State) => state.authreducer);
  const fav_reducer = useSelector((state: State) => state.favouritereducer);


   



  const modalClosedHandler = () => {
    setModal(false);
  }

  const modalOpenHandler = (event:any,redux_type:string) => {
    if(redux_type === "fav"){
      setData(fav_reducer.favourites);
    }
    else {
      setData(list.carts);
    }
    setModal(true);
  }



  const purchaseContinuedHandler = () => {
    setSwitching(!switching);
  }


  let modalData = {};
  if(switching){
    modalData = <ContactData click = {modalClosedHandler}/>
  }
  else {
    modalData = (
      <OrderSummary
        modalClosed={modalClosedHandler}
        purchaseContinued={purchaseContinuedHandler}
        product ={data}
      />
    );
  }

    return (
      <>
        <Modal show={modal} modalClosed={modalClosedHandler}>
          {list.carts.length > 0 ? (
            modalData
          ) : (
            <p style={{ fontSize: "20px" }}>Your Cart is Empty</p>
          )}
        </Modal>
        <div className={classes.Icon}>
          <i className={classes.MenuBars}>
            <FontAwesomeIcon icon={faBars} />
          </i>
          <i>
            <FontAwesomeIcon icon={faSearch} />
          </i>
          <i className={classes.Shopping} onClick={(event) => modalOpenHandler(event,"cart")}>
            <FontAwesomeIcon icon={faShoppingCart}></FontAwesomeIcon>
            {list.carts.length > 0 ? (
              <span className={classes.Badge}>{list.carts.length}</span>
            ) : (
              ""
            )}
            <div className={classes.CartModal}></div>
          </i>
          <i className={classes.Shopping} onClick={(event) => modalOpenHandler(event,"fav")}>
            <FontAwesomeIcon icon={faHeart} />
            {fav_reducer.favourites.length > 0 ? (
              <span className={classes.Badge}>
                {fav_reducer.favourites.length}
              </span>
            ) : (
              ""
            )}
            <div className={classes.CartModal}></div>
          </i>
        </div>
      </>
    );
}
export default Icons;