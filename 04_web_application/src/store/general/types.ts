import {Action} from '../Action';
import {TabName} from '../../utils/types/TabName';
import {HistoryTabName} from '../../utils/types/HistoryTabName';

export type GeneralState = {
  loading: boolean;
  activeTabName: TabName;
  activeHistoryTabName: HistoryTabName;
  notificationStatus: boolean;
  isAdmin: boolean;
};

interface UpdateActiveHistoryTabName {
  type: typeof Action.UPDATE_ACTIVE_HISTORY_TAB_NAME;
  payload: {
    activeHistoryTabName: HistoryTabName;
  };
}

interface UpdateNotificationStatus {
  type: typeof Action.UPDATE_NOTIFICATION_STATUS;
  payload: {
    notificationStatus: boolean;
  };
}

interface UpdateLoading {
  type: typeof Action.UPDATE_LOADING;
  payload: {
    loading: boolean;
  };
}

interface UpdateAdmin {
  type: typeof Action.UPDATE_ADMIN;
  payload: {
    isAdmin: boolean;
  };
}

export type GeneralActionTypes = UpdateActiveHistoryTabName | UpdateNotificationStatus | UpdateLoading | UpdateAdmin;
