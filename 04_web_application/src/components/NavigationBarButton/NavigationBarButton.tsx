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
    isMarked:boolean;
}

const NavigationBarButton = (props:IProps) => {
    const {key, image, imageAlt, label, onClick, isActive, isMarked} = props;

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
            {isMarked && <div className="Marker"/>}
        </div>
    );
};

export default NavigationBarButton;