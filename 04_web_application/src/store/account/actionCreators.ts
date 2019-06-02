import {AccountActionTypes} from "./types";
import {Action} from "../Action";
import {User} from "firebase";

export function updateUserData(
    user: User
): AccountActionTypes {
    return {
        type: Action.UPDATE_USER_DATA,
        payload: {
            user
        },
    };
}
