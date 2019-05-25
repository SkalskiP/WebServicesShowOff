import React from 'react';
import './App.scss';
import SlimNavigationBar from "./components/SlimNavigationBar/SlimNavigationBar";
import {NavigationBar} from "./components/NavigationBar/NavigationBar";
import {ContentContainer} from "./components/ContentContainer/ContentContainer";

const App: React.FC = () => {
  return (
      <div className="App">
        <NavigationBar/>
        <ContentContainer/>
        <SlimNavigationBar/>
      </div>
  );
};

export default App;
