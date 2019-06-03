import React from "react";
import "./App.scss";
import { NavigationBar } from "./components/NavigationBar/NavigationBar";
import { ContentContainer } from "./components/ContentContainer/ContentContainer";
import { SlimNavigationBar } from "./components/SlimNavigationBar/SlimNavigationBar";
import { Firebase } from "./utils/Firebase";
import { LoginView } from "./components/LoginView/LoginView";
import {AppState} from "./store";
import {connect} from "react-redux";
import {User} from "firebase";

interface Props {
  user: User;
}

Firebase.setup();

const App: React.FC<Props> = ({user}) => {
  return (
    <div className="App">
      {user === null ? (
        <LoginView />
      ) : (
        <>
          <NavigationBar />
          <ContentContainer />
          <SlimNavigationBar />
        </>
      )}
    </div>
  );
};

const mapStateToProps = (state: AppState) => ({
  user: state.account.user
});

export default connect(mapStateToProps)(App);
