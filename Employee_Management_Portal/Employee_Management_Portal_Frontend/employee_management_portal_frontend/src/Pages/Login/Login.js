import React, { useState } from "react";
import "./login.css";
import { useNavigate, Link } from "react-router-dom";
import AdminService from "../../components/service/AdminService";
import login_img from "../../Assests/Images/login_img.png";
import { Base64 } from "js-base64";
import AdminDashboard from "../AdminDashboard/AdminDashboard";
import EmployeeDashboard from "../EmployeeDashboard/EmployeeDashboard";
import { useEffect } from "react";
const Login = ({setIsLoggedIn ,login}) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [message, setMessage] = useState("");
  const[role,setRole] = useState(localStorage.getItem("userRole"));
  // const [isLoggedIn, setIsLoggedIn] = useState(false); 
  // const [showAlert, setShowAlert] = useState(false);

  const navigate = useNavigate();
  useEffect(() => {
    setRole(localStorage.getItem("userRole"));
  }, [])
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
          console.log(response.message);
          setPasswordError("Login Successful")
          console.log("role "+ response.data.role);
          // localStorage.setItem("role",response.data.role)
          // login();
            // Redirect to the "admindashboard" route
            if(response.data.role === "ADMIN") navigate('/admindashboard');
            if(response.data.role === "EMPLOYEE") navigate('/employeedashboard');
            if(response.data.role === "MANAGER") navigate('/managerdashboard')
  
            localStorage.setItem("userRole", response.data.role);
            localStorage.setItem("isLoggedIn", response.status);
            localStorage.setItem("email",email);
            localStorage.setItem("name",response.data.name);
            localStorage.setItem("id", response.data.id)
            // console.log(id)

        })
        .catch((error) => {
          setMessage("Wrong Credentials");
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
    <>
    {role? (role==='ADMIN'?(<AdminDashboard/>):(<EmployeeDashboard/>)):
  (
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
      {/* {showAlert && (
        <div className="popup">
          <p>{message}</p>
          <button onClick={() => setShowAlert(false)}>Close</button>
        </div>
      )} */}
    </div>
  )} </>
  );
};

export default Login;
