import * as actionTypes from './actions';
import { Product } from '../models/Product';
import {Action } from './actions';
import {ActionTypes} from './action-types';
const initialState = 10;

// const initialState = {
//   ingredients: [],
//   totalPrice: 0,
// };

const reducer = (state=initialState,action:Action) => {
    switch (action.type) {
      case ActionTypes.DEPOSIT:
        return state+action.payload;
      case ActionTypes.WITHDRAW:
        return state-action.payload;
      case ActionTypes.BANKRUPT:
        return 0;
      default:
        return state;
    }
};

export default reducer;