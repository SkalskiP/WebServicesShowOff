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

    const inputStyle:React.CSSProperties = {
        color: "#ffffff"
    };

    const barStyle:React.CSSProperties = {
        backgroundColor: "#ffffff"
    };

    const labelStyle:React.CSSProperties = {
        color: "#ffffff"
    };

    return (
        <div className="LoginView">
            <img alt={"logo"} src={"/logo.png"}/>
            <div className="LoginContainer">
                <TextInput
                    label={"Login"}
                    key={"login"}
                    isPassword={false}
                    onChange={onLoginChange}
                    inputStyle={inputStyle}
                    barStyle={barStyle}
                    labelStyle={labelStyle}
                />
                <TextInput
                    label={"Previous password"}
                    key={"previous_password"}
                    isPassword={true}
                    onChange={onPasswordChange}
                    inputStyle={inputStyle}
                    barStyle={barStyle}
                    labelStyle={labelStyle}
                />
                <div className="ButtonsWrapper">
                    <TextButton label={"Sign in"} onClick={onSubmit}/>
                    <TextButton label={"Forgot password?"} onClick={null}/>
                </div>
            </div>
        </div>
    );
};
