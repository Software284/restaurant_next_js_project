import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import classes from './Icons.module.css';
import { useState } from "react";
import {useSelector } from "react-redux";
import { faBars,faSearch,faShoppingCart,faHeart } from "@fortawesome/free-solid-svg-icons";
import { State } from "../../../store/reducers/rootReducers";
import OrderSummary from "../../../containers/Order-Summary/OrderSummary";
import Modal from "../../UI/Modal/Modal";
const Icons = () => {

  const [modal, setModal] = useState(false);
  const list = useSelector((state: State) => state.cartreducer);

  const modalClosedHandler = () => {
    setModal(false);
  }

  const modalOpenHandler = () => {
    setModal(true);
  }

    return (
      <>
        <Modal show={modal} modalClosed={modalClosedHandler}>
          <OrderSummary modalClosed = {modalClosedHandler}/>
        </Modal>
        <div className={classes.Icon}>
          <i className={classes.MenuBars}>
            <FontAwesomeIcon icon={faBars} />
          </i>
          <i>
            <FontAwesomeIcon icon={faSearch} />
          </i>
          <i className={classes.Shopping} onClick={modalOpenHandler}>
            <FontAwesomeIcon icon={faShoppingCart}></FontAwesomeIcon>
            <span className={classes.Badge}>{list.carts.length}</span>
            <div className={classes.CartModal}></div>
          </i>
          <i>
            <FontAwesomeIcon icon={faHeart} />
          </i>
        </div>
      </>
    );
}
export default Icons;