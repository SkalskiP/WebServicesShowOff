import React from 'react';
import './NavigationBar.scss';
import NavigationBarButton from "../NavigationBarButton/NavigationBarButton";
import NavigationBarButtonsData from "../../data/NavigationBarButtonsData";
import {INavigationBarButton} from "../../interfaces/INavigationBarButton";
import {AppState} from "../../store";
import {updateActiveTabName} from "../../store/general/actionCreators";
import {connect} from "react-redux";
import {TabName} from "../../utils/types/TabName"
import {NavigationBarFooter} from "../NavigationBarFooter/NavigationBarFooter";

interface IProps {
    activeTabName: TabName;
    updateActiveTabName: (activeTabName: TabName) => any;
}

const NavigationBarComponent = (props: IProps) => {

    const getButtons = () => {
        return NavigationBarButtonsData.map(
            (data:INavigationBarButton) => <NavigationBarButton
                key={data.displayName}
                image={data.imageSource}
                imageAlt={data.imageAlt}
                label={data.displayName}
                isActive={props.activeTabName === data.activeTabName}
                //TODO: Validation of newly added notifications
                isMarked={data.activeTabName === TabName.NOTIFICATIONS}
                onClick={() => props.updateActiveTabName(data.activeTabName)}
            />
        )
    };

    return (
        <div className="NavigationBar">
            <img alt={"logo"} src={"/logo.png"}/>
            {/*//TODO: Add scrollbars*/}
            {/*<Scrollbars>*/}
                <div className="ButtonsWrapper">
                    {getButtons()}
                </div>
            {/*</Scrollbars>*/}
            <NavigationBarFooter/>
        </div>
    );
};

const mapStateToProps = (state: AppState) => ({
    activeTabName: state.general.activeTabName
});

const dispatchToProps = {
    updateActiveTabName
};

export const NavigationBar = connect(
    mapStateToProps,
    dispatchToProps
)(NavigationBarComponent);