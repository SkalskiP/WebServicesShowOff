import { GeneralActionTypes } from './types';
import { Action } from '../Action';
import {TabName} from "../../utils/types/TabName";
import {HistoryTabName} from "../../utils/types/HistoryTabName";

export function updateActiveTabName (
    activeTabName: TabName
): GeneralActionTypes {
    return {
        type: Action.UPDATE_ACTIVE_TAB_NAME,
        payload: {
            activeTabName,
        },
    };
}

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