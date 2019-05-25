import React from "react";
import './AccountSettingsView.scss';
import TextInput from "../TextInput/TextInput";
import {TextButton} from "../TextButton/TextButton";

const AccountSettingsView = () => {

    return (
        <div className="AccountSettingsView">
            <TextInput
                label={"Login"}
                key={"login"}
            />
            <TextInput
                label={"Previous password"}
                key={"previous_password"}
            />
            <TextInput
                label={"New password"}
                key={"new_password"}
            />
            <TextInput
                label={"Repeat password"}
                key={"repeat_password"}
            />
            <div className="SubmitWrapper">
                <TextButton
                    label={"Submit"}
                />
            </div>
        </div>
    );
};

export default AccountSettingsView;