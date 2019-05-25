import React from 'react';
import './ContentContainer.scss';
import {ContentContainerHeader} from "../ContentContainerHeader/ContentContainerHeader";
import RoundBox from "../RoundBox/RoundBox";
import {TabName} from "../../utils/types/TabName";
import AccountSettingsView from "../AccountSettingsView/AccountSettingsView";
import {AppState} from "../../store";
import {connect} from "react-redux";

interface IProps {
    activeTabName: TabName;
}

const ContentContainerComponent = (props: IProps) => {

    const getContent = () => {
        switch (props.activeTabName) {
            case TabName.SETTINGS:
                return <AccountSettingsView/>
            default:
                return <RoundBox/>
        }
    };

    return (
        <div className="ContentContainer">
            <ContentContainerHeader/>
            {getContent()}
        </div>
    );
};

const mapStateToProps = (state: AppState) => ({
    activeTabName: state.general.activeTabName
});

export const ContentContainer = connect(
    mapStateToProps
)(ContentContainerComponent);