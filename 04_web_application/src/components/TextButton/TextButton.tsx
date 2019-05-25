import * as React from 'react';
import './TextButton.scss';

interface IProps {
    key?:string;
    label:string;
    onClick?:() => any;
    style?:React.CSSProperties;
}

export const TextButton = (props:IProps) => {
    return(
        <div
            className="TextButton"
            onClick={props.onClick}
            key={props.key}
            style={props.style}
        >
            {props.label}
        </div>
    )
};