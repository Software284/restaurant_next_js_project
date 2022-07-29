import classes from './UserInfo.module.css';
import { State } from "../../../store/reducers/rootReducers";
import { useSelector, } from "react-redux";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {faUser} from "@fortawesome/free-solid-svg-icons";
function UserInfo() {

    const auth_reducer = useSelector((state: State) => state.authreducer);

    return (
      <div>
        {auth_reducer.token ? (
          <>
            <div className={classes.Username}>
              <i>
                <FontAwesomeIcon icon={faUser} />
              </i>
              <span>{auth_reducer.user}</span>
            </div>
          </>
        ) : null}
      </div>
    );
}
export default UserInfo;