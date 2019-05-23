import React from 'react';
import './App.scss';
import NavigationBar from "./components/NavigationBar/NavigationBar";
import ContentContainer from "./components/ContentContainer/ContentContainer";
import SlimNavigationBar from "./components/SlimNavigationBar/SlimNavigationBar";

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
