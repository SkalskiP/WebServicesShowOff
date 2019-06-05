import classNames from "classnames";
import React from "react";
import './ImageButton.scss';

interface IProps {
    key:string;
    image:string;
    imageAlt:string;
    onClick?: () => any;
    isActive:boolean;
}

const ImageButton = (props:IProps) => {
    const {key, image, imageAlt, onClick, isActive} = props;

    const geClassName = () => {
        return classNames(
            "ImageButton",
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

export default ImageButton;