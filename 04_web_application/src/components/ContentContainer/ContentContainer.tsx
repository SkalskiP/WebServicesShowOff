import React from 'react';
import {connect} from 'react-redux';
import {AppState} from '../../store';
import {TabName} from '../../utils/types/TabName';
import AccountSettingsView from '../AccountSettingsView/AccountSettingsView';
import {ContentContainerHeader} from '../ContentContainerHeader/ContentContainerHeader';
import {HistoryView} from '../HistoryView/HistoryView';
import './ContentContainer.scss';
import DashboardView from '../DashboardView/DashboardView';
import NotificationsView from '../NotificationsView/NotificationsView';
import {ManageUsersView} from '../ManageUsersView/ManageUsersView';

interface IProps {
  activeTabName: TabName;
}

const ContentContainerComponent = (props: IProps) => {
  const getContent = () => {
    switch (props.activeTabName) {
      case TabName.SETTINGS:
        return <AccountSettingsView />;
      case TabName.HISTORY:
        return <HistoryView />;
      case TabName.DASHBOARD:
        return <DashboardView />;
      case TabName.NOTIFICATIONS:
        return <NotificationsView />;
      case TabName.MANAGE_USERS:
        return <ManageUsersView />;
      default:
        return null;
    }
  };

  return (
    <div className="ContentContainer">
      <ContentContainerHeader />
      {getContent()}
    </div>
  );
};

const mapStateToProps = (state: AppState) => ({
  activeTabName: state.general.activeTabName,
});

export const ContentContainer = connect(mapStateToProps)(ContentContainerComponent);
