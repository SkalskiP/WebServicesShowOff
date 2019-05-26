import React from "react";
import './AccountSettingsView.scss';
import TextInput from "../TextInput/TextInput";
import {TextButton} from "../TextButton/TextButton";

const AccountSettingsView = () => {

    let login = "";
    let previousPassword = "";
    let newPassword = "";
    let repeatPassword = "";

    const onLoginChange = (value) => {
        login = value;
    };

    const onPreviousPasswordChange = (value) => {
        previousPassword = value;
    };

    const onNewPasswordChange = (value) => {
        newPassword = value;
    };

    const onRepeatPasswordChange = (value) => {
        repeatPassword = value;
    };

    const onSubmit = () => {
        //TODO: Implement submit
        console.log("Login:" + login);
        console.log("Previous password:" + previousPassword);
        console.log("New password:" + newPassword);
        console.log("Repeat password:" + repeatPassword);
    };

    return (
        <div className="AccountSettingsView">
            <TextInput
                label={"Login"}
                key={"login"}
                isPassword={false}
                onChange={onLoginChange}
            />
            <TextInput
                label={"Previous password"}
                key={"previous_password"}
                isPassword={true}
                onChange={onPreviousPasswordChange}
            />
            <TextInput
                label={"New password"}
                key={"new_password"}
                isPassword={true}
                onChange={onNewPasswordChange}
            />
            <TextInput
                label={"Repeat password"}
                key={"repeat_password"}
                isPassword={true}
                onChange={onRepeatPasswordChange}
            />
            <div className="SubmitWrapper">
                <TextButton
                    label={"Submit"}
                    onClick={onSubmit}
                />
            </div>
        </div>
    );
};

export default AccountSettingsView;