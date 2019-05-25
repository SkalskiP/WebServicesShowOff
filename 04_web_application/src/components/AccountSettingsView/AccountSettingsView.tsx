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
                label={"Password"}
                key={"password"}
            />
            <TextButton
                label={"Submit"}
            />
        </div>
    );
};

export default AccountSettingsView;