import { ActionTypes } from "./action-types";
import { Dispatch } from "redux";
import { FavouriteAction } from "./actions";
import { FavouritesProduct } from "../../../models/classes/FavouritesProduct";

export const addFavouriteItem = (item:FavouritesProduct) => {
    return (dispatch:Dispatch<FavouriteAction>) => {
        dispatch({
            type:ActionTypes.ADD_FAVOURITE,
            payload:item
        })
    }
};



export const removeFavouriteItem = (item:number) => {
  return (dispatch: Dispatch<FavouriteAction>) => {
    dispatch({
      type: ActionTypes.REMOVE_FAVOURITE,
      payload: item,
    });
  };
};

export const decreamentFavouriteItem = (item: FavouritesProduct) => {
  return (dispatch: Dispatch<FavouriteAction>) => {
    dispatch({
      type: ActionTypes.DECREMEANT_FAVOURITE,
      payload: item,
    });
  };
};

export const resetFavouriteItem = () => {
  return (dispatch: Dispatch<FavouriteAction>) => {
    dispatch({
      type: ActionTypes.RESET_FAVOURITE
    });
  };
};


