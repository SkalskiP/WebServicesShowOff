import { GeneralActionTypes } from './types';
import { Action } from '../Action';
import {TabName} from "../../utils/types/TabName";
import {HistoryTabName} from "../../utils/types/HistoryTabName";

export function updateActiveHistoryTabName (
    activeHistoryTabName: HistoryTabName
): GeneralActionTypes {
    return {
        type: Action.UPDATE_ACTIVE_HISTORY_TAB_NAME,
        payload: {
            activeHistoryTabName,
        },
    };
}

export function updateNotificationStatus (
    notificationStatus: boolean
): GeneralActionTypes {
    return {
        type: Action.UPDATE_NOTIFICATION_STATUS,
        payload: {
            notificationStatus,
        },
    };
}

export function updateLoadingStatus (
    loading: boolean
): GeneralActionTypes {
    return {
        type: Action.UPDATE_LOADING,
        payload: {
            loading,
        },
    };
}

export function updateAdminStatus (
    isAdmin: boolean
): GeneralActionTypes {
    return {
        type: Action.UPDATE_ADMIN,
        payload: {
            isAdmin,
        },
    };
}