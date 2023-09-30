import { React, useState } from "react";
import "./registration.css";
import { useNavigate, Link } from "react-router-dom";
import bcrypt from 'bcryptjs';
import AdminService from "../../service/AdminService";
import reg_plant_img from "../../Assests/Images/reg_plant_img.png";
import reg_side_img from "../../Assests/Images/reg_side_img.png";
import Location from "../../components/Data/Location";
import Designation from "../../components/Data/Designation";
import {
  validateName,
  validateEmail,
  validateEmpId,
  validateDob,
  validateDoj,
  validateContactNumber,
  validatePassword,
  validateConfirmPassword,
} from "../../components/HandleBlur/HandleBlur"; 
import LoginRegisterService from "../../service/LoginRegisterService";

const Registration = () => {
  const [id, setId] = useState("");
  const [empId, setEmpId] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [dob, setDob] = useState("");
  const [doj, setDoj] = useState("");
  const [location, setLocation] = useState("");
  const [designation, setDesignation] = useState("");
  const [contactNumber, setContactNumber] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  //for validations
  const [nameError, setNameError] = useState("");
  const [emailError, setEmailError] = useState("");
  const [empIdError, setEmpIdError] = useState("");
  const [dobError, setDobError] = useState("");
  const [dojError, setDojError] = useState("");
  const [locationError, setLocationError] = useState("");
  const [designationError, setDesignationError]  = useState("");
  const [contactNumberError, setContactNumberError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [confirmPasswordError, setConfirmPasswordError] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [duplicateEmailError, setDuplicateEmailError] = useState("");
  
  const navigate = useNavigate();

  const hashPassword = (password) => {
    return bcrypt.hashSync(password, 10);
  };

  const onSubmit = (e) => {
    e.preventDefault();

    // onBlur validations for each input field
    const alphabeticRegex = /^[A-Za-z]+(?:\s[A-Za-z]+)*$/;
    const emailRegex = /^ankita\.sharma@nucleusteq\.com$/;
    // const emailRegex = /^[a-zA-Z0-9._%+-]+@nucleusteq\.com$/;
    const empIdRegex = /^[Nn][1-9][0-9]{3}$/;
    const dateRegex = /^\d{4}-\d{2}-\d{2}$/;
    const today = new Date();
    const minDate = new Date(today.getFullYear() - 18, today.getMonth(), today.getDate());
    const cleanedContactNumber = contactNumber.replace(/[^0-9]/g, "");
    const passwordRegex =
      /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~]).{8,}$/;

    
    let isValid = true;
    const hashedPassword = hashPassword(password);
    if (!alphabeticRegex.test(name)) {
      setNameError("Name must contain alphabetic characters only");
      isValid = false;
    } else {
      setNameError("");
    }

    if (!emailRegex.test(email)) {
      setEmailError("Email must be a company email (@nucleusteq.com)");
      isValid = false;
    } else {
      setEmailError("");
    }
    
    if (!empIdRegex.test(empId)) {
      setEmpIdError("Employee ID should be in pattern NXXXX");
      isValid = false;
    } else {
      setEmpIdError("");
    }

    const dobDate = new Date(dob);
    const dojDate = new Date(doj);

    if (isNaN(dobDate)) {
      setDobError("Invalid date format.");
      isValid = false;
    } else if (dobDate > today) {
      setDobError("Date of Birth cannot be in the future.");
      isValid = false;
    } else if (dobDate > minDate) {
      setDobError("You must be at least 18 years old.");
      isValid = false;
    } else {
      setDobError("");
    }

    if (!dateRegex.test(doj)) {
      setDojError("Date should have a pattern like  DD-MM-YY");
      isValid = false;
    } else if (isNaN(dojDate) || dojDate > today) {
      setDojError("Date of Joining cannot be in the future.");
      isValid = false;
    } else {
      setDojError("");
    }

    if(location === ""){
     setLocationError("Required can't be empty.")
    }

    if (designation === ""){
      setDesignationError("Required can't be empty.")
    }

    if (!/^\d{10}$/.test(cleanedContactNumber)) {
      setContactNumberError("Contact no should have 10 digits only");
      isValid = false;
    } else {
      setContactNumber(cleanedContactNumber);
      setContactNumberError("");
    }

    if (!passwordRegex.test(password)) {
      setPasswordError("Use 8 digits uppercase lowercase special character");
      isValid = false;
    } else {
      setPasswordError("");
    }
    

    if (confirmPassword !== password) {
      setConfirmPasswordError("Password and confirm password do not match");
      isValid = false;
    } else {
      setConfirmPasswordError("");
    }

    if (isValid) {
      const formData = {
        id,
        empId,
        name,
        email,
        dob,
        doj,
        location,
        designation,
        contactNumber,
        password: hashedPassword, 
      confirmPassword: hashedPassword,
      }; 
      formData.managerId = 0; 
      formData.role = "ADMIN"; 
      LoginRegisterService.addAdmin(formData)
        .then((response) => {
          console.log(response.data);
          setDuplicateEmailError("");
          setErrorMessage("Registered Successfully");

          setEmpId("");
          setName("");
          setEmail("");
          setDob("");
          setDoj("");
          setLocation("");
          setDesignation("");
          setContactNumber("");
          setPassword("");
          setConfirmPassword("");

          // navigate("/register");
        })
        .catch((error) => {
          console.log(error);

          if (error.response && error.response.data && error.response.data.message) {  
            setErrorMessage(error.response.data.message);
            console.log("error");
          }
          else {
            setErrorMessage("An error occurred while registering.");
            // console.log(error.response.status);
          }
        });
    }
  };
  const handleNameBlur = (e) => {
    const inputValue = e.target.value;
    validateName(inputValue, setNameError);
  };

  const handleEmailBlur = (e) => {
    const inputValue = e.target.value;
    validateEmail(inputValue, setEmailError);
  };

  const handleEmpIdBlur = (e) => {
    const inputValue = e.target.value;
    validateEmpId(inputValue, setEmpIdError);
  };

  const handleDobBlur = (e) => {
    const inputValue = e.target.value;
    validateDob(inputValue, setDobError);
  };

  const handleDojBlur = (e) => {
    const inputValue = e.target.value;
    validateDoj(inputValue, setDojError);
  };

  const handleContactNumberBlur = (e) => {
    const inputValue = e.target.value;
    validateContactNumber(inputValue, setContactNumber, setContactNumberError);
  };

  const handlePasswordBlur = (e) => {
    const inputValue = e.target.value;
    validatePassword(inputValue, setPasswordError);
  };

  const handleConfirmPasswordBlur = (e) => {
    const inputValue = e.target.value;
    validateConfirmPassword(inputValue, password, setConfirmPasswordError);
  };

  return (
    <div className="container">
      <div className="reg_heading">
        <div>
          Employee Management Portal
          <img src={reg_plant_img} className="reg_plant_img" />
        </div>
      </div>
      <div className="reg_page">
        <div className="reg_form">
          <div>
            <div className=" reg_form_field">
            <label className="reg_form_field_label">Name :</label>
              <input
                type="text"
                placeholder="Name "
                className="reg_form_input"
                value={name}
                onChange={(e) => setName(e.target.value)}
                autoComplete="off"
                onBlur={handleNameBlur}
              />
            </div>
            {nameError && <div className="error-message reg_error">{nameError}</div>}

            <div className=" reg_form_field">
              <label className="reg_form_field_label" >Email :</label>
              <input
                type="email"
                placeholder="Email"
                className="reg_form_input"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                autoComplete="off"
                onBlur={handleEmailBlur}
                required
              />
            </div>
            {emailError && <div className="error-message reg_error">{emailError}</div>}

            <div className=" reg_form_field">
      <label className="reg_form_field_label">Employee ID :</label>
              <input
                type="text"
                placeholder="Employee ID"
                className="reg_form_input"
                value={empId}
                onChange={(e) => setEmpId(e.target.value)}
                autoComplete="off"
                onBlur={handleEmpIdBlur}
                required
              />
            </div>
            {empIdError && <div className="error-message reg_error">{empIdError}</div>}

            <div className=" reg_form_field">
             
                <label className="reg_form_field_label">DOB :</label>
               
              <input
                type="date"
                className="reg_form_input"
                value={dob}
                onChange={(e) => setDob(e.target.value)}
                onBlur={handleDobBlur}
                required
              />
            </div>
            {dobError && <div className="error-message reg_error">{dobError}</div>}

            <div className=" reg_form_field" controlId="formBasicEmail">

                <label className="reg_form_field_label">DOJ :</label>
              
              <input
                type="date"
                className="reg_form_input"
                value={doj}
                onChange={(e) => setDoj(e.target.value)}
                onBlur={handleDojBlur}
                required
              />
            </div>
            {dojError && <div className="error-message reg_error">{dojError}</div>}

            <div className=" reg_form_field">
               <label className="reg_form_field_label">Location :</label>
              <select
                className="reg_form_input"
                type="text"
                name="location"
                placeholder="Enter Location"
                onChange={(e) => setLocation(e.target.value)}
              >
                <option value="" className="select" >Select Location</option>
                {Location.map((item) => {
                  return (
                    <option key={item} value={item} className="select">
                      {item}
                    </option>
                  );
                })}
              </select>
            </div>
            {locationError && (
                <div className="error-message reg_error">{locationError}</div>
            )}

            <div className=" reg_form_field">
              <label className="reg_form_field_label">Designation :</label>
              <select
                className="reg_form_input"
                type="text"
                name="designation"
                placeholder="Enter Designation"
                onChange={(e) => setDesignation(e.target.value)}
              >
                <option value="" className="select" >Select Designation</option>
                {Designation.map((item) => {
                  return (
                    <option key={item} value={item} className="select">
                      {item}
                    </option>
                  );
                })}
              </select>
            </div>
            {designationError && (
  <div className="error-message reg_error">{designationError}</div>
)}

            <div className=" reg_form_field">
               <label className="reg_form_field_label">Contact Number :</label>
              <input
                type="tel"
                placeholder="Contact Number"
                className="reg_form_input"
                value={contactNumber}
                onChange={(e) => setContactNumber(e.target.value)}
                onBlur={handleContactNumberBlur}
                required
              />
            </div>
            {contactNumberError && (
              <div className="error-message reg_error">{contactNumberError}</div>
            )}

            <div className=" reg_form_field">
              <label className="reg_form_field_label">Password :</label>
              <input
                type="password"
                placeholder="Password"
                className="reg_form_input"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                onBlur={handlePasswordBlur}
                required
              />
            </div>
            {passwordError && (
              <div className="error-message reg_error">{passwordError}</div>
            )}

            <div className=" reg_form_field">
              <label className="reg_form_field_label">Confirm Password :</label>
              <input
                type="password"
                placeholder="Confirm Password"
                className="reg_form_input"
                required
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
                onBlur={handleConfirmPasswordBlur}
              />
            </div>
            {confirmPasswordError && (
              <div className="error-message reg_error">{confirmPasswordError}</div>
            )}
          </div>
          {errorMessage && <div className="error-message">{errorMessage}</div>}
          <div class="button_reg">
            <div className="btn" onClick={onSubmit} type="submit">
              <span className="btn-text">Submit</span>
            </div>
            <div className="btn" onClick={() => navigate("/")}>
              <span className="btn-text">Login</span>
            </div>
          </div>
        </div>

        <div>
          <img src={reg_side_img} className="reg_side_img" />
        </div>
      </div>
    </div>
  );
}

export default Registration;
