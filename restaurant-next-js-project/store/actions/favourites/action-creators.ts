import { ActionTypes } from "./action-types";
import { Dispatch } from "redux";
import { FavouritesAction } from "./actions";
import { CartProduct } from "../../../models/classes/CartProduct";

export const addItem = (item: CartProduct) => {
  return (dispatch: Dispatch<FavouritesAction>) => {
    dispatch({
      type: ActionTypes.ADD_FAVOURITES,
      payload: item,
    });
  };
};

export const removeItem = (item: number) => {
  return (dispatch: Dispatch<FavouritesAction>) => {
    dispatch({
      type: ActionTypes.DELETE_FAVOURITES,
      payload: item,
    });
  };
};

export const decreamentItem = (item: CartProduct) => {
  return (dispatch: Dispatch<FavouritesAction>) => {
    dispatch({
      type: ActionTypes.DECREAMENT_FAVOURITES,
      payload: item,
    });
  };
};

export const resetItem = () => {
  return (dispatch: Dispatch<FavouritesAction>) => {
    dispatch({
      type: ActionTypes.RESET_FAVOURITES,
    });
  };
};
