import React, { Component } from 'react'
import axios from 'axios'
import './signup.css'
class Signup extends Component {
    constructor(){
        super();

        this.state= {
            username: "",
            firstName: "",
            lastName: "",
            email: "",
            address:"",
            password: "",
            phoneNumber: "",
            services: "",
            workingDays: "",
            workingHours: "",
            redirect_url: null
        };
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(e){
        this.setState({[e.target.name]: e.target.value});
    }
    onSubmit(e){
        e.preventDefault();
        const newAccount = {
            username: this.state.username,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email,
            address: this.state.address,
            password: this.state.password,
            phoneNumber: this.state.phoneNumber,
            services: this.state.services,
            workingDays: this.state.workingDays,
            workingHours: this.state.workingHours
        }

        console.log(newAccount);
        axios.post('http://localhost:8080/api/account', newAccount)
        .then(function(result) {
            console.log(result)
            if(result.status >= 400 || result.status < 200) {
                throw new Error("ERROR LOGIN !");
            }else{
                alert("Signup Sucess")
                window.location.href = '/login'
            }
        })
        .catch(function(error) {
            console.error(error.message)
            alert(error.message)
        })
    }
    render() {
        return (
            <div className="Signup">
                <div class="container">
                    <div className="row">
                    <div className="col-md-8 m-auto">
                <h1>Sign Up</h1>
                <p>Please fill in this form to create an account.</p>
                <hr/>
                <form onSubmit={this.onSubmit}>
                <div className="form-group">
                <input type="text" className="form-control form-control-lg" placeholder="Person First Name" name="firstName"
                value = {this.state.firstName}
                onChange = {this.onChange}/>
                </div>
                <div className="form-group">
                <input type="text" className="form-control form-control-lg" placeholder="Person Last Name" name="lastName"
                value = {this.state.lastName}
                onChange = {this.onChange}/>    
                </div>
                <div className="form-group">
                <input type="text" className="form-control form-control-lg" placeholder="Person Address" name="address"
                value = {this.state.address}
                onChange = {this.onChange}/>
                </div>
                <div className="form-group">
                <input type="text" className="form-control form-control-lg" placeholder="Person email" name ="email"
                value = {this.state.email}
                onChange = {this.onChange}/>
                </div>
                <div className="form-group">
                <input type="text" className="form-control form-control-lg" placeholder="Person phone number" name ="phoneNumber"
                value = {this.state.phoneNumber}
                onChange = {this.onChange}/>
                </div>
                <div className="form-group">
                <input type="text" className="form-control form-control-lg" placeholder="Username" name ="username"
                value = {this.state.username}
                onChange = {this.onChange}/>
                </div>
                <div className="form-group">
                <input type="password" className="form-control form-control-lg" placeholder="Password" name ="password"
                value = {this.state.password}
                onChange = {this.onChange}/>
                </div>
                <input type="submit" className="bin btn-primary btn-block mt-4"/> 
                </form>
                    </div>
                </div>
            </div>
        
            </div>
        )
    }
}
export default Signup;