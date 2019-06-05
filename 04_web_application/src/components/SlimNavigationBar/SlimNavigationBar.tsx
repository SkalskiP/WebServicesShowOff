import React from 'react';
import './SlimNavigationBar.scss';
import {TabName} from "../../utils/types/TabName";
import classNames from "classnames";
import _ from 'lodash';
import {AppState} from "../../store";
import {connect} from "react-redux";
import HistoryButtonsData from "../../data/HistoryButtonsData";
import ImageButton from "../ImageButton/ImageButton";
import {ISlimNavigationBarButton} from "../../interfaces/ISlimNavigationBarButton";
import {HistoryTabName} from "../../utils/types/HistoryTabName";
import {updateActiveHistoryTabName} from "../../store/general/actionCreators";

interface IProps {
    activeTabName: TabName;
    activeHistoryTabName: HistoryTabName;
    updateActiveHistoryTabName: (activeHistoryTabName: HistoryTabName) => any;
}

const SlimNavigationBarComponent = (props: IProps) => {

    const getClassName = () => {
        return classNames(
            "SlimNavigationBar",
            {
                "closed": _.includes(
                    [TabName.SETTINGS, TabName.NOTIFICATIONS, TabName.MANAGE_USERS, TabName.DASHBOARD], props.activeTabName)
            }
        );
    };

    const getContent = () => {
        switch (props.activeTabName) {
            case (TabName.HISTORY):
                return HistoryButtonsData.map(
                    (data:ISlimNavigationBarButton) => <ImageButton
                        key={data.displayName}
                        image={data.imageSource}
                        imageAlt={data.imageAlt}
                        isActive={data.activeTabName === props.activeHistoryTabName}
                        onClick={() => props.updateActiveHistoryTabName(data.activeTabName)}
                    />
                );
            default:
                return null;
        }
    };

    return (
        <div className={getClassName()}>
            {getContent()}
        </div>
    );
};

const mapStateToProps = (state: AppState) => ({
    activeTabName: state.general.activeTabName,
    activeHistoryTabName: state.general.activeHistoryTabName
});

const dispatchToProps = {
    updateActiveHistoryTabName
};


export const SlimNavigationBar = connect(
    mapStateToProps,
    dispatchToProps
)(SlimNavigationBarComponent);