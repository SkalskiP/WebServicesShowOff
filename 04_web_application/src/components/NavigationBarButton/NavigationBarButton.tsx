import React from 'react';
import './NavigationBarButton.scss';
import classNames from "classnames";

interface IProps {
    key:string;
    image:string;
    imageAlt:string;
    label:string;
    onClick?: () => any;
    isActive:boolean;
}

const NavigationBarButton = (props:IProps) => {
    const {key, image, imageAlt, label, onClick, isActive} = props;

    const geClassName = () => {
        return classNames(
            "NavigationBarButton",
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
            <span className="ButtonLabel">
                {label}
            </span>
        </div>
    );
};

export default NavigationBarButton;