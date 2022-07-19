import { TokenAction } from "../actions/auth/actions";
import { ActionTypes } from "../actions/auth/action-types";
interface DefaultStateI {
  token: string;
}

const INIT_STATE: DefaultStateI = {
  token:"",
};

export const authreducer = (state:DefaultStateI = INIT_STATE, action:TokenAction):DefaultStateI => {
  switch (action.type) {
    case ActionTypes.SET_TOKEN:
      return {
        ...state,
        token: action.payload,
      };
    default:
      return state;
  }
}