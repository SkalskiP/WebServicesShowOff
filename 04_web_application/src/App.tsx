import React from 'react';
import {connect} from 'react-redux';
import {RotateLoader} from 'react-spinners';
import './App.scss';
import {ContentContainer} from './components/ContentContainer/ContentContainer';
import {LoginView} from './components/LoginView/LoginView';
import {NavigationBar} from './components/NavigationBar/NavigationBar';
import {SlimNavigationBar} from './components/SlimNavigationBar/SlimNavigationBar';
import {AppState} from './store';
import {Firebase} from './utils/Firebase';
import {UserData} from './utils/types/UserData';

interface Props {
  user: UserData;
  loading: boolean;
}

Firebase.setup();

const App: React.FC<Props> = ({user, loading}) => {
  const renderContent = () => {
    if (user === null) return <LoginView />;
    else {
      return (
        <>
          <NavigationBar />
          <ContentContainer />
          <SlimNavigationBar />
        </>
      );
    }
  };

  return (
    <div className="App">
      {loading ? (
        <div className="Loader">
          <RotateLoader color={'#7bd4d7'} loading={true} />
        </div>
      ) : (
        renderContent()
      )}
    </div>
  );
};

const mapStateToProps = (state: AppState) => ({
  user: state.account.user,
  loading: state.general.loading,
});

export default connect(mapStateToProps)(App);
