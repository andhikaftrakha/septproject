import React from 'react';
// import logo from './logo.svg';
import './App.css';
import Dashboard from './components/Dashboard';
import "bootstrap/dist/css/bootstrap.min.css";
import {BrowserRouter as Router, Route} from "react-router-dom";
import addAccount from './components/Account/addAccount';
import {Provider} from "react-redux";
import store from "./components/store";
import Contact from "./components/Aboutme/Contact"
function App() {
  return (
    <Provider store={store}>
    <Router>
    <div>
      <Dashboard/>
      <Route exact path="/dashboard" component={Dashboard} />
      <Route exact path="/AddAccount" component={addAccount} />
      <Route exact path="/contact" component={Contact} />
    </div>
    </Router>
    </Provider>
  );
}

export default App;
