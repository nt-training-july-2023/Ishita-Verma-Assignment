import React, { useState } from "react";
import "./registration.css";
import { useNavigate, Link } from "react-router-dom";
import bcrypt from "bcryptjs";
import AdminService from "../../service/AdminService";
import reg_plant_img from "../../Assests/Images/reg_plant_img.png";
import reg_side_img from "../../Assests/Images/reg_side_img.png";
import Location from "../../components/Data/Location";
import Designation from "../../components/Data/Designation";
import LoginRegisterService from "../../service/LoginRegisterService";
import InputField from "../../components/InputField/InputField";
import {
  validateName,
  validateEmail,
  validateEmpId,
  validateDob,
  validateDoj,
  validateLocation,
  validateDesignation,
  validateContactNumber,
  validatePassword,
  validateConfirmPassword,
} from "../../components/HandleBlur/HandleBlur";

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

  // Validation error state
  const [nameError, setNameError] = useState("");
  const [emailError, setEmailError] = useState("");
  const [empIdError, setEmpIdError] = useState("");
  const [dobError, setDobError] = useState("");
  const [dojError, setDojError] = useState("");
  const [locationError, setLocationError] = useState("");
  const [designationError, setDesignationError] = useState("");
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
    if (
      !name ||
      !email ||
      !empId ||
      !dob ||
      !doj ||
      !location ||
      !designation ||
      !contactNumber ||
      !password ||
      !confirmPassword
    ) {
      validateName(name, setNameError);
      validateEmail(email, setEmailError);
      validateEmpId(empId, setEmpIdError);
      validateDob(dob, setDobError);
      validateDoj(doj, setDojError);
      validateLocation(location, setLocationError);
      validateDesignation(designation, setDesignationError);
      validateContactNumber(
        contactNumber,
        setContactNumber,
        setContactNumberError
      );
      validatePassword(password, setPasswordError);
      validateConfirmPassword(
        confirmPassword,
        password,
        setConfirmPasswordError
      );
      return;
    }

    let isValid = true;
    const hashedPassword = hashPassword(password);

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
        })
        .catch((error) => {
          console.log(error);

          if (
            error.response &&
            error.response.data &&
            error.response.data.message
          ) {
            setErrorMessage(error.response.data.message);
          } else {
            setErrorMessage("An error occurred while registering.");
          }
        });
    }
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
            <div className="reg_form_field">
            <label className="reg_form_field_label">Name :</label>
              <InputField
                type="text"
                placeholder="Name"
                value={name}
                className="reg_form_input"
                onChange={(e) => setName(e.target.value)}
                onBlur={() => validateName(name, setNameError)}
              />
            </div>
            {nameError && <div className="error-message reg_error">{nameError}</div>}

            <div className="reg_form_field">
            <label className="reg_form_field_label">Email :</label>
              <InputField
                type="email"
                placeholder="Email"
                value={email}
                className="reg_form_input"
                onChange={(e) => setEmail(e.target.value)}
                onBlur={() => validateEmail(email, setEmailError)}
              />
            </div>
            {emailError && <div className="error-message reg_error">{emailError}</div>}

            <div className="reg_form_field">
            <label className="reg_form_field_label">Employee ID :</label>
              <InputField
                type="text"
                placeholder="Employee ID"
                value={empId}
                className="reg_form_input"
                onChange={(e) => setEmpId(e.target.value)}
                onBlur={() => validateEmpId(empId, setEmpIdError)}
              />
            </div>
            {empIdError && <div className="error-message reg_error">{empIdError}</div>}

            <div className="reg_form_field">
            <label className="reg_form_field_label">Date of Birth :</label>
              <InputField
                type="date"
                placeholder="Date of Birth"
                value={dob}
                className="reg_form_input"
                onChange={(e) => setDob(e.target.value)}
                onBlur={() => validateDob(dob, setDobError)}
              />
            </div>
            {dobError && <div className="error-message reg_error">{dobError}</div>}

            <div className="reg_form_field">
            <label className="reg_form_field_label">Date of Joining :</label>
              <InputField
                type="date"
                placeholder="Date of Joining"
                value={doj}
                className="reg_form_input"
                onChange={(e) => setDoj(e.target.value)}
                onBlur={() => validateDoj(doj, setDojError)}
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
                onBlur={() => validateLocation(location, setLocationError)}
              >
                <option value="" className="select">
                  Select Location
                </option>
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
                onBlur={() =>
                  validateDesignation(designation, setDesignationError)
                }
              >
                <option value="" className="select">
                  Select Designation
                </option>
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
            <div className="reg_form_field">
            <label className="reg_form_field_label">Contact Number :</label>
              <InputField
                type="tel"
                placeholder="Contact Number"
                value={contactNumber}
                className="reg_form_input"
                onChange={(e) => setContactNumber(e.target.value)}
                onBlur={() =>
                  validateContactNumber(
                    contactNumber,
                    setContactNumber,
                    setContactNumberError
                  )
                }
              />
               {contactNumberError && ( <div className="error-message reg_error">{contactNumberError}</div>)}
            </div><div className="reg_form_field">
            <label className="reg_form_field_label">Password :</label>
              <InputField
                type="password"
                placeholder="Password"
                value={password}
                className="reg_form_input"
                onChange={(e) => setPassword(e.target.value)}
                onBlur={() => validatePassword(password, setPasswordError)}
                error={passwordError}
              />
                          {passwordError && (
              <div className="error-message reg_error">{passwordError}</div>
            )}

            </div><div className="reg_form_field">
            <label className="reg_form_field_label">Confirm Password :</label>
              <InputField
                type="password"
                placeholder="Confirm Password"
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
                className="reg_form_input"
                onBlur={() =>
                  validateConfirmPassword(
                    confirmPassword,
                    password,
                    setConfirmPasswordError
                  )
                }
              />
              {confirmPasswordError && (
              <div className="error-message reg_error">{confirmPasswordError}</div>
            )}
            </div>
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
};

export default Registration;
