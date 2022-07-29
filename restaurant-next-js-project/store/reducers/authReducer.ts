import { TokenAction } from "../actions/auth/actions";
import { ActionTypes } from "../actions/auth/action-types";
interface DefaultStateI {
  token: string;
  user:string;
}

const INIT_STATE: DefaultStateI = {
  token:"",
  user:""
};

export const authreducer = (state:DefaultStateI = INIT_STATE, action:TokenAction):DefaultStateI => {
  switch (action.type) {
    case ActionTypes.SET_TOKEN:
      return {
        ...state,
        token: action.payload,
      };
    case ActionTypes.SET_USER:
      return {
        ...state,user:action.payload
      };
    case ActionTypes.AUTH_LOGOUT:
      return {
        ...state,token:"",user:""
      }
    case ActionTypes.GET_LOCAL_STORAGE_DATA:
      console.log("Hello iam inside reducer");
      return {
        ...state,token:action.payload,user:action.user
      }
    default:
      return state;
  }
}