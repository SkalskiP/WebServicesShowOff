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

interface Props {
    activeTabName: TabName;
    notificationStatus: boolean;
    updateActiveTabName: (activeTabName: TabName) => any;
    isAdmin: boolean;
}

const NavigationBarComponent: React.FC<Props> = ({activeTabName, notificationStatus, updateActiveTabName, isAdmin}) => {

    const getButtons = () => {
        return NavigationBarButtonsData.filter(el => isAdmin ? true : !el.advancedAccess).map(
            (data:INavigationBarButton) => <NavigationBarButton
                key={data.displayName}
                image={data.imageSource}
                imageAlt={data.imageAlt}
                label={data.displayName}
                isActive={activeTabName === data.activeTabName}
                //TODO: Validation of newly added notifications
                isMarked={data.activeTabName === TabName.NOTIFICATIONS && notificationStatus}
                onClick={() => updateActiveTabName(data.activeTabName)}
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
    activeTabName: state.general.activeTabName,
    notificationStatus: state.general.notificationStatus,
    isAdmin: state.general.isAdmin
});

const dispatchToProps = {
    updateActiveTabName
};

export const NavigationBar = connect(
    mapStateToProps,
    dispatchToProps
)(NavigationBarComponent);