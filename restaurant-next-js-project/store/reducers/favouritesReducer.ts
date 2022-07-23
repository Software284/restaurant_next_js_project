import { CartProduct } from "../../models/classes/CartProduct";
import {FavouritesAction} from '../actions/favourites/actions';
import {ActionTypes} from '../actions/favourites/action-types';

interface DefaultStateI {
  carts: CartProduct[];
}

const INIT_STATE: DefaultStateI = {
  carts: [],
};



export const favouritesreducer = (state:DefaultStateI = INIT_STATE, action:FavouritesAction):DefaultStateI => {
  switch (action.type) {

    case ActionTypes.ADD_FAVOURITES:
      const IteamIndex = state.carts.findIndex(
        (iteam) => iteam.id === action.payload.id
      );

      if (IteamIndex >= 0) {
        state.carts[IteamIndex].quantity += 1;
        return {
          ...state,
          carts: [...state.carts],
        };
      } else {
        // const temp = { ...action.payload, qnty: 1 };
        const cart = action.payload;
        cart.setQuantity = 1;
        return {
          ...state,
          carts: [...state.carts, cart],
        };
      }


    case ActionTypes.DELETE_FAVOURITES:
      const data = state.carts.filter((el) => el.id !== action.payload);
      // console.log(data);

      return {
        ...state,
        carts: data,
      };

    case ActionTypes.DECREAMENT_FAVOURITES:
      const IteamIndex_dec = state.carts.findIndex(
        (item) => item.id === action.payload.id
      );

      if (state.carts[IteamIndex_dec].quantity >= 1) {
        const dltiteams = (state.carts[IteamIndex_dec].quantity -= 1);
        console.log([...state.carts, dltiteams]);

        return {
          ...state,
          carts: [...state.carts],
        };
      } else if (state.carts[IteamIndex_dec].quantity === 1) {
        const data = state.carts.filter((el) => el.id !== action.payload.id);

        return {
          ...state,
          carts: data,
        };
      }

    case ActionTypes.RESET_FAVOURITES:
      return {
        ...state,
        carts:[]
      }

    default:
      return state;
  }
};
