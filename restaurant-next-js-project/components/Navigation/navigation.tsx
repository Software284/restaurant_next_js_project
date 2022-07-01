import {navbar} from '../../static-data';
import classes from './navigation.module.css';
import Logo from './Logo/Logo';
import Navbar from './Navbar/Navbar';
import Icons from './Icons/Icons';

function Navigation(){
    return(
        <header className={classes.Header}>
            <Logo />
            <Navbar data={navbar} />
            <Icons />
        </header>
    );
}
export default Navigation;