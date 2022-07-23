import { ActionTypes } from './action-types';
import { CartProduct } from '../../../models/classes/CartProduct';

interface ADD_ACTION {
  type: ActionTypes.ADD_FAVOURITES;
  payload: CartProduct;
}


interface DELETE_ACTION {
  type: ActionTypes.DELETE_FAVOURITES;
  payload: number;
}

interface DECREAMENT_ACTION {
  type: ActionTypes.DECREAMENT_FAVOURITES;
  payload: CartProduct;
}

interface RESET_ACTION {
  type: ActionTypes.RESET_FAVOURITES;
}


export type FavouritesAction = ADD_ACTION | DELETE_ACTION | DECREAMENT_ACTION | RESET_ACTION;


