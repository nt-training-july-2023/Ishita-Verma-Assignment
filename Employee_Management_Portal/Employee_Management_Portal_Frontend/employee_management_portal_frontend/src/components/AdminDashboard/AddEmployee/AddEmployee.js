import { React, useState } from "react";
import "./addemployee.css";
import Select from 'react-select';
import Designation from "../../Data/Designation";
import Location from "../../Data/Location";
import Role from "../../Data/Role";
import { useNavigate } from "react-router-dom";
import AdminService from "../../service/AdminService";
import Skills from "../../Data/Skills";


const AddEmployee = () => {
  const navigate = useNavigate();

  const [skills, setSkills] = useState([]);

  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
  };

  const [empId, setEmpId] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [dob, setDob] = useState("");
  const [doj, setDoj] = useState("");
  const [location, setLocation] = useState("");
  const [designation, setDesignation] = useState("");
  const [contactNumber, setContactNumber] = useState("");
  const [role, setRole] = useState("");

 
   const [selectedSkills, setSelectedSkills] = useState([]);

  //for validations
  const [nameError, setNameError] = useState("");
  const [emailError, setEmailError] = useState("");
  const [empIdError, setEmpIdError] = useState("");
  const [dobError, setDobError] = useState("");
  const [dojError, setDojError] = useState("");
  const [locationError, setLocationError] = useState("");
  const [designationError, setDesignationError] = useState("");
  const [contactNumberError, setContactNumberError] = useState("");
  const [roleError, setRoleError] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  
  const onSubmit = (e) => {
    e.preventDefault();

    if (role === "") {
      setRoleError("Required");
    }
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

    if (!/^\d{10}$/.test(cleanedContactNumber)) {
      setContactNumberError("Contact no should have 10 digits only");
      isValid = false;
    } else {
      setContactNumber(cleanedContactNumber);
      setContactNumberError("");
    }
    

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
      skills
    };
    AdminService.addEmployee(employee)
      .then((response) => {
        console.log(response.data);
        setErrorMessage("Successfully added.");

        navigate("");
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const handleNameBlur = (e) => {
    const inputValue = e.target.value;
    const alphabeticRegex = /^[A-Za-z]+(?:\s[A-Za-z]+)*$/;
    if (!alphabeticRegex.test(inputValue)) {
      setNameError("Name must contain alphabetic characters only");
    } else {
      setNameError("");
    }
  };

  const handleEmailBlur = (e) => {
    const inputValue = e.target.value;
    // const emailRegex = /^ankita\.sharma@nucleusteq\.com$/;;
    const emailRegex = /^[a-zA-Z0-9._%+-]+@nucleusteq\.com$/;

    if (!emailRegex.test(inputValue)) {
      setEmailError("Email must be a company email (@nucleusteq.com)");
    } else {
      setEmailError("");
    }
  };

  const handleEmpIdBlur = (e) => {
    const inputValue = e.target.value;
    const empIdRegex = /^[Nn]\d{4}$/;

    if (!empIdRegex.test(inputValue)) {
      setEmpIdError("Employee ID should be in pattern NXXXX");
    } else {
      setEmpIdError("");
    }
  };

  const handleDobBlur = (e) => {
    const inputValue = e.target.value;
    const dateRegex = /^\d{4}-\d{2}-\d{2}$/;

    if (!dateRegex.test(inputValue)) {
      setDobError("Date should have a pattern like DD-MM-YY");
    } else {
      setDobError("");
    }
  };

  const handleDojBlur = (e) => {
    const inputValue = e.target.value;
    const dateRegex = /^\d{4}-\d{2}-\d{2}$/;

    if (!dateRegex.test(inputValue)) {
      setDojError("Date should have a pattern like  DD-MM-YY");
    } else {
      setDojError("");
    }
  };

  const handleContactNumberBlur = (e) => {
    const inputValue = e.target.value;
    const cleanedContactNumber = inputValue.replace(/[^0-9]/g, "");

    if (!/^\d{10}$/.test(cleanedContactNumber)) {
      setContactNumberError("Contact no should have 10 digits only");
    } else {
      setContactNumber(cleanedContactNumber);
      setContactNumberError("");
    }
  };

  return (
    <div className="reg_form">
      <div>
        <div className=" reg_form_field">
          {/* <div><label className="reg_form_field_label">Name :</label></div>  */}
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
        {nameError && <div className="error-message">{nameError}</div>}

        <div className=" reg_form_field">
          {/* <div><label className="reg_form_field_label">Email :</label></div>  */}
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
        {emailError && <div className="error-message">{emailError}</div>}

        <div className=" reg_form_field">
          {/* <div> <label className="reg_form_field_label">Employee ID :</label></div>  */}
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
        {empIdError && <div className="error-message">{empIdError}</div>}

        <div className=" reg_form_field">
          {/* <div> <label className="reg_form_field_label">Contact Number :</label></div>  */}
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
          <div className="error-message">{contactNumberError}</div>
        )}

        <div className=" reg_form_field">
          <div>
            {/* <label className="reg_form_field_label">Location :</label> */}
          </div>
          <select
            className="reg_form_input"
            type="text"
            name="location"
            placeholder="Enter Location"
            onChange={(e) => setLocation(e.target.value)}
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
        {locationError && <div className="error-message">{locationError}</div>}

        <div className=" reg_form_field">
          {/* <div> <label className="reg_form_field_label">Designation :</label></div>  */}
          <select
            className="reg_form_input"
            type="text"
            name="designation"
            placeholder="Enter Designation"
            onChange={(e) => setDesignation(e.target.value)}
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
          <div className="error-message">{designationError}</div>
        )}

        <div className=" reg_form_field">
          <div>
            {/* <label className="reg_form_field_label">Location :</label> */}
          </div>
          <select
            className="reg_form_input"
            type="text"
            name="role"
            placeholder="Enter Role"
            onChange={(e) => setRole(e.target.value)}
          >
            <option value="" className="select">
              Select Role
            </option>
            {Role.map((item) => {
              return (
                <option key={item} value={item} className="select">
                  {item}
                </option>
              );
            })}
          </select>
        </div>
        {roleError && <div className="error-message">{roleError}</div>}
        <div className=" reg_form_field">
          <div>
            <label className="reg_form_field_label">DOB :</label>{" "}
          </div>
          <input
            type="date"
            className="reg_form_input"
            value={dob}
            onChange={(e) => setDob(e.target.value)}
            onBlur={handleDobBlur}
            required
          />
        </div>
        {dobError && <div className="error-message">{dobError}</div>}

        <div className=" reg_form_field" controlId="formBasicEmail">
          <div>
            {" "}
            <label className="reg_form_field_label">DOJ :</label>
          </div>
          <input
            type="date"
            className="reg_form_input"
            value={doj}
            onChange={(e) => setDoj(e.target.value)}
            onBlur={handleDojBlur}
            required
          />
        </div>
        {dojError && <div className="error-message">{dojError}</div>}

        <div className=" reg_form_field">
          {/* <div> <label className="reg_form_field_label">Confirm Password :</label></div>  */}
          <Select
                options={Skills.map((skill) => ({
                  value: skill,
                  label: skill,
                }))}
                isMulti={true}
                placeholder="Select skills"
                className="skills_select"
                onChange={handleSkillChange}
                value={skills.map((skill) => ({ value: skill, label: skill }))}
              />
        </div>
      </div>

      {errorMessage && <div className="error-message">{errorMessage}</div>}
      <div class="buttons">
        <div className="btn_submit" onClick={onSubmit} type="submit">
          <span className="btn-text">Add Employee</span>
        </div>
      </div>
    </div>
  );
};
// const addEmployee = new AddEmployee();
export default AddEmployee;
