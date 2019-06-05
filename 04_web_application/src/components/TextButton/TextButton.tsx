import * as React from 'react';
import './TextButton.scss';
import classNames from "classnames";

interface IProps {
    key?:string;
    label:string;
    onClick?:() => any;
    style?:React.CSSProperties;
    isActive?:boolean;
}

export const TextButton = (props:IProps) => {

    const { key, label, onClick, style, isActive } = props;

    const getClassName = () => {
        return classNames(
            "TextButton",
            {
                "active": isActive
            }
        );
    };

    return(
        <div
            className={getClassName()}
            onClick={onClick}
            key={key}
            style={style}
        >
            {label}
        </div>
    )
};