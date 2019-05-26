import {AccountActionTypes, AccountState} from "./types";
import {Action} from "../Action";

const initialState: AccountState = {
    name: "John",
    surname: "Doe",
    avatar: null
};

export function accountReducer(
    state = initialState,
    action: AccountActionTypes
): AccountState {
    switch (action.type) {
        case Action.UPDATE_USER_DATA: {
            return {
                ...state,
                name: action.payload.name,
                surname: action.payload.surname,
            };
        }
        case Action.UPDATE_USER_AVATAR: {
            return {
                ...state,
                avatar: action.payload.avatar
            }
        }
        default:
            return state;
    }
}