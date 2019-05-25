import React from 'react';
import './NavigationBar.scss';
import NavigationBarButton from "../NavigationBarButton/NavigationBarButton";
import NavigationBarButtonsData from "../../data/NavigationBarButtonsData";
import {INavigationBarButton} from "../../interfaces/INavigationBarButton";

const NavigationBar: React.FC = () => {

    const getButtons = () => {
        return NavigationBarButtonsData.map(
            (data:INavigationBarButton) => <NavigationBarButton
                key={data.displayName}
                image={data.imageSource}
                imageAlt={data.imageAlt}
                label={data.displayName}
                isActive={true}
            />
        )
    };

    return (
        <div className="NavigationBar">
            <div className="Header">
                <img alt={"logo"} src={"/logo.png"}/>
            </div>
            <div className="ButtonsWrapper">
                {getButtons()}
            </div>
            <div className="Footer"/>
        </div>
    );
};

export default NavigationBar;