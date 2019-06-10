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
import {Switch, Route} from 'react-router';

export const ContentContainer = () => {
  return (
    <div className="ContentContainer">
      <ContentContainerHeader />
      <Switch>
        <Route exact path={'/'} component={DashboardView} />
        <Route path={'/account'} component={AccountSettingsView} />
        <Route path={'/history'} component={HistoryView} />
        <Route path={'/notifications'} component={NotificationsView} />
        <Route path={'/users'} component={ManageUsersView} />
      </Switch>
    </div>
  );
};
