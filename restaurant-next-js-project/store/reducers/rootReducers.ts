import { combineReducers } from "redux";
import { cartreducer } from "./cartReducer";
import { authreducer } from "./authReducer";

const rootreducer = combineReducers({
  cartreducer,
  authreducer
});

export default rootreducer;

export type State = ReturnType<typeof rootreducer>;
