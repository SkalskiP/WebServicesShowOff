import {UserData} from '../../utils/types/UserData';
import {Action} from '../Action';
import {AccountActionTypes} from './types';

export function updateUserData(user: UserData): AccountActionTypes {
  return {
    type: Action.UPDATE_USER_DATA,
    payload: {
      user,
    },
  };
}
