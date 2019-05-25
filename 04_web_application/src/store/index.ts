import { combineReducers } from 'redux';
import { generalReducer } from './general/reducer';
import {accountReducer} from "./account/reducer";

export const rootReducer = combineReducers({
    general: generalReducer,
    account: accountReducer
});

export type AppState = ReturnType<typeof rootReducer>;