import { ActionTypes } from './action-types';

interface SET_TOKEN {
  type:ActionTypes.SET_TOKEN,
  payload:string,
}

interface SET_USER {
  type: ActionTypes.SET_USER;
  payload: string;
}

interface SET_LOGOUT {
  type: ActionTypes.AUTH_LOGOUT;
}

interface GET_LOCAL_STORAGE {
  type: ActionTypes.GET_LOCAL_STORAGE_DATA;
  payload:string;
  user:string;
}





export type TokenAction = SET_TOKEN | SET_USER | SET_LOGOUT | GET_LOCAL_STORAGE;


