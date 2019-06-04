import React from 'react';
import './TextInput.scss';

interface IProps {
    key: string;
    label: string;
    isPassword: boolean;
    onChange: (value: string) => any;
    inputStyle?: React.CSSProperties;
    labelStyle?: React.CSSProperties;
    barStyle?: React.CSSProperties;
}

const TextInput = (props: IProps) => {

    const {
        key,
        label,
        isPassword,
        onChange,
        inputStyle,
        labelStyle,
        barStyle
    } = props;

    const getInputType = () => {
        return isPassword ? "password" : "text";
    };

    return (
        <div className="TextInput">
            <input
                type={getInputType()}
                id={key}
                style={inputStyle}
                onChange={(event) => onChange(event.target.value)}
            />
            <label
                htmlFor={key}
                style={labelStyle}
            >
                {label}
            </label>
            <div
                className="Bar"
                style={barStyle}
            />
        </div>
    );
};

export default TextInput;