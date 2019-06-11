import React, {useState} from 'react';
import './AccountSettingsView.scss';
import TextInput from '../TextInput/TextInput';
import {TextButton} from '../TextButton/TextButton';
import {connect} from 'react-redux';
import {AppState} from '../../store';
import {User} from 'firebase';
import axios from 'axios';
import Scrollbars from 'react-custom-scrollbars';
import {updateUserData} from '../../store/account/actionCreators';

interface Props {
  loggedUser: User;
  editedUser?: User;
  setEditedUser?: (user: User) => void;
  updateUser(user: User): void;
}

const AccountSettingsView: React.FC<Props> = ({setEditedUser, updateUser, loggedUser, editedUser}) => {
  const user = editedUser ? editedUser : loggedUser;

  const [email, setEmail] = useState(user.email);
  const [name, setName] = useState(user.displayName);
  const [avatarURL, setAvatarURL] = useState(user.photoURL);
  const [newPassword, setNewPassword] = useState('');
  const [repeatPassword, setRepeatPassword] = useState('');
  const [phoneNumber, setPhoneNumber] = useState(user.phoneNumber);

  const onSubmit = () => {
    let payload = {
      displayName: name,
      email: email,
      photoUrl: avatarURL,
      phoneNumber: phoneNumber,
    };

    if (newPassword !== '' && !!newPassword && newPassword === repeatPassword) {
      payload = Object.assign(payload, {password: newPassword});
    }

    axios
      .patch(`http://localhost:8080/auth/rest/user/${user.uid}`, payload)
      .then(response => response.data)
      .then((payload: User) => {
        if (editedUser) {
          setEditedUser(payload);
        } else {
          updateUser(payload);
        }
      });
  };

  return (
    <div className="AccountSettingsView">
      <Scrollbars>
        <div className="AccountSettingsContent">
          <TextInput value={email} label={'Email'} key={'email'} isPassword={false} onChange={setEmail} />
          <TextInput
            value={name}
            label={'Name and Surname'}
            key={'name_and_surname'}
            isPassword={false}
            onChange={setName}
          />
          <TextInput
            value={avatarURL}
            label={'Profile Photo URL'}
            key={'photo_url'}
            isPassword={false}
            onChange={setAvatarURL}
          />
          <TextInput
            value={newPassword}
            label={'New password'}
            key={'new_password'}
            isPassword={true}
            onChange={setNewPassword}
          />
          <TextInput
            value={repeatPassword}
            label={'Repeat password'}
            key={'repeat_password'}
            isPassword={true}
            onChange={setRepeatPassword}
          />
          <TextInput
            value={phoneNumber}
            label={'Phone Number'}
            key={'phone_number'}
            isPassword={false}
            onChange={setPhoneNumber}
          />

          <div className="SubmitWrapper">
            <TextButton label={'Submit'} onClick={onSubmit} />
          </div>
        </div>
      </Scrollbars>
    </div>
  );
};

const mapDispatchToProps = {
  updateUser: updateUserData,
};

const mapStateToProps = (state: AppState) => ({
  loggedUser: state.account.user,
});

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(AccountSettingsView);
