import { combineReducers } from "redux";
import { cartreducer } from "./cartReducer";
import { authreducer } from "./authReducer";
import { favouritereducer } from "./favouriteReducer";

const rootreducer = combineReducers({
  cartreducer,
  authreducer,
  favouritereducer
});

export default rootreducer;

export type State = ReturnType<typeof rootreducer>;
