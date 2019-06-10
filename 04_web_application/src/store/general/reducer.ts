import {GeneralActionTypes, GeneralState} from './types';
import {Action} from '../Action';
import {TabName} from "../../utils/types/TabName";
import {HistoryTabName} from "../../utils/types/HistoryTabName";

const initialState: GeneralState = {
    loading: true,
    activeTabName: TabName.DASHBOARD,
    activeHistoryTabName: HistoryTabName.TODAY,
    notificationStatus: true,
    isAdmin: false
};

export function generalReducer(
    state = initialState,
    action: GeneralActionTypes
): GeneralState {
    switch (action.type) {
        case Action.UPDATE_ACTIVE_HISTORY_TAB_NAME: {
            return {
                ...state,
                activeHistoryTabName: action.payload.activeHistoryTabName,
            };
        }
        case Action.UPDATE_NOTIFICATION_STATUS: {
            return {
                ...state,
                notificationStatus: action.payload.notificationStatus,
            };
        }
        case Action.UPDATE_LOADING: {
            return {
                ...state,
                loading: action.payload.loading,
            };
        }
        case Action.UPDATE_ADMIN: {
            return {
                ...state,
                isAdmin: action.payload.isAdmin,
            };
        }
        default:
            return state;
    }
}