import classes from './navigation.module.css';
import Logo from './Logo/Logo';
import Icons from './Icons/Icons';
import Navbar from './Navbar/Navbar';
import UserInfo  from './UserInfo/UserInfo';


function Navigation(){
   
    return(
        <header className={classes.Header}>
            <Logo />
            <Navbar />
            <Icons/>
            <UserInfo/>
        </header>
    );
}
export default Navigation;