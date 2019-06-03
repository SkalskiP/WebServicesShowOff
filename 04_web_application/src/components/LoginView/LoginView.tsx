import React, {useCallback,} from "react";
import TextInput from "../TextInput/TextInput";
import {TextButton} from "../TextButton/TextButton";
import {Firebase} from "../../utils/Firebase";
import "./LoginView.scss";

export const LoginView: React.FC<{}> = () => {
    let loginText = "";
    let passwordText = "";

    const onLoginChange = useCallback(value => (loginText = value), []);
    const onPasswordChange = useCallback(value => (passwordText = value), []);
    const onSubmit = useCallback(() => Firebase.signIn(loginText, passwordText), [
        loginText,
        passwordText
    ]);

    return (
        <div className="LoginView">
            <div className="LoginContainer">
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
                    onChange={onPasswordChange}
                />
                <TextButton label={"Submit"} onClick={onSubmit}/>
            </div>
        </div>
    );
};
