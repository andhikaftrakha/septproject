import React, { Component } from 'react'
import "bootstrap/dist/css/bootstrap.min.css"
class login extends Component {
    render() {
        return (
            <div>
                <h1>Login/Signup</h1>
                <form id="loginForm" method="post">
                    <header>Logging In</header>
                    <label>Username</label>
                    <input type="text" name="username" placeholder="Username" value="" required></input>
                    <label>Password</label>
                    <input type="password" name="password" placeholder="Password" value="" required></input>
                    <input type="submit" value="Log In"></input>    
                </form>
            </div>
        )
    }
}

export default login;