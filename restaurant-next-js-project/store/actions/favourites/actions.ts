import { ActionTypes } from './action-types';
import { FavouritesProduct } from '../../../models/classes/FavouritesProduct';

interface ADD_ACTION {
  type:ActionTypes.ADD_FAVOURITE,
  payload: FavouritesProduct
}

interface DELETE_ACTION{
  type: ActionTypes.REMOVE_FAVOURITE,
  payload: number
}

interface DECREAMENT_ACTION {
  type: ActionTypes.DECREMEANT_FAVOURITE;
  payload: FavouritesProduct;
}

interface RESET_ACTION {
  type: ActionTypes.RESET_FAVOURITE;
}






export type FavouriteAction = ADD_ACTION | DELETE_ACTION | DECREAMENT_ACTION | RESET_ACTION;


