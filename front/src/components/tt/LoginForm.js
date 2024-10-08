import * as React from 'react';

// import className from 'classNames';

export default class LoginForm extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            active: "login",
            firstName: "",
            lastName: "",
            login: "",
            password: "",
            onLogin: props.onLogin,
            onRegister: props.onRegister,
        }
    }

    onChangeHandler = (event) => {
        let name = event.target.name;
        let value = event.target.value;
        this.setState({[name]: value})
    }

    onSubmitLogin = (e) => {
        this.state.onLogin(e, this.state.name, this.state.password);
    }

    onSubmitRegister = (e) => {
        this.state.onRegister(
            e,
            this.state.firstName,
            this.state.lastName,
            this.state.login,
            this.state.password,
        );
    }

    render(){
        return (
            <div className="row justify-content-center">
                <div className="col-4">
                    <ul className="nav nav-pills nav-justified mb-3" id="ex1" rol="tablist">
                        <li className="nav-item" role="presentation">
                            <button className="nav-link">Login</button>
                        </li>

                        <li className="nav-item" role="presentation">
                            <button className="nav-link">Register</button>
                        </li>
                    </ul>

                    <div className="tab-content" id="pills-login">
                        <form onSubmit={this.onSubmitLogin}>
                            <div className="form-outline mb-4">
                                <input type="login" id="loginName" name="login" className="form-control" onChange={this.onChangeHandler}/>
                                <label className="form-control" htmlFor="loginName">Username</label>
                            </div>

                            <div className="form-outline mb-4">
                                <input type="password" id="loginPassword" name="password" className="form-control" onChange={this.onChangeHandler}/>
                                <label className="form-control" htmlFor="loginPassword">Password</label>
                            </div>

                            <button type="submit" className="btn btn-primary btn-block mb-4">Sign in</button>
                        </form>
                    </div>

                    <br/>

                    <div className="tab-content" id="pills-register">
                        <form onSubmit={this.onSubmitRegister}>
                            <div className="form-outline mb-4">
                                <input type="text" id="firstName" name="firstName" className="form-control" onChange={this.onChangeHandler}/>
                                <label className="form-control" htmlFor="firstName">First Name</label>
                            </div>

                            <div className="form-outline mb-4">
                                <input type="text" id="lastName" name="lastName" className="form-control" onChange={this.onChangeHandler}/>
                                <label className="form-control" htmlFor="lastName">Last Name</label>
                            </div>

                            <div className="form-outline mb-4">
                                <input type="text" id="login" name="login" className="form-control" onChange={this.onChangeHandler}/>
                                <label className="form-control" htmlFor="login">Username</label>
                            </div>

                            <div className="form-outline mb-4">
                                <input type="password" id="password" name="password" className="form-control" onChange={this.onChangeHandler}/>
                                <label className="form-control" htmlFor="password">Password</label>
                            </div>

                            <button type="submit" className="btn btn-primary btn-block mb-4">Sign in</button>
                        </form>
                    </div>

                </div>
            </div>
        );
    }
}