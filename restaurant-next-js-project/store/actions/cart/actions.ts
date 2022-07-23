import { ActionTypes } from './action-types';
import { CartProduct } from '../../../models/classes/CartProduct';

interface ADD_ACTION {
  type:ActionTypes.ADD_CART,
  payload: CartProduct
}

interface DELETE_ACTION{
  type: ActionTypes.REMOVE_CART,
  payload: number
}

interface DECREAMENT_ACTION {
  type: ActionTypes.DECREMEANT_CART;
  payload: CartProduct;
}

interface RESET_ACTION {
  type: ActionTypes.RESET_CART;
}






export type CartAction = ADD_ACTION | DELETE_ACTION | DECREAMENT_ACTION | RESET_ACTION;


