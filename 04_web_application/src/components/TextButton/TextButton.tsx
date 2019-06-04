import * as React from 'react';
import './TextButton.scss';

interface IProps {
    key?:string;
    label:string;
    onClick?:() => any;
    style?:React.CSSProperties;
}

export const TextButton = (props:IProps) => {

    const { key, label, onClick, style } = props;

    return(
        <div
            className="TextButton"
            onClick={onClick}
            key={key}
            style={style}
        >
            {label}
        </div>
    )
};