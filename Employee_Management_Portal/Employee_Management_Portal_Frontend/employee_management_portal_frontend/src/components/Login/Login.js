import React, { useState } from "react";
import "./login.css";
import { useNavigate, Link } from "react-router-dom";
import AdminService from "../service/AdminService";
import login_img from "../../Assests/Images/login_img.png";
import { Base64 } from "js-base64";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [message, setMessage] = useState("");
  const [showAlert, setShowAlert] = useState(false);

  const navigate = useNavigate();

  const encryptedPassword = Base64.encode(password);

  const onSubmit = (e) => {
    e.preventDefault();

    if (email === "" || password === "") {
      setEmailError("Please enter an Email");
      setPasswordError("Please enter a Password");
    } else {
      const formData = {
        email,
        password: encryptedPassword,
      };

      AdminService.loginAdmin(formData)
        .then((response) => {
          if (response.data.status === 200) {
            setShowAlert(true);
            setMessage("Login Successful");
            console.log(response.data);
            // navigate("/dashboard")
            setEmail("");
            setPassword("");
            
          } else {
            // Display an alert for "Wrong Credentials"
            setShowAlert(true);
            setMessage("Wrong Credentials");
            console.log(response.data);
            console.log(formData.password);
          }
        })
        .catch((error) => {
          console.log(error);
          setPasswordError("Incorrect Password");
        });
    }
  };

  const handleEmailBlur = () => {
    if (!email.endsWith("@nucleusteq.com") || email === "") {
      setEmailError("Please enter correct email.");
    }
  };

  return (
    <div className="container">
      <div className="login_section">
        <div className="login_heading">Employee Management Portal</div>

        <div className="login_form">
          <div>
            <div className="login_form_field">
              <input
                type="email"
                placeholder="Enter email"
                className="login_input_field"
                autoComplete="off"
                value={email}
                onChange={(e) => {
                  setEmail(e.target.value);
                  setEmailError("");
                }}
                onBlur={handleEmailBlur}
                required
              />
              {emailError && <div className="error-message">{emailError}</div>}
            </div>

            <div className="login_form_field">
              <input
                required
                type="password"
                placeholder="Password"
                className="login_input_field"
                autoComplete="off"
                value={password}
                onChange={(e) => {
                  setPassword(e.target.value);
                  setPasswordError("");
                }}
              />
              {passwordError && (
                <div className="error-message">{passwordError}</div>
              )}
            </div>
            {message && <div className="error-message">{message}</div>}
            <div className="login_form_field">
              <span>
                Not a user?
                <Link to="/register" className="login_reg">
                  Register
                </Link>
              </span>
            </div>
            <div className="button_container">
              <div
                variant="primary"
                type="submit"
                className="btn btn-primary"
                onClick={onSubmit}
              >
                <span className="btn-text">Login</span>
              </div>
            </div>
          </div>
        </div>
        <div>
          <img src={login_img} className="login_img" alt="Login" />
        </div>
      </div>
      {showAlert && (
        <div className="popup">
          <p>{message}</p>
          <button onClick={() => setShowAlert(false)}>Close</button>
        </div>
      )}
    </div>
  );
};

export default Login;
