import React from 'react';
import './TextInput.scss';

interface IProps {
    key: string;
    label: string;
    isPassword: boolean;
    onChange: (value: string) => any;
}

const TextInput = (props: IProps) => {

    const {key, label, isPassword, onChange} = props;

    const getType = () => {
        return isPassword ? "password" : "text";
    };

    return (
        <div className="TextInput">
            <input
                type={getType()}
                id={key}
                onChange={(event) => onChange(event.target.value)}
            />
            <label htmlFor={key}>{label}</label>
            <div className="Bar"/>
        </div>
    );
};

export default TextInput;