import React from "react";
import "./App.scss";
import {NavigationBar} from "./components/NavigationBar/NavigationBar";
import {ContentContainer} from "./components/ContentContainer/ContentContainer";
import {SlimNavigationBar} from "./components/SlimNavigationBar/SlimNavigationBar";
import {Firebase} from "./utils/Firebase";
import {LoginView} from "./components/LoginView/LoginView";
import {AppState} from "./store";
import {connect} from "react-redux";
import {User} from "firebase";
import {RotateLoader} from "react-spinners";

interface Props {
    user: User;
    loading: boolean
}

Firebase.setup();

const App: React.FC<Props> = ({user, loading}) => {
    const renderContent = () => {
        if (user === null)
            return <LoginView/>;
        else {
            return <>
                <NavigationBar/>
                <ContentContainer/>
                <SlimNavigationBar/>
            </>
        }
    };

    return (
        <div className="App">
            {loading ? (
                <div className="Loader">
                    <RotateLoader
                        color={'#7bd4d7'}
                        loading={true}
                    />
                </div>) : renderContent()}
        </div>
    );
};

const mapStateToProps = (state: AppState) => ({
    user: state.account.user,
    loading: state.general.loading
});

export default connect(mapStateToProps)(App);
