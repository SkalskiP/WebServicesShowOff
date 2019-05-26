import {GeneralActionTypes, GeneralState} from './types';
import {Action} from '../Action';
import {TabName} from "../../utils/types/TabName";
import {HistoryTabName} from "../../utils/types/HistoryTabName";

const initialState: GeneralState = {
    activeTabName: TabName.DASHBOARD,
    activeHistoryTabName: HistoryTabName.TODAY
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
        case Action.UPDATE_ACTIVE_HISTORY_TAB_NAME: {
            return {
                ...state,
                activeHistoryTabName: action.payload.activeHistoryTabName,
            };
        }
        default:
            return state;
    }
}