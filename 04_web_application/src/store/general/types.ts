import { Action } from '../Action';
import {TabName} from "../../utils/types/TabName";
import {HistoryTabName} from "../../utils/types/HistoryTabName";

export type GeneralState = {
    activeTabName: TabName;
    activeHistoryTabName: HistoryTabName;
};

interface UpdateActiveTabName {
    type: typeof Action.UPDATE_ACTIVE_TAB_NAME;
    payload: {
        activeTabName: TabName;
    };
}

interface UpdateActiveHistoryTabName {
    type: typeof Action.UPDATE_ACTIVE_HISTORY_TAB_NAME;
    payload: {
        activeHistoryTabName: HistoryTabName;
    };
}

export type GeneralActionTypes = UpdateActiveTabName
    | UpdateActiveHistoryTabName;