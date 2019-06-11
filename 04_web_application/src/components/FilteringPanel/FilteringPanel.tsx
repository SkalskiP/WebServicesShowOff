import React from 'react';
import './FilteringPanel.scss';
import TextInput from "../TextInput/TextInput";

interface IProps {
    key: string;
    onTextChange:  (value: string) => any;
    label: string;
    value?: string;
}

const FilteringPanel = (props: IProps) => {

    const {
        key,
        onTextChange,
        label,
        value,
    } = props;

    return (
        <div className="FilteringPanel">
            <div className="FilterLabel">
                {label}
            </div>
            <TextInput
                key={key}
                label={null}
                isPassword={false}
                onChange={onTextChange}
                value={value}
            />
        </div>
    )

};

export default FilteringPanel;