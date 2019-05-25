import { GeneralActionTypes, GeneralState } from './types';
import { Action } from '../Action';

const initialState: GeneralState = {
    activeTabName: null,
};

export function generalReducer(
    state = initialState,
    action: GeneralActionTypes
): GeneralState {
    switch (action.type) {
        case Action.UPDATE_ACTIVE_TAB_NAME: {
            return {
                ...state,
                activeTabName: action.payload.activeTabName,
            };
        }
        default:
            return state;
    }
}