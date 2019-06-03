import {AccountActionTypes, AccountState} from "./types";
import {Action} from "../Action";

const initialState: AccountState = {
    user: null
};

export function accountReducer(
    state = initialState,
    action: AccountActionTypes
): AccountState {
    switch (action.type) {
        case Action.UPDATE_USER_DATA: {
            return {
                ...state,
                user: action.payload.user
            };
        }
        default:
            return state;
    }
}