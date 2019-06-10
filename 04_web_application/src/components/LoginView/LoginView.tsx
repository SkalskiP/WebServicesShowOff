import React, {useCallback, useState} from 'react';
import TextInput from '../TextInput/TextInput';
import {TextButton} from '../TextButton/TextButton';
import {Firebase} from '../../utils/Firebase';
import './LoginView.scss';
import {MathUtil} from '../../utils/MathUtil';
import {RouteComponentProps} from 'react-router';

export const LoginView: React.FC<RouteComponentProps> = ({history}) => {
  const [loginState, setLoginState] = useState('login');
  let loginText = '';
  let passwordText = '';
  let emailText = '';

  const onLoginChange = useCallback(value => (loginText = value), []);
  const onPasswordChange = useCallback(value => (passwordText = value), []);
  const onEmailChange = useCallback(value => (emailText = value), []);

  const onSubmit = useCallback(
    () =>
      Firebase.signIn(loginText, passwordText).then(() => {
        history.push('/');
      }),
    [loginText, passwordText]
  );

  const onForgotPassword = useCallback(() => setLoginState('reset'), [loginState]);
  const onForgotPasswordSubmit = useCallback(() => {
    Firebase.auth.sendPasswordResetEmail(emailText);
    setLoginState('login');
  }, [emailText]);

  const inputStyle: React.CSSProperties = {
    color: '#ffffff',
  };

  const barStyle: React.CSSProperties = {
    backgroundColor: '#ffffff',
  };

  const labelStyle: React.CSSProperties = {
    color: '#ffffff',
  };

  const getBubbles = () => {
    let bubbles = [];

    for (let index = 0; index < 15; index++) {
      const bubbleRadius = MathUtil.getRandomInt(20, 120);
      const bubbleStyle: React.CSSProperties = {
        position: 'absolute',
        width: bubbleRadius,
        height: bubbleRadius,
        left: MathUtil.getRandomInt(10, 90) + '%',
        top: MathUtil.getRandomInt(10, 90) + '%',
      };
      bubbles.push(<div className="Bubble" style={bubbleStyle} />);
    }
    return bubbles;
  };

  const renderBox = () => {
    switch (loginState) {
      case 'login':
        return (
          <>
            <TextInput
              label={'Login'}
              key={'login'}
              isPassword={false}
              onChange={onLoginChange}
              inputStyle={inputStyle}
              barStyle={barStyle}
              labelStyle={labelStyle}
            />
            <TextInput
              label={'Password'}
              key={'password'}
              isPassword={true}
              onChange={onPasswordChange}
              inputStyle={inputStyle}
              barStyle={barStyle}
              labelStyle={labelStyle}
            />
            <div className="ButtonsWrapper">
              <TextButton label={'Sign in'} onClick={onSubmit} />
              <TextButton label={'Forgot password?'} onClick={onForgotPassword} />
            </div>
          </>
        );
      case 'reset':
        return (
          <>
            <TextInput
              label={'Email'}
              key={'email'}
              isPassword={false}
              onChange={onEmailChange}
              inputStyle={inputStyle}
              barStyle={barStyle}
              labelStyle={labelStyle}
            />
            <div className="ButtonsWrapper">
              <TextButton label={'Reset Password'} onClick={onForgotPasswordSubmit} />
            </div>
          </>
        );
      default:
        return null;
    }
  };

  return (
    <div className="LoginView">
      <img className="LogoImage" alt={'logo'} src={'/logo.png'} />
      <img className="LogoText" alt={'logo2'} src={'/logo2.png'} />
      {getBubbles()}
      <div className="LoginContainer">{renderBox()}</div>
    </div>
  );
};
