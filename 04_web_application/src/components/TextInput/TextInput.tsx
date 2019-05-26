import React from 'react';
import './TextInput.scss';

interface IProps {
    key: string;
    label: string;
}

const TextInput = (props: IProps) => {

    const {key, label} = props;

    return (
        <div className="TextInput">
            <input type="password" id={key} required={true}/>
            <label htmlFor={key}>{label}</label>
            <div className="Bar"/>
        </div>
    );
};

export default TextInput;