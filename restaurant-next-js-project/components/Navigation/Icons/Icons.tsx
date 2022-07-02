import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import classes from './Icons.module.css';
import { faBars,faSearch,faShoppingCart,faHeart } from "@fortawesome/free-solid-svg-icons";
const Icons = () => {
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
          <span className={classes.Badge}>10</span>
        </i>
        <i>
          <FontAwesomeIcon icon={faHeart} />
        </i>
      </div>
    );
}
export default Icons;