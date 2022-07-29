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
   localStorage.removeItem('token');
   localStorage.removeItem('expirationDate');
   localStorage.removeItem('user');
   return (dispatch: Dispatch<TokenAction>) => {
    dispatch({
      type: ActionTypes.AUTH_LOGOUT,
    });
  };
};

 const checkAuthTimeout = (expiresIn: number) => {
  console.log('Hello token will be expires in='+expiresIn);
   setTimeout(() => {
    return (dispatch: any) => {
      dispatch(logout());
    };
   }, expiresIn);
 };

export const authCheckState = () => {
   console.log("I am here");
   const token = localStorage.getItem("token");
   const user = localStorage.getItem("user")!;
   if (!token) {
      return (dispatch:any) => {
        dispatch(logout());
      };
   } else {
     
     const expirationDate = new Date(localStorage.getItem("expirationDate")!);
     if (expirationDate <= new Date()) {
       return (dispatch: any) => {
         dispatch(logout());
       };
     } else {
       checkAuthTimeout((expirationDate.getTime() - new Date().getTime())/1000);
       return (dispatch: Dispatch<TokenAction>) => {
         dispatch({
           type: ActionTypes.GET_LOCAL_STORAGE_DATA,
           payload: token,
           user: user,
         });
       };
     }
}
};
