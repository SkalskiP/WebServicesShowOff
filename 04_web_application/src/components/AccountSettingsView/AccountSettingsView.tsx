import React, {useState} from 'react';
import './AccountSettingsView.scss';
import TextInput from '../TextInput/TextInput';
import {TextButton} from '../TextButton/TextButton';
import {connect} from 'react-redux';
import {AppState} from '../../store';
import {User} from 'firebase';
import axios from 'axios';
import  Scrollbars  from 'react-custom-scrollbars';

interface Props {
    user: User
}

const AccountSettingsView: React.FC<Props> = ({user}) => {
    const [email, setEmail] = useState(user.email);
    const [name, setName] = useState(user.displayName);
    const [avatarURL, setAvatarURL] = useState(user.photoURL);
    const [newPassword, setNewPassword] = useState("");
    const [repeatPassword, setRepeatPassword] = useState("");
    const [phoneNumber, setPhoneNumber] = useState(user.phoneNumber);

    const onSubmit = () => {
        axios.patch(`localhost:8080/auth/api/user/${user.uid}`, {
        displayName: name,
            email: email,
            password: newPassword,
            photoUrl: avatarURL,
            phoneNumber: phoneNumber,
        })
    };

    return (
        <div className="AccountSettingsView">
            <Scrollbars>
                <div className="AccountSettingsContent">
                    <TextInput
                        value={email}
                        label={"Email"}
                        key={"email"}
                        isPassword={false}
                        onChange={setEmail}
                    />
                    <TextInput
                        value={name}
                        label={"Name and Surname"}
                        key={"name_and_surname"}
                        isPassword={false}
                        onChange={setName}
                    />
                    <TextInput
                        value={avatarURL}
                        label={"Profile Photo URL"}
                        key={"photo_url"}
                        isPassword={false}
                        onChange={setAvatarURL}
                    />
                    <TextInput
                        value={newPassword}
                        label={"New password"}
                        key={"new_password"}
                        isPassword={true}
                        onChange={setNewPassword}
                    />
                    <TextInput
                        value={repeatPassword}
                        label={"Repeat password"}
                        key={"repeat_password"}
                        isPassword={true}
                        onChange={setRepeatPassword}
                    />
                    <TextInput
                        value={phoneNumber}
                        label={"Phone Number"}
                        key={"phone_number"}
                        isPassword={false}
                        onChange={setPhoneNumber}
                    />

                    <div className="SubmitWrapper">
                        <TextButton
                            label={"Submit"}
                            onClick={onSubmit}
                        />
                    </div>
                </div>
            </Scrollbars>
        </div>
    );
};

const mapStateToProps = (state: AppState) => ({
    user: state.account.user
});

export default connect(mapStateToProps)(AccountSettingsView);