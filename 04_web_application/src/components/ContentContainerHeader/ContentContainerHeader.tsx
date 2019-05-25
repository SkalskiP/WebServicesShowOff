import React from 'react';
import './ContentContainerHeader.scss';
import {AppState} from "../../store";
import {connect} from "react-redux";
import {TabName} from "../../utils/types/TabName";
import _ from 'lodash';
import NavigationBarButtonsData from "../../data/NavigationBarButtonsData";

interface IProps {
    activeTabName: TabName;
}

const ContentContainerHeaderComponent = (props: IProps) => {

    const currentTabData = _.find(NavigationBarButtonsData, ['activeTabName', props.activeTabName]);

    return (
        <div className="ContentContainerHeader">
            <div className="SideHeadline">
                {currentTabData.activeTabSubtitle}
            </div>
            <div className="MainHeadline">
                {currentTabData.displayName}
            </div>
        </div>
    );
};

const mapStateToProps = (state: AppState) => ({
    activeTabName: state.general.activeTabName
});

export const ContentContainerHeader = connect(
    mapStateToProps
)(ContentContainerHeaderComponent);