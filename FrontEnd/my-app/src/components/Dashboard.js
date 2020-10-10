import React, { Component } from 'react'
import "bootstrap/dist/css/bootstrap.min.css";
import './sidebar.css';
import './login/Login.js';
import Appointment from './Account/addAccount';
import Team from './TeamMember';
import Contact from './Aboutme/Contact';
import Signup from './login/Signup';
import Schedule from './Schedule';
import Login from './login/Login';
import AccountForm from './Account/addAccount';
import { Helmet } from 'react-helmet'
import{
  BrowserRouter as Router, Route, Link
} from "react-router-dom";
import Button from 'react-bootstrap/Button';


class Dashboard extends Component {

  constructor() {
    super()

    this.state = {

    }

    this.onClick = this.logout.bind(this)
  }

  logout(e) {
    window.localStorage.setItem('is_login', 'N')
    window.location.href='/'
  }

    render() {
      var nav;
      if(window.localStorage.getItem('is_login') == 'Y') {
        nav = <nav  className="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <button className="btn btn-primary" id="log-in"onClick={this.logout} >Logout</button>
      </nav>
      }else{
        nav = <nav  className="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <Link to="/login"><button className="btn btn-primary" id="log-in" >Login</button></Link>
        <Link to="/signup"><button className="btn btn-secondary pull-right" id="sign-up" >Signup</button></Link> 
        </nav>
      }
        return (
          <Router>
            <div>
              <Helmet>
                  <title>
                    Dashboard
                  </title>
              </Helmet>
              <div className="d-flex" id="wrapper">
                <div className="bg-light border-right" id="sidebar-wrapper">
                <div className="sidebar-heading">Dashboard </div>
                <div className="list-group ">
                  <ul>
                    <li>
                      <Link to="/schedule">Schedule</Link>
                    </li>
                    <li>
                      <Link to="/team">Team</Link>
                    </li>
                    <li>
                      <Link to="/about">Contact</Link>
                    </li>
                    <li>
                      <Link to ="/accountForm">Account Form</Link>
                    </li>
                  </ul>
                </div>
                </div>
                <div id="page-content-wrapper">
              {nav}

      <div className="container-fluid">
        
        <Route exact path="/about" component={Contact}/>
        <Route exact path="/signup" component={Signup}/>
        <Route exact path="/schedule" component={Schedule}/>
        <Route exact path="/team" component={Team}/>
        <Route exact path="/login" component={Login}/>
        <Route exact path="/accountForm" component={AccountForm}/>
  
      </div>
    </div>
    </div>
    </div>
        </Router>
        )
        }
        }
 

export default Dashboard;