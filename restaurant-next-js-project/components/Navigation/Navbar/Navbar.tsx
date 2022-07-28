import classes from './Navbar.module.css';
import Link from 'next/link';
import { useDispatch, useSelector } from "react-redux";
import * as ActionCreators from "../../../store/actions/auth/action-creators";
import { bindActionCreators } from "redux";
import { State } from "../../../store/reducers/rootReducers";


const Navbar = () => {

   const dispatch = useDispatch();
   const {logout } = bindActionCreators(ActionCreators, dispatch);

   const auth_reducer = useSelector((state: State) => state.authreducer);

  const logoutHandler = (event:any) => {
    event.preventDefault();
      logout();
  }
    return (
      <nav className={classes.Navbar}>
        <ul>
          <li>
            <Link
              href={{
                pathname: "/",
                query: {},
              }}
            >
              <a>home</a>
            </Link>
          </li>
          <li>
            <Link
              href={{
                pathname: "/about",
                query: {},
              }}
            >
              <a>about</a>
            </Link>
          </li>
          {auth_reducer.token ? (
            <>
              <li>
                <Link
                  href={{
                    pathname: "/orders",
                    query: {},
                  }}
                >
                  <a>orders</a>
                </Link>
              </li>
              <li>
                <Link
                  href={{
                    pathname: "/favorites",
                    query: {},
                  }}
                >
                  <a>favorites</a>
                </Link>
              </li>
              <li>
                <Link
                  href={{
                    pathname: "/logout",
                    query: {},
                  }}
                >
                  <a onClick={(event) => logoutHandler(event)}>logout</a>
                </Link>
              </li>
            </>
          ) : (
            <li>
              <Link
                href={{
                  pathname: "/login",
                  query: {},
                }}
              >
                <a>login</a>
              </Link>
            </li>
          )}
        </ul>
      </nav>
    );
}
export default Navbar;