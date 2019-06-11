import {Action} from '../Action';
import {User} from 'firebase';
import {UserData} from '../../utils/types/UserData';

export type AccountState = {
  user: UserData;
};

interface UpdateUserData {
  type: typeof Action.UPDATE_USER_DATA;
  payload: {
    user: UserData;
  };
}

export type AccountActionTypes = UpdateUserData;
