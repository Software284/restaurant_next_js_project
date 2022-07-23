import classes from './Navbar.module.css';
import { NavItem } from '../../../models/NavItem';
import Link from 'next/link';

import { useDispatch, useSelector } from "react-redux";
import * as ActionCreators from "../../../store/actions/auth/action-creators";
import { bindActionCreators } from "redux";
import { State } from "../../../store/reducers/rootReducers";

interface Props{
    data:NavItem[];
}
const Navbar: React.FC<Props> = (props) => {

   const dispatch = useDispatch();
   const { settoken, setuser } = bindActionCreators(ActionCreators, dispatch);

   const auth_reducer = useSelector((state: State) => state.authreducer);

  const logoutHandler = (event:any,id:string) => {
    if(id === "logout"){
      event.preventDefault();
      settoken("");
      setuser("");
    }
  }
    return (
      <nav className={classes.Navbar}>
        <ul>
          {props.data.map((deta) => (
            <li key={deta.id} onClick={(event) => logoutHandler(event,deta.id)}>
              <Link
                href={{
                  pathname: `${deta.url}`,
                  query: {},
                }}
              >
                <a>{deta.name}</a>
              </Link>
            </li>
          ))}
        </ul>
      </nav>
    );
}
export default Navbar;