import { FavouritesProduct } from "../../models/classes/FavouritesProduct";
import {FavouriteAction} from '../actions/favourites/actions';
import {ActionTypes} from '../actions/favourites/action-types';
interface DefaultStateI {
  favourites: FavouritesProduct[];
}

const INIT_STATE: DefaultStateI = {
  favourites: [],
};



export const favouritereducer = (state:DefaultStateI = INIT_STATE, action:FavouriteAction):DefaultStateI => {
  switch (action.type) {

    case ActionTypes.ADD_FAVOURITE:
      const IteamIndex = state.favourites.findIndex(
        (iteam) => iteam.id === action.payload.id
      );

      if (IteamIndex >= 0) {
        state.favourites[IteamIndex].quantity += 1;
        return {
          ...state,
          favourites: [...state.favourites],
        };
      } else {
        // const temp = { ...action.payload, qnty: 1 };
        const fav = action.payload;
        fav.setQuantity = 1;
        return {
          ...state,
          favourites: [...state.favourites, fav],
        };
      }


    case ActionTypes.REMOVE_FAVOURITE:
      const data = state.favourites.filter((el) => el.id !== action.payload);
      // console.log(data);

      return {
        ...state,
        favourites: data,
      };

    case ActionTypes.DECREMEANT_FAVOURITE:
      const IteamIndex_dec = state.favourites.findIndex(
        (item) => item.id === action.payload.id
      );

      if (state.favourites[IteamIndex_dec].quantity >= 1) {
        const dltiteams = (state.favourites[IteamIndex_dec].quantity -= 1);
        console.log([...state.favourites, dltiteams]);

        return {
          ...state,
          favourites: [...state.favourites],
        };
      } else if (state.favourites[IteamIndex_dec].quantity === 1) {
        const data = state.favourites.filter(
          (el) => el.id !== action.payload.id
        );

        return {
          ...state,
          favourites: data,
        };
      }

    case ActionTypes.RESET_FAVOURITE:
      return {
        ...state,
        favourites: [],
      };

    default:
      return state;
  }
};
