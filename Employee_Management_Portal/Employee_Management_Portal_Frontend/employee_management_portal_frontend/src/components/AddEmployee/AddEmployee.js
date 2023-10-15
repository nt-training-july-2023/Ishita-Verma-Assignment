import React, { useState } from "react";
import "./addemployee.css";
import Role from "../Data/Role";
import Skills from "../Data/Skills";
import Designation from "../Data/Designation";
import AdminService from "../../service/AdminService";
import Location from "../Data/Location";
import bcrypt from "bcryptjs";
import MultiSelectDropdown from "../MultiSelectDropdown/MultiSelectDropdown";
import Popup from "../Popup/Popup";
import SubmitPopup from "../SubmitPopup/SubmitPopup";
import Button from "../Button/Button";
import InputField from "../InputField/InputField";
import {
  validateName,
  validateEmployeeEmail,
  validateEmpId,
  validateDob,
  validateLocation,
  validateDesignation,
  validateDoj,
  validateContactNumber,
  validateRole,
  validateSkills
} from "../../components/HandleBlur/HandleBlur";

const AddEmployee = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [empId, setEmpId] = useState("");
  const [dob, setDob] = useState("");
  const [doj, setDoj] = useState("");
  const [location, setLocation] = useState("");
  const [designation, setDesignation] = useState("");
  const [contactNumber, setContactNumber] = useState("");
  const [role, setRole] = useState("");
  const [skills, setSkills] = useState([]);
  const [selectedSkills] = useState([]);
  const [errorMessage, setErrorMessage] = useState("");

  const [showPopup, setShowPopup] = useState(false);
  const [showSubmitPopup, setShowSubmitPopup] = useState(false);
  const [popupMessage, setPopupMessage] = useState("");
  const [successMessage, setSuccessMessage] = useState("");

  const [showErrorPopUp, setShowErrorPopUp]= useState(false);
  const [popUpText, setPopUpText] = useState("");

  const [nameError, setNameError] = useState("");
  const [emailError, setEmailError] = useState("");
  const [empIdError, setEmpIdError] = useState("");
  const [dobError, setDobError] = useState("");
  const [dojError, setDojError] = useState("");
  const [locationError, setLocationError] = useState("");
  const [designationError, setDesignationError] = useState("");
  const [contactNumberError, setContactNumberError] = useState("");
  const [skillsError, setSkillsError] = useState("");
  const [roleError, setRoleError] = useState("");

  const handleSkillChange = (selectedOptions) => {
    console.log(selectedOptions);
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
    setSkillsError("");
  };

  const handleSubmit = (e) => {
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
      !role ||
      skills.length === 0 

    ) {
      validateName(name, setNameError);
      validateEmployeeEmail(email, setEmailError)
      validateEmpId(empId, setEmpIdError)
      validateDob(dob, setDobError)
      validateDoj(doj, setDojError)
      validateLocation(location, setLocationError)
      validateDesignation(designation, setDesignationError)
      validateContactNumber(contactNumber, setContactNumber, setContactNumberError)
      validateRole(role, setRoleError)
      validateSkills(skills, setSkillsError)
      return;
    }
    const replaceDob = dob.replaceAll("-", "");
    const pwd = empId + "@" + replaceDob;
    const password = bcrypt.hashSync(pwd, 10);
 
      const employee = {
        name,
        email,
        empId,
        dob,
        doj,
        location,
        designation,
        contactNumber,
        role,
        skills,
        password,
      };

      AdminService.addEmployee(employee)
        .then((response) => {
          console.log(response);
          setErrorMessage("Employee Added Successfully ");
          setShowSubmitPopup(true);
        })
        .catch((error) => {
          console.log(error);
          if (error.response && error.response.data) {
            if (error.response.data.message === "User with this email already exists.") {
              setPopUpText(
                "Email already in use. Please use a different email."
              );
              setShowErrorPopUp(true);
            } else if (
              error.response.data.message === "Employee id already exists."
            ) {
              setPopUpText("Employee Id already in use.");
              setShowErrorPopUp(true);
            }
          } else {
            setPopUpText("Error occurred while adding.");
            setShowErrorPopUp(true);
          }
        });
    }

  const renderPopup = () => {
    if (showPopup) {
      return (
        <Popup
          description={popupMessage}
          onClose={() => setShowPopup(false)}
          onConfirm={() => setShowPopup(false)}
        />
      );
    }
    return null;
  };

  return (
    <>
    <div className="add_employee_container">
      <div className="add_employee">
        <form autoComplete="off" onSubmit={handleSubmit}>
          <h2 style={{ color: "white" }}>Add Employee</h2>

          <div className="input_form_field">
            <InputField
              type="text"
              id="name"
              className="custom-placeholder "
              value={name}
              placeholder="Employee Name"
              onChange={(e) => setName(e.target.value)}
              onBlur={() => validateName(name, setNameError)}
            />
            {setNameError && <div className="error-message employee_errors">{nameError}</div>}
          </div>

          <div className="input_form_field">
            <InputField
              type="text"
              id="empId"
              className="custom-placeholder "
              value={empId}
              placeholder="Employee Id"
              onChange={(e) => setEmpId(e.target.value)}
              onBlur={() => validateEmpId(empId, setEmpIdError)}
            />
            {empIdError && <div className="error-message employee_errors">{empIdError}</div>}
          </div>

          <div className="input_form_field">
            <InputField
              type="email"
              id="email"
              className="custom-placeholder addemployee_dropdown"
              value={email}
              placeholder="Email"
              onChange={(e) => setEmail(e.target.value)}
              onBlur={() => validateEmployeeEmail(email, setEmailError)}
            />
            {emailError && <div className="error-message employee_errors">{emailError}</div>}
          </div>

          <div className="input_form_field">
            <label className="date_label">DOB</label>
            <InputField
              type="date"
              id="dob"
              className="custom-placeholder"
              value={dob}
              onChange={(e) => setDob(e.target.value)}
              onBlur={() => validateDob(dob, setDobError)}
            />
            {dobError && <div className="error-message employee_errors">{dobError}</div>}
          </div>

          <div className="input_form_field">
            <label className="date_label">DOJ</label>
            <InputField
              type="date"
              id="doj"
              className="custom-placeholder"
              value={doj}
              onChange={(e) => setDoj(e.target.value)}
              onBlur={() => validateDoj(doj, setDojError)}
            />
            {dojError && <div className="error-message employee_errors">{dojError}</div>}
          </div>

          <div className="input_form_field">
            <select
              className="custom-placeholder addemployee_dropdown"
              value={location}
              onChange={(e) => setLocation(e.target.value)}
              onBlur={() => validateLocation(location, setLocationError)}
            >
              <option value="">Select Location</option>
              {Location.map((item) => {
                return (
                  <option key={item} value={item}>
                    {item}
                  </option>
                );
              })}
            </select>
            {locationError && (
              <div className="error-message employee_errors">{locationError}</div>
            )}
          </div>

          <div className="input_form_field">
            <select
              className="custom-placeholder addemployee_dropdown"
              value={designation}
              onChange={(e) => setDesignation(e.target.value)}
              onBlur={() => validateDesignation(designation, setDesignationError)}
            >
              <option value="">Select Designation</option>
              {Designation.map((item) => {
                return (
                  <option key={item} value={item}>
                    {item}
                  </option>
                );
              })}
            </select>
            {designationError && (
              <div className="error-message employee_errors">{designationError}</div>
            )}
          </div>

          <div className="input_form_field">
            <InputField
              type="tel"
              id="contactNumber"
              className="custom-placeholder addemployee_dropdown"
              value={contactNumber}
              placeholder="Contact Number"
              onChange={(e) => setContactNumber(e.target.value)}
              onBlur={() => validateContactNumber(contactNumber, setContactNumber, setContactNumberError)}
            />
            {contactNumberError && (
              <div className="error-message employee_errors">{contactNumberError}</div>
            )}
          </div>

          <div className="input_form_field">
            <select
              className="custom-placeholder addemployee_dropdown"
              value={role}
              onChange={(e) => setRole(e.target.value)}
              onBlur={() => validateRole(role, setRoleError)}
            >
              <option value="">Select Role</option>
              {Role.map((item) => {
                return (
                  <option key={item} value={item}>
                    {item}
                  </option>
                );
              })}
            </select>
            {roleError && <div className="error-message employee_errors">{roleError}</div>}
          </div>

          <div className="input_form_field">
            <MultiSelectDropdown
              options={Skills.map((skill) => ({
                value: skill,
                label: skill,
              }))}
              selectedOptions={selectedSkills.map((skill) => ({
                value: skill,
                label: skill,
              }))}
              onChange={handleSkillChange}
              placeholder="Select Skills"
              onBlur={() => validateSkills(skills, setSkillsError)}
            />
            {skillsError && <div className="error-message employee_errors">{skillsError}</div>}
          </div>
          {errorMessage && <div className="error-message">{errorMessage}</div>}
       <Button className="btn_submit" type="submit" text="Add Employee"/>
        </form>
        {renderPopup()}
      </div>
      {showSubmitPopup && (
  <SubmitPopup
    description={errorMessage}
    onClose={() => setShowSubmitPopup(false)} 
    onConfirm={() => setShowSubmitPopup(false)} 
  />
)}
 {showErrorPopUp && (
            <Popup
            description={popUpText}
            onClose={() => {
              setShowErrorPopUp(false);
            }}
            />
          )}
    </div>
    </>
  );
};

export default AddEmployee;
