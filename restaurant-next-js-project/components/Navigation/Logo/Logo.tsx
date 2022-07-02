import classes from './Logo.module.css';
import {faUtensils} from '@fortawesome/free-solid-svg-icons';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import Link from 'next/link';
const Logo = () =>{
    return (
      <>
        <Link href="/">
          <a className={classes.Logo}>
            <i>
              <FontAwesomeIcon icon={faUtensils} />
            </i>
            resto.
          </a>
        </Link>
      </>
    );
}
export default Logo;