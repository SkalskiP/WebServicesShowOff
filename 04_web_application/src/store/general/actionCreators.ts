import { GeneralActionTypes } from './types';
import { Action } from '../Action';
import {TabName} from "../../utils/types/TabName";

export function updateActiveTabName (
    activeTabName: TabName
): GeneralActionTypes {
    console.log(activeTabName)
    return {
        type: Action.UPDATE_ACTIVE_TAB_NAME,
        payload: {
            activeTabName,
        },
    };
}