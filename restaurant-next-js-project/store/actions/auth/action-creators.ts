import { ActionTypes } from "./action-types";
import { Dispatch } from "redux";
import { TokenAction } from "./actions";


export const settoken = (token:string) => {
  return (dispatch: Dispatch<TokenAction>) => {
    dispatch({
      type:ActionTypes.SET_TOKEN,
      payload:token,
    })
  }
}

