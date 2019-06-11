import React from 'react';
import { connect } from 'react-redux';
import { AppState } from '../../store';
import { AccountState } from '../../store/account/types';
import { Firebase } from '../../utils/Firebase';
import './NavigationBarFooter.scss';

interface Props {
  account: AccountState;
}

const NavigationBarFooterComponent: React.FC<Props> = ({account}) => {
  return (
    <div className="NavigationBarFooter">
      {!!account ? (
        <>
          <div className="LogoutButton" onClick={Firebase.signOut}>
            <img alt={'logout'} src={'/ico/logout.png'} />
          </div>

          <div className="Avatar">
            <img alt={'avatar'} src={account.user.photoUrl || '/ico/avatar.png'} />
          </div>

          <span>{account.user.displayName}</span>
        </>
      ) : (
        <div className="LoginButton" onClick={() => console.log('Login')}>
          {'Login'}
        </div>
      )}
    </div>
  );
};

const mapStateToProps = (state: AppState) => ({
  account: state.account,
});

export const NavigationBarFooter = connect(mapStateToProps)(NavigationBarFooterComponent);
