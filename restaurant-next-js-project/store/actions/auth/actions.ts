import { ActionTypes } from './action-types';

interface SET_TOKEN {
  type:ActionTypes.SET_TOKEN,
  payload:string,
}

interface SET_USER {
  type: ActionTypes.SET_USER;
  payload: string;
}

export type TokenAction = SET_TOKEN | SET_USER;


