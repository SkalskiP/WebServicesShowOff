import {AccountActionTypes} from "./types";
import {Action} from "../Action";

export function updateUserData (
    name: string, surname: string
): AccountActionTypes {
    return {
        type: Action.UPDATE_USER_DATA,
        payload: {
            name,
            surname
        },
    };
}

export function updateUserAvatar (
    avatar: any
): AccountActionTypes {
    return {
        type: Action.UPDATE_USER_AVATER,
        payload: {
            avatar
        },
    };
}