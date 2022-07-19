import { ActionTypes } from './action-types';

interface SET_TOKEN {
  type:ActionTypes.SET_TOKEN,
  payload:string,
}



export type TokenAction = SET_TOKEN;


