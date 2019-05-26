import React from 'react';
import './ContentContainerHeader.scss';
import {AppState} from "../../store";
import {connect} from "react-redux";
import {TabName} from "../../utils/types/TabName";
import _ from 'lodash';
import NavigationBarButtonsData from "../../data/NavigationBarButtonsData";
import {HistoryTabName} from "../../utils/types/HistoryTabName";
import HistoryButtonsData from "../../data/HistoryButtonsData";

interface IProps {
    activeTabName: TabName;
    activeHistoryTabName: HistoryTabName;
}

const ContentContainerHeaderComponent = (props: IProps) => {

    const currentTabData = _.find(NavigationBarButtonsData, ['activeTabName', props.activeTabName]);

    const getSideHeadline = () => {
        if (props.activeTabName === TabName.HISTORY)
            return _.find(HistoryButtonsData, ['activeTabName', props.activeHistoryTabName]).displayName
        else
            return currentTabData.activeTabSubtitle;
    }

    return (
        <div className="ContentContainerHeader">
            <div className="SideHeadline">
                {getSideHeadline()}
            </div>
            <div className="MainHeadline">
                {currentTabData.displayName}
            </div>
        </div>
    );
};

const mapStateToProps = (state: AppState) => ({
    activeTabName: state.general.activeTabName,
    activeHistoryTabName: state.general.activeHistoryTabName
});

export const ContentContainerHeader = connect(
    mapStateToProps
)(ContentContainerHeaderComponent);