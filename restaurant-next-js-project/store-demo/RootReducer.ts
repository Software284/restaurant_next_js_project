import { combineReducers } from "redux";
import pokemonReducer from "./pokemonReducer";

const RootReducer = combineReducers({
  pokemon: pokemonReducer,
});

export default RootReducer;
