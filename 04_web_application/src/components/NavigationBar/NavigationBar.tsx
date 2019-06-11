import React from 'react';
import './NavigationBar.scss';
import NavigationBarButton from '../NavigationBarButton/NavigationBarButton';
import NavigationBarButtonsData from '../../data/NavigationBarButtonsData';
import {INavigationBarButton} from '../../interfaces/INavigationBarButton';
import {AppState} from '../../store';
import {connect} from 'react-redux';
import {TabName} from '../../utils/types/TabName';
import {NavigationBarFooter} from '../NavigationBarFooter/NavigationBarFooter';
import {withRouter, RouteComponentProps} from 'react-router-dom';

interface Props extends RouteComponentProps {
  activeTabName: TabName;
  notificationStatus: boolean;
  isAdmin: boolean;
  navigateToPage: (path: string) => void;
}

const NavigationBarComponent: React.FC<Props> = ({
  match,
  navigateToPage,
  activeTabName,
  notificationStatus,
  isAdmin,
}) => {
  const getButtons = () => {
    return NavigationBarButtonsData.filter(el => (isAdmin ? true : !el.advancedAccess)).map(
      (data: INavigationBarButton) => (
        <NavigationBarButton
          key={data.displayName}
          image={data.imageSource}
          imageAlt={data.imageAlt}
          label={data.displayName}
          isActive={match.path === data.activeTabName}
          //TODO: Validation of newly added notifications
          isMarked={data.activeTabName === TabName.NOTIFICATIONS && notificationStatus}
          onClick={() => navigateToPage(data.activeTabName)}
        />
      )
    );
  };

  console.log(match.path);

  return (
    <div className="NavigationBar">
      <img alt={'logo'} src={'/logo.png'} />
      {/*//TODO: Add scrollbars*/}
      {/*<Scrollbars>*/}
      <div className="ButtonsWrapper">{getButtons()}</div>
      {/*</Scrollbars>*/}
      <NavigationBarFooter />
    </div>
  );
};

const mapStateToProps = (state: AppState) => ({
  activeTabName: state.general.activeTabName,
  notificationStatus: state.general.notificationStatus,
  isAdmin: state.general.isAdmin,
});

// @ts-ignore
export const NavigationBar = withRouter(connect(mapStateToProps)(NavigationBarComponent));
