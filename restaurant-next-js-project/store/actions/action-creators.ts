import { ActionTypes } from "./action-types";
import { Dispatch } from "redux";
import { CartAction } from "./actions";
import { CartProduct } from "../../models/classes/CartProduct";

export const addItem = (item:CartProduct) => {
    return (dispatch:Dispatch<CartAction>) => {
        dispatch({
            type:ActionTypes.ADD_CART,
            payload:item
        })
    }
};



export const removeItem = (item:number) => {
  return (dispatch: Dispatch<CartAction>) => {
    dispatch({
      type: ActionTypes.REMOVE_CART,
      payload: item,
    });
  };
};

export const decreamentItem = (item: CartProduct) => {
  return (dispatch: Dispatch<CartAction>) => {
    dispatch({
      type: ActionTypes.DECREMEANT_CART,
      payload: item,
    });
  };
};
