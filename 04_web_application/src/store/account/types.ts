import { Action } from "../Action";
import {User} from "firebase";

export type AccountState = {
  user: User
};

interface UpdateUserData {
  type: typeof Action.UPDATE_USER_DATA;
  payload: {
    user: User;
  };
}

export type AccountActionTypes = UpdateUserData;
