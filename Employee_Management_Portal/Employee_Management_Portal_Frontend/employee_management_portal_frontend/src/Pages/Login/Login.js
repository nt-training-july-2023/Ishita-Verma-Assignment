import React, { useState } from "react";
import "./login.css";
import { useNavigate, Link } from "react-router-dom";
import login_img from "../../Assests/Images/login_img.png";
import { Base64 } from "js-base64";
import AdminDashboard from "../AdminDashboard/AdminDashboard";
import EmployeeDashboard from "../EmployeeDashboard/EmployeeDashboard";
import { useEffect } from "react";
import Popup from "../../components/Popup/Popup";
import LoginRegisterService from "../../service/LoginRegisterService";
import InputField from "../../components/InputField/InputField";
import { validateEmployeeEmail,validateLoginPassword } from "../../components/HandleBlur/HandleBlur";

const Login = ({ setIsLoggedIn, login }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [message, setMessage] = useState("");
  const [role, setRole] = useState(localStorage.getItem("userRole"));
  const [showErrorPopup, setShowErrorPopup] = useState(false);

  const navigate = useNavigate();
  useEffect(() => {
    setRole(localStorage.getItem("userRole"));
  }, [])
  const encryptedPassword = Base64.encode(password);

  const onSubmit = (e) => {
    e.preventDefault();

    if (email === "" || password === "") {
    validateLoginPassword(password,setPasswordError)
     validateEmployeeEmail(email,setEmailError)
    } else {
      const formData = {
        email,
        password: encryptedPassword,
      };

      LoginRegisterService.login(formData)
        .then((response) => {
          console.log(response.message);
          setPasswordError("Login Successful")
          console.log("role " + response.data.role);
          if (response.data.role === "ADMIN") navigate('/admindashboard');
          if (response.data.role === "EMPLOYEE") navigate('/employeedashboard');
          if (response.data.role === "MANAGER") navigate('/managerdashboard')

          localStorage.setItem("role", response.data.role);
          localStorage.setItem("isLoggedIn", response.status);
          localStorage.setItem("email", email);
          localStorage.setItem("name", response.data.name);
          localStorage.setItem("id", response.data.id)

        })
        .catch((error) => {
          console.log(error);
          setMessage(error.response.data.message);
          setShowErrorPopup(true);
        });
    }
  };

  return (
    <>
      {role ? (role === 'ADMIN' ? (<AdminDashboard />) : (<EmployeeDashboard />)) :
        (
          <div className="container">
            <div className="login_section">
              <div className="login_heading">Employee Management Portal</div>

              <div className="login_form">
                <div>
                  <div className="login_form_field logout_placeholder">
                    <InputField
                      type="email"
                      placeholder="Enter email"
                      value={email}
                      onChange={(e) => {
                        setEmail(e.target.value);
                      }}
                      onBlur={() => validateEmployeeEmail(email, setEmailError)}
                      className="login_input_field"
                    />
                  </div>
                 
                  {emailError && <div className="error-message login_errors">{emailError}</div>}
         
                  <div className="login_form_field">
                    <InputField
                      type="password"
                      placeholder="Password"
                      value={password}
                      onChange={(e) => {
                        setPassword(e.target.value);
                      }}
                      className="login_input_field"
                      onBlur={() => validateLoginPassword(password, setPasswordError)}
                    />
                  </div>
                  {passwordError && (
                <div className="error-message login_errors">{passwordError}</div>
              )}
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
                  <div className="login_form_field">
                    <span className="login_text">
                      Not a user?
                      <Link to="/register" className="login_reg">
                        Register
                      </Link>
                    </span>
                  </div>

                </div>
              </div>
              <div>
                <img src={login_img} className="login_img" alt="Login" />
              </div>
            </div>
          </div>
        )}  {showErrorPopup && (
          <Popup
            description={message}
            onClose={() => setShowErrorPopup(false)}
          />
        )}</>
  );
};

export default Login;
