import React from 'react';
import './SlimNavigationBar.scss';
import {TabName} from "../../utils/types/TabName";
import classNames from "classnames";
import _ from 'lodash';
import {AppState} from "../../store";
import {connect} from "react-redux";

interface IProps {
    activeTabName: TabName;
}

const SlimNavigationBarComponent = (props: IProps) => {

    const getClassName = () => {
        return classNames(
            "SlimNavigationBar",
            {
                "closed": _.includes(
                    [TabName.SETTINGS, TabName.NOTIFICATIONS, TabName.MANAGE_USERS], props.activeTabName)
            }
        );
    };

    return (
        <div className={getClassName()}/>
    );
};

const mapStateToProps = (state: AppState) => ({
    activeTabName: state.general.activeTabName
});

export const SlimNavigationBar = connect(
    mapStateToProps
)(SlimNavigationBarComponent);