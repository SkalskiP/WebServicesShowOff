import React from 'react';
import './App.scss';
import {NavigationBar} from './components/NavigationBar/NavigationBar';
import {ContentContainer} from './components/ContentContainer/ContentContainer';
import {SlimNavigationBar} from './components/SlimNavigationBar/SlimNavigationBar';
import {Firebase} from './utils/Firebase';
import {LoginView} from './components/LoginView/LoginView';
import {AppState} from './store';
import {connect} from 'react-redux';
import {User} from 'firebase';
import {RotateLoader} from 'react-spinners';
import {Route, Redirect, Switch} from 'react-router';

interface Props {
  user: User;
  loading: boolean;
}

Firebase.setup();

const renderContent = ({history}) => {
  const navToPath = (path: string) => history.push(path);
  return (
    <>
      <NavigationBar navigateToPage={navToPath} />
      <ContentContainer />
      <SlimNavigationBar />
    </>
  );
};

const App: React.FC<Props> = ({user, loading}) => {
  return (
    <div className="App">
      {loading ? (
        <div className="Loader">
          <RotateLoader color={'#7bd4d7'} loading={true} />
        </div>
      ) : (
        <Switch>
          <Route path={'/'} component={renderContent} />
          <Route path={'/login'} component={LoginView} />
          {user === null && (
            <Redirect
              to={{
                pathname: '/login',
              }}
            />
          )}
        </Switch>
      )}
    </div>
  );
};

const mapStateToProps = (state: AppState) => ({
  user: state.account.user,
  loading: state.general.loading,
});

export default connect(mapStateToProps)(App);
