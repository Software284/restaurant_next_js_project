import { combineReducers } from "redux";
import { cartreducer } from "./cartReducer";

const rootreducer = combineReducers({
  cartreducer,
});

export default rootreducer;

export type State = ReturnType<typeof rootreducer>;
