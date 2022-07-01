import classes from './Icons.module.css';
import {NavIcons} from '../../../models/NavIcons';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faBars,faSearch,faHeart,faShoppingCart} from '@fortawesome/free-solid-svg-icons';
const Icons = () => {
  return (
    <div className={classes.Icons}>
      <i>
        <FontAwesomeIcon icon={faBars}></FontAwesomeIcon>
      </i>
      <i>
        <FontAwesomeIcon icon={faSearch}></FontAwesomeIcon>
      </i>
      <i>
        <FontAwesomeIcon icon={faHeart}></FontAwesomeIcon>
      </i>
      <i>
        <FontAwesomeIcon icon={faShoppingCart}></FontAwesomeIcon>
      </i>
    </div>
  );
};
export default Icons;
