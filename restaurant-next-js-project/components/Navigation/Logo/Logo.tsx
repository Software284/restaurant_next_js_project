import classes from './Logo.module.css';
import {faUtensils} from '@fortawesome/free-solid-svg-icons';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
const Logo = () =>{
    return (
      <a href="#" className={classes.logo}>
        <i>
          <FontAwesomeIcon icon={faUtensils} />
        </i>
        resto.
      </a>
    );
}
export default Logo;