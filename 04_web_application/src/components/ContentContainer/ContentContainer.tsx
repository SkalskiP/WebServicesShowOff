import React from "react";
import { connect } from "react-redux";
import { AppState } from "../../store";
import { updateActiveTabName } from "../../store/general/actionCreators";
import { TabName } from "../../utils/types/TabName";
import AccountSettingsView from "../AccountSettingsView/AccountSettingsView";
import { ContentContainerHeader } from "../ContentContainerHeader/ContentContainerHeader";
import { HistoryView } from "../HistoryView/HistoryView";
import "./ContentContainer.scss";

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
  activeTabName: state.general.activeTabName
});

const mapDispatchToProps = {
  updateActiveTabName
};

export const ContentContainer = connect(mapStateToProps)(
  ContentContainerComponent
);
