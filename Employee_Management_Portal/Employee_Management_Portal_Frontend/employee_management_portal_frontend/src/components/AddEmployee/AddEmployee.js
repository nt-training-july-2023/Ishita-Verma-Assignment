import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "./addemployee.css";
import Role from "../Data/Role";
import Skills from "../Data/Skills";
import Designation from "../Data/Designation";
import AdminService from "../../service/AdminService";
import Location from "../Data/Location";
import bcrypt from 'bcryptjs';
import MultiSelectDropdown from "../MultiSelectDropdown/MultiSelectDropdown";
import Popup from "../Popup/Popup";
import {
  validateName,
  validateEmail,
  validateEmpId,
  validateDob,
  validateDoj,
  validateContactNumber,
} from "../../components/HandleBlur/HandleBlur"; 

const AddEmployee = () => {
  // Define state variables for each form field
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
  const [selectedSkills] = useState([])
  const [errorMessage, setErrorMessage] = useState("");

 // Add state for the popup
 const [showPopup, setShowPopup] = useState(false);
 const [popupMessage, setPopupMessage] = useState("");

  // Define state variables for validation errors
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

  // Handle skill selection changes
    const handleSkillChange = (selectedOptions) => {
      console.log(selectedOptions);
      const selectedSkillsValues = selectedOptions.map((option) => option.value);
      setSkills(selectedSkillsValues);
    };
const navigate = useNavigate();

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();

    // Validate each form field
    const alphabeticRegex = /^[A-Za-z]+(?:\s[A-Za-z]+)*$/;
    // const emailRegex = /^ankita\.sharma@nucleusteq\.com$/;
    const emailRegex = /^[a-zA-Z0-9._%+-]+@nucleusteq\.com$/;
    const empIdRegex = /^[Nn]\d{4}$/;
    const dateRegex = /^\d{4}-\d{2}-\d{2}$/;
    const today = new Date();
    const minDate = new Date(
      today.getFullYear() - 18,
      today.getMonth(),
      today.getDate()
    );
    const cleanedContactNumber = contactNumber.replace(/[^0-9]/g, "");

    let isValid = true;

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

    if (location === "") {
      setLocationError("Required can't be empty.");
    }

    if (designation === "") {
      setDesignationError("Required can't be empty.");
    }

    if(role === ""){
      setRoleError("Required can't be empty.")
    }

    if (!/^\d{10}$/.test(cleanedContactNumber)) {
      setContactNumberError("Contact no should have 10 digits only");
      isValid = false;
    } else {
      setContactNumber(cleanedContactNumber);
      setContactNumberError("");
    }

    // If any field is invalid, return and don't submit

    // Create an employee object with form data
    const replaceDob = dob.replaceAll("-","");
    const pwd = empId + "@" + replaceDob;
    const password = bcrypt.hashSync(pwd, 10);
    if(isValid){
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

  //  console.log(employee);
    AdminService.addEmployee(employee)
      .then((response) => {
       console.log(response);
       setErrorMessage("Successfully Added")
       const navigateToDashboard = () => {
        navigate("/EmployeeDashboard");
    };
    setTimeout(navigateToDashboard, 2000);
        // setPopupMessage("Employee added successfully.");
          // setShowPopup(true);

        // clearFormFields();
      })
      .catch((error) => {
       
        console.log(error);
        if (error.response && error.response.data) {
          if (error.response.data.message === "Email id already exists") {
            setErrorMessage(
              "Email is already in use. Please use a different email."
            );
          } else if (
            error.response.data.message === "Employee Id already exists"
          ) {
            setErrorMessage("EmpId already exists");
          }
        } else {
          setErrorMessage("Error occurred while adding.");
        }
      });
    }
  };

  // Function to clear form fields
  const clearFormFields = () => {
    setName("");
    setEmail("");
    setEmpId("")
    setDob("");
    setDoj("");
    setLocation(null);
    setDesignation(null);
    setContactNumber("");
    setRole(null);
    setSkills([]);
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
    <div className="add_employee_container">
    <div className="add_employee">
      <form autoComplete="off" onSubmit={handleSubmit}>
        <h2 style={{color:"white"}}>Add Employee</h2>
        
        <div className="input_form_field">
          <input
            type="text"
            id="name"
            className="custom-placeholder"
            value={name}
            placeholder="Name"
            onChange={(e) => setName(e.target.value)}
            onBlur={handleNameBlur}
          />
          {nameError && <div className="error-message">{nameError}</div>}
        </div>
        <div className="input_form_field">
          <input
            type="text"
            id="empId"
            className="custom-placeholder "
            value={empId}
            placeholder="Employee Id"
            onChange={(e) => setEmpId(e.target.value)}
            onBlur={handleEmpIdBlur}
          />
          {empIdError && <div className="error-message">{empIdError}</div>}
        </div>

        <div className="input_form_field">
         
          <input
            type="email"
            id="email"
            className="custom-placeholder addemployee_dropdown"
            value={email}
            placeholder="Email"
            onChange={(e) => setEmail(e.target.value)}
            onBlur={handleEmailBlur}
          />
          {emailError && <div className="error-message">{emailError}</div>}
        </div>

        <div className="input_form_field">
        <label className="date_label">DOB</label>
          <input
            type="date"
            id="dob"
            className="custom-placeholder"
            value={dob}
            onChange={(e) => setDob(e.target.value)}
            onBlur={handleDobBlur}
          />
          {dobError && <div className="error-message">{dobError}</div>}
        </div>

        <div className="input_form_field">
        <label className="date_label">DOJ</label>
          <input
            type="date"
            id="doj"
            className="custom-placeholder"
            value={doj}
            onChange={(e) => setDoj(e.target.value)}
            onBlur={handleDojBlur}
          />
          {dojError && <div className="error-message">{dojError}</div>}
        </div>

        <div className="input_form_field">
        <select
  className="custom-placeholder addemployee_dropdown"
  value={location}
  onChange={(e) => setLocation(e.target.value)}
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
  <div className="error-message">{locationError}</div>
)}

        </div>

        <div className="input_form_field">
          <select
            className="custom-placeholder addemployee_dropdown"
            value={designation}
            onChange={(e) => setDesignation(e.target.value)}
            
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
            <div className="error-message">{designationError}</div>
          )}
        </div>

        <div className="input_form_field">
          <input
            type="tel"
            id="contactNumber"
            className="custom-placeholder addemployee_dropdown"
            value={contactNumber}
            placeholder="Contact Number"
            onChange={(e) => setContactNumber(e.target.value)}
            onBlur={handleContactNumberBlur}
          />
          {contactNumberError && (
            <div className="error-message">{contactNumberError}</div>
          )}
        </div>

        <div className="input_form_field">
          <select
            className="custom-placeholder addemployee_dropdown"
            value={role}
            onChange={(e) => setRole(e.target.value)}
            
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
          {roleError && <div className="error-message">{roleError}</div>}
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
            // onBlur={validateSkillsRequired}
          />
          {skillsError && <div className="error-message">{skillsError}</div>}
        </div>
       {/* Display error message if there is one */}
       {errorMessage && <div className="error-message">{errorMessage}</div>}

        {/* Submit button */}
        <button className="btn_submit" type="submit">
          Add Employee
        </button>

       
      </form>
      {renderPopup()}
    </div>
    </div>
  );
};

export default AddEmployee;
