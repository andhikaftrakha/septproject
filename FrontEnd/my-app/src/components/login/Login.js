import React, { Component } from 'react'
import axios from 'axios'
import './login.css';

class Login extends Component {

    constructor() {
        super()

        this.state = {
            username:"",
            password:""
        }

        this.onChange = this.onChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
    }

    onChange(e){
        this.setState({[e.target.name]: e.target.value});
    }

    onSubmit(e){
        e.preventDefault();
        const form_login = {
            username:this.state.username,
            password:this.state.password
        }

        axios.post('http://localhost:8080/api/account/login', form_login)
        .then(function(result) {
            console.log(result)
            var data = result.data
            console.log("Type data :" + typeof(data))
            if(result.status>=400 || result.status<200){
                throw new Error('login fail')
            }else{
                if(data['status']=='success') {
                    alert(data['message'])
                    window.localStorage.setItem('is_login', 'Y')
                    window.location.href = '/'
                }else{
                    alert(data['message'])
                }
               
            }
        })
        .catch(function(error){
            console.log(error)
        })


    }
    render() {
        return (
            <div>
            <form onSubmit={this.onSubmit}>
            <div className="container">
            <h1>Login</h1>
            <p>Please Enter your username and password.</p>
            
            <label htmlFor="username"><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="username" value={this.state.username} onChange={this.onChange} required></input>
            <label htmlFor="password"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" value={this.state.password} onChange={this.onChange} required></input>

            <div className="clearfix">
                <button type="submit" className="signupbtn">Login</button>
            </div>
            </div>
            </form>
        </div>

        )
    }
}
export default Login;