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

export const setuser = (user: string) => {
  return (dispatch: Dispatch<TokenAction>) => {
    dispatch({
      type: ActionTypes.SET_USER,
      payload: user,
    });
  };
};

export const logout = () => {
   console.log("Iam Here at local storage=" + localStorage.getItem("token"));
  //  localStorage.removeItem('token');
  //  localStorage.removeItem('expirationDate');
  //  localStorage.removeItem('user');
   return (dispatch: Dispatch<TokenAction>) => {
    dispatch({
      type: ActionTypes.AUTH_LOGOUT,
    });
  };
};

export const authCheckState = () => {
  const token = localStorage.getItem('token');
  const user = localStorage.getItem('user')!;
  if(!token){
    logout();
  }
  else {
    const expirationDate = new Date(localStorage.getItem('expirationDate')!);
    if(expirationDate > new Date()){
      logout();
    }
    else {
       settoken(token);
       setuser(user);
    }
   
  }
};



