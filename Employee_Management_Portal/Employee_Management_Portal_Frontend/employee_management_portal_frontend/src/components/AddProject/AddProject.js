import React, { useState, useEffect } from "react";
import "./addproject.css";
import Skills from "../Data/Skills";
import MultiSelectDropdown from "../MultiSelectDropdown/MultiSelectDropdown";
import SubmitPopup from "../SubmitPopup/SubmitPopup";
import ProjectService from "../../service/ProjectService";
import EmployeeService from "../../service/EmployeeService";
import InputField from "../InputField/InputField";
import Button from '../Button/Button'
import Popup from "../Popup/Popup";
import {
  validateName,
  validateManagerId,
  validateStartDate,
  validateDescription,
  validateSkills
} from "../../components/HandleBlur/HandleBlur"; 

const AddProject = () => {
  const [name, setName] = useState("");
  const [selectedSkills] = useState([]);
  const [managerId, setManagerId] = useState("");
  const [startDate, setStartDate] = useState("");
  const [description, setDescription] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [managerList, setManagerList] = useState([]);

  const [showErrorPopUp, setShowErrorPopUp]= useState(false);
  const [popUpText, setPopUpText] = useState("");

  const [nameError, setNameError] = useState("");
  const [managerIdError, setManagerIdError] = useState("");
  const [startDateError, setStartDateError] = useState("");
  const [skillsError, setSkillsError] = useState("");
  const [skills, setSkills] = useState([]);
  const [descriptionError, setDescriptionError] = useState("");

  const [showSuccessPopup, setShowSuccessPopup] = useState(false);
  const [successMessage, setSuccessMessage] = useState("");
  const [showSubmitPopup, setShowSubmitPopup] = useState(false);


  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
    setSkillsError("");
  };

  useEffect(() => {
    getManagerList();
  }, []);

  async function getManagerList() { 
    EmployeeService.getEmployees("MANAGER").then((response) =>{
      console.log(response.data);
      setManagerList(response.data);
    })
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    if (
      !name ||
      !managerId ||
      !description ||
      !startDate ||
       skills.length === 0 
      
    ) {
      validateName(name, setNameError);
      validateManagerId(managerId,setManagerIdError)
      validateDescription(description,setDescriptionError)
      validateStartDate(startDate,setStartDateError)
      validateSkills(skills,setSkillsError)
     return;
    }
    const project = {
      name,
      managerId,
      startDate,
      skills,
      description,
    };
    ProjectService.addProject(project).then((response)=>{
      setSuccessMessage("Project added successfully.");
      setShowSubmitPopup(true);
    })
     .catch((error) => {
          console.log(error);
          setPopUpText(error.response.data.message)
          setShowErrorPopUp(true);
        });
  };
  
  return (
    <>
    <div className="add_project">
      <form autoComplete="off" onSubmit={handleSubmit}>
        <h2 style={{ marginLeft: "0.3rem", color: "white" }}>Add Project</h2>
        <div className="input_form_field">
          <InputField
            type="text"
            id="projectName"
            className="custom-placeholder"
            value={name}
            placeholder="Project Name"
            onChange={(e) => setName(e.target.value)}
            onBlur={() => validateName(name, setNameError)}
          />
          {nameError && <div className="error-message employee_errors">{nameError}</div>}
        </div>
        <div className="input_form_field">
          <select
            type="text"
            name="managerId"
            className="project_input_box"
            onChange={(e) => {
              setManagerId(e.target.value);
            }}
            onBlur={() => validateManagerId(managerId, setManagerIdError)}
          >
            <option value="">Select Manager</option>
            {managerList.map((manager) => {
              return (
                <option key={manager.id} value={manager.id}>
                  {manager.empId} - {manager.name}
                </option>
              );
            })}
          </select>
          {managerIdError && (
            <div className="error-message employee_errors">{managerIdError}</div>
          )}
        </div>
        <div className="input_form_field">
          <div>
            <label className="startDate">Start Date</label>
          </div>
          <InputField
            type="date"
            id="startDate"
            className="custom-placeholder"
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
            onBlur={() => validateStartDate(startDate, setStartDateError)}
          />
          {startDateError && (
            <div className="error-message employee_errors">{startDateError}</div>
          )}
        </div>
        <div className=" input_form_field">
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
        <div className="input_form_field">
          <textarea
            id="description"
            value={description}
            placeholder="Description"
            className="custom-placeholder"
            onChange={(e) => setDescription(e.target.value)}
            onBlur={() => validateDescription(description, setDescriptionError)}
            rows="4"
          />
          {descriptionError && (
            <div className="error-message employee_errors">{descriptionError}</div>
          )}
          {errorMessage && <div className="error-message employee_errors"> {errorMessage}</div>}
          {successMessage }
        </div>

        <Button className="btn_submit" type="submit" text="Add Project"/>
      </form>
      {showSubmitPopup && (
  <SubmitPopup
    description={successMessage}
    onClose={() => setShowSubmitPopup(false)} 
    onConfirm={() => setShowSubmitPopup(false)} 
  />
)}
    </div>
 {showErrorPopUp && (
            <Popup
            description={popUpText}
            onClose={() => {
              setShowErrorPopUp(false);
            }}
            />
          )}
          </>
  );
};

export default AddProject;
