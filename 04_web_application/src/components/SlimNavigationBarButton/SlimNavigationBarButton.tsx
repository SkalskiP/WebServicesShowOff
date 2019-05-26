import classNames from "classnames";
import React from "react";
import './SlimNavigationBarButton.scss';

interface IProps {
    key:string;
    image:string;
    imageAlt:string;
    onClick?: () => any;
    isActive:boolean;
}

const SlimNavigationBarButton = (props:IProps) => {
    const {key, image, imageAlt, onClick, isActive} = props;

    const geClassName = () => {
        return classNames(
            "SlimNavigationBarButton",
            {
                "active": isActive
            }
        );
    };

    return (
        <div
            className={geClassName()}
            key={key}
            onClick={onClick}
        >
            <img alt={imageAlt} src={image}/>
        </div>
    );
};

export default SlimNavigationBarButton;