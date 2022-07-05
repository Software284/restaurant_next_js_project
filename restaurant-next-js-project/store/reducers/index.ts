import { combineReducers } from "redux";
import bankReducers from './bankReducers';

const reducers = combineReducers({
    bank: bankReducers,
});

export default reducers;