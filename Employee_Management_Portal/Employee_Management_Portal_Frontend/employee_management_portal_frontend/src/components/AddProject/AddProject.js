import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Select from "react-select";
import "./addproject.css";
import axios from "axios";
import Skills from "../Data/Skills";
import AdminService from "../../service/AdminService";
import MultiSelectDropdown from "../MultiSelectDropdown/MultiSelectDropdown";
import Popup from "../Popup/Popup"; 
import {
  validateName,
  validateManagerId,
  validateStartDate,
  validateDescription
} from "../../components/HandleBlur/HandleBlur"; 
import ProjectService from "../../service/ProjectService";
import EmployeeService from "../../service/EmployeeService";

const AddProject = () => {
  const [name, setName] = useState("");
  const [selectedSkills] = useState([]);
  const [managerId, setManagerId] = useState("");
  const [startDate, setStartDate] = useState("");
  const [description, setDescription] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [managerList, setManagerList] = useState([]);
  const [formSubmitted, setFormSubmitted] = useState(false);

  const [nameError, setNameError] = useState("");
  const [managerIdError, setManagerIdError] = useState("");
  const [startDateError, setStartDateError] = useState("");
  const [skillsError, setSkillsError] = useState("");
  const [skills, setSkills] = useState([]);
  const [descriptionError, setDescriptionError] = useState("");

  const [showSuccessPopup, setShowSuccessPopup] = useState(false);
  const [successMessage, setSuccessMessage] = useState("");

  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
  };

  const navigate = useNavigate();

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

    const project = {
      name,
      managerId,
      startDate,
      skills,
      description,
    };
    ProjectService.addProject(project).then((response)=>{
      setSuccessMessage("Project added successfully.");
          const navigateToDashboard = () => {
            navigate("/AdminDashboard");
        };
        setTimeout(navigateToDashboard, 2000);
    })
     .catch((error) => {
          console.log(error);
          setSuccessMessage(error.response.data.message)
        });
  };

  const handleNameBlur = (e) => {
    const inputValue = e.target.value;
    validateName(inputValue, setNameError);
  };
  
  const handleManagerIdBlur = (e) => {
    const inputValue = e.target.value;
    validateManagerId(inputValue, setManagerIdError);
  };
  
  const handleDescriptionBlur = (e) => {
    const inputValue = e.target.value;
    validateDescription(inputValue, setDescriptionError);
  };
  
  
  return (
    <div className="add_project">
      <form autoComplete="off" onSubmit={handleSubmit}>
        <h2 style={{ marginLeft: "0.3rem", color: "white" }}>Add Project</h2>
        <div className="input_form_field">
          <input
            type="text"
            id="projectName"
            className="custom-placeholder"
            value={name}
            placeholder="Project Name"
            onChange={(e) => setName(e.target.value)}
            onBlur={handleNameBlur}
          />
          {nameError && <div className="error-message">{nameError}</div>}
        </div>
        <div className="input_form_field">
          <select
            type="text"
            name="managerId"
            className="project_input_box"
            onChange={(e) => {
              setManagerId(e.target.value);
            }}
            onBlur={handleManagerIdBlur}
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
            <div className="error-message">{managerIdError}</div>
          )}
        </div>
        <div className="input_form_field">
          <div>
            <label className="startDate">Start Date</label>
          </div>
          <input
            type="date"
            id="startDate"
            className="custom-placeholder"
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
          />
          {startDateError && (
            <div className="error-message">{startDateError}</div>
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
          />
          {skillsError && <div className="error-message">{skillsError}</div>}
        </div>
        <div className="input_form_field">
          <textarea
            id="description"
            value={description}
            placeholder="Description"
            className="custom-placeholder"
            onChange={(e) => setDescription(e.target.value)}
            onBlur={handleDescriptionBlur} 
            rows="4"
          />
          {descriptionError && (
            <div className="error-message">{descriptionError}</div>
          )}
          {errorMessage && <div className="error-message"> {errorMessage}</div>}
          {successMessage}
        </div>

        <button className="btn_submit" type="submit">
          Add Project
        </button>
      </form>
      
      {showSuccessPopup && (
        <Popup
          description={successMessage}
          onClose={() => setShowSuccessPopup(false)}
          onConfirm={() => setShowSuccessPopup(false)}
        />
      )}
    </div>
  );
};

export default AddProject;
