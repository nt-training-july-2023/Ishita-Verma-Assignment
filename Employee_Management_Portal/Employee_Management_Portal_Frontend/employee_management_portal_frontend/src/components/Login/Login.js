import React, { useState } from "react";
import "./login.css";
import { useAuth } from "../service/AuthenticationContext";
import { Link,useNavigate } from "react-router-dom";
import AdminService from "../service/AdminService";
import login_img from "../../Assests/Images/login_img.png";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [emailError, setEmailError] = useState("");
  // const [errorMessage, setErrorMessage] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const navigate = useNavigate();
 

  
  // const { setIsLoggedIn } = useAuth();

  const onSubmit = (e) => {
    e.preventDefault();

    
    // let isValid = true;
    // if (!email.endsWith("admin@nucleusteq.com")) {
    //   setEmailError("Please enter correct credentials.");
    //   isValid = false;
    // } else {
    //   setEmailError("");
    // }

    if(email==="" || password===""){
      setEmailError("Incorrect Email");
      setPasswordError("Incorrect Password")
    }

      else{const formData = {
        email,
        password,
      };

      AdminService.loginAdmin(formData)
        .then((response) => {
          console.log(response.data);
          console.log(response.data.message);
          console.log(response.data.status);
          // navigate("/dashboard");
          
        })
        .catch((error) => {
          console.log(error);
          setPasswordError("Incorrectttttttt Password");
        });
        
  };
}

  const handleEmailBlur = () => {
    if (!email.endsWith("@nucleusteq.com") || email==="") {
      setEmailError("Please enter correct credentials.");
    } 
  };

  // const handlePasswordBlur = (e) => {
  //   const inputValue = e.target.value;
  //   const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~]).{8,}$/;

  //   if (!passwordRegex.test(inputValue)) {
  //     setPasswordError(
  //       "Use uppercase lowercase number special character."
  //     );
  //   } else {
  //     setPasswordError("");
  //   }
  // };

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
                  setPassword(e.target.value)
                  setPasswordError("")
                }
                  }
                // onBlur={handlePasswordBlur}
              />
              {passwordError && <div className="error-message">{passwordError}</div>}
            </div>
            {/* {errorMessage && <div className="error-message">{errorMessage}</div>} */}
            <div className="login_form_field">
              <span>
                Not a user?
                <Link to="/register" className="login_reg">
                  Register
                </Link>
              </span>
            </div>
            <div class="button_container">
              <div
                variant="primary"
                type="submit"
                className="btn btn-primary"
                onClick={onSubmit}
              >
                <span className="btn-text">Submit</span>
              </div>
            </div>
          </div>
        </div>
        <div>
          <img src={login_img} className="login_img" alt="Login" />
        </div>
      </div>
    </div>
  );
};

export default Login;
