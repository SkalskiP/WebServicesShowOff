import {Action} from "../Action";

export type AccountState = {
    name: string;
    surname: string;
    //TODO: Image typing
    avatar: any;
}

interface UpdateUserData {
    type: typeof Action.UPDATE_USER_DATA;
    payload: {
        name: string;
        surname: string;
    };
}

interface UpdateUserAvatar {
    type: typeof Action.UPDATE_USER_AVATER;
    payload: {
        avatar: any;
    };
}

export type AccountActionTypes = UpdateUserData
    | UpdateUserAvatar;