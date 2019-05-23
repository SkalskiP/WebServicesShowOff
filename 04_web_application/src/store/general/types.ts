import { Action } from '../Action';
import {TabName} from "../../utils/types/TabName";

export type GeneralState = {
    activeTabName: TabName;
};

interface UpdateActiveTabName {
    type: typeof Action.UPDATE_ACTIVE_TAB_NAME;
    payload: {
        activeTabName: TabName;
    };
}

export type GeneralActionTypes = UpdateActiveTabName;