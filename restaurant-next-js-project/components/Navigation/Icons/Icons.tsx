import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import classes from './Icons.module.css';
import {useSelector } from "react-redux";
import { faBars,faSearch,faShoppingCart,faHeart } from "@fortawesome/free-solid-svg-icons";
import { State } from "../../../store/reducers/rootReducers";
const Icons = () => {

  const list = useSelector((state: State) => state.cartreducer);

    return (
      <div className={classes.Icon}>
        <i className={classes.MenuBars}>
          <FontAwesomeIcon icon={faBars} />
        </i>
        <i>
          <FontAwesomeIcon icon={faSearch} />
        </i>
        <i className={classes.Shopping}>
          <FontAwesomeIcon icon={faShoppingCart}></FontAwesomeIcon>
          <span className={classes.Badge}>{list.carts.length}</span>
          <div className={classes.CartModal}>
            
          </div>
        </i>
        <i>
          <FontAwesomeIcon icon={faHeart} />
        </i>
      </div>
    );
}
export default Icons;