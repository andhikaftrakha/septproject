import React, { Component } from 'react'

class addAccount extends Component {
    constructor(){
        super();

        this.state= {
            id: "",
            firstName: "",
            lastName: "",
            email: "",
            cNumber:"",
            created_Ap: "",
            end_Ap: ""
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
            id: this.state.id,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email,
            cNumber:this.state.cNumber,
            created_Ap: this.state.created_Ap,
            end_Ap: this.state.end_Ap
        }

        console.log(newAccount);
    }
    render() {
        return (
            <div className="Person">
            <div className="container">
                <div className="row">
                    <div className="col-md-8 m-auto">
                        <h5 className="display-4 text-center">Create / Edit Person form</h5>
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
                                <input type="text" className="form-control form-control-lg" placeholder="Person unique ID" name="id"
                                value = {this.state.id}
                                onChange = {this.onChange}/>
                                
                            </div>
                            <div className="form-group">
                                <input type="text" className="form-control form-control-lg" placeholder="Person cNumber" name="cNumber"
                                value = {this.state.cNumber}
                                onChange = {this.onChange}/>
                                
                            </div>
                            <div className="form-group">
                                <input type="text" className="form-control form-control-lg" placeholder="Person email" name ="email"
                                value = {this.state.email}
                                onChange = {this.onChange}/>
                                
                            </div>
                            <div className="form-group">
                                <input type="date" className="form-control form-control-lg" placeholder="Start date" name ="created_Ap"
                                value = {this.state.created_Ap}
                                onChange = {this.onChange}/>
                                
                            </div>
                            <div className="form-group">
                                <input type="date" className="form-control form-control-lg" placeholder="End date" name ="end_Ap"
                                value = {this.state.end_Ap}
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
export default addAccount;