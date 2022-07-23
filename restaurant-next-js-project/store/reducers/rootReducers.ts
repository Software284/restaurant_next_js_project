import { combineReducers } from "redux";
import { cartreducer } from "./cartReducer";
import { authreducer } from "./authReducer";
import {favouritesreducer} from './favouritesReducer';

const rootreducer = combineReducers({
  cartreducer,
  authreducer,
  favouritesreducer
});

export default rootreducer;

export type State = ReturnType<typeof rootreducer>;
