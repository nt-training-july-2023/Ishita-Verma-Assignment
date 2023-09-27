import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Select from "react-select";
import "./addproject.css";
import axios from "axios";
import Skills from "../Data/Skills";
import AdminService from "../service/AdminService";
import MultiSelectDropdown from "../MultiSelectDropdown/MultiSelectDropdown";
import Popup from "../Popup/Popup"; 

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

  // State variables for success popup
  const [showSuccessPopup, setShowSuccessPopup] = useState(false);
  const [successMessage, setSuccessMessage] = useState("");

  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
  };

  const navigate = useNavigate();
  // Function to validate if a field is empty
  const validateField = (field, value) => {
    if (value.trim() === "") {
      switch (field) {
        case "name":
          setNameError("Project Name is required");
          break;
        case "managerId":
          setManagerIdError("Manager ID is required");
          break;
        case "startDate":
          setStartDateError("Start Date is required");
          break;
        case "skills":
          setSkillsError("Skills are required");
          break;
        case "description":
          setDescriptionError("Description is required");
          break;
        default:
          break;
      }
      return false; // Field is empty
    } else {
      // Clear the error message if the field is not empty
      switch (field) {
        case "name":
          setNameError("");
          break;
        case "managerId":
          setManagerIdError("");
          break;
        case "startDate":
          setStartDateError("");
          break;
        case "skills":
          setSkillsError("");
          break;
        case "description":
          setDescriptionError("");
          break;
        default:
          break;
      }
      return true; // Field is not empty
    }
  };

  useEffect(() => {
    getManagerList();
  }, []);

  async function getManagerList() {
    try {
      const res = await axios.get(
        "http://localhost:8080/api/admin/all/MANAGER"
      );
      setManagerList(res.data);
    } catch (error) {
      console.log(error);
    }
  }

  const handleSubmit = (e) => {
    e.preventDefault();

    // Validate each field before submission
    const isNameValid = validateField("name", String(name));
    const isManagerIdValid = validateField("managerId", managerId);
    const isStartDateValid = validateField("startDate", startDate);
    const isSkillsValid = skills.length > 0;
    const isDescriptionValid = validateField("description", description);

    if (
      !isNameValid ||
      !isManagerIdValid ||
      !isStartDateValid ||
      !isSkillsValid ||
      !isDescriptionValid
    ) {
      return;
    }

    const project = {
      name,
      managerId,
      startDate,
      skills,
      description,
    };

    AdminService.addProject(project)
      .then((response) => {
        // navigate("/admindashboard");
        setSuccessMessage("Project added successfully.");
        setShowSuccessPopup(true);
        // setName("");
        // setManagerId("");
        // setStartDate("");
        // setSkills([]);
        // setDescription("");
        // setTimeout(() => {
          //   navigate("/admindashboard");
          // }, 100);
        })
        .catch((error) => {
          console.log(error);
        });
        // window.location.reload();
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
            onBlur={() => validateField("name", name)}
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
            onBlur={() => validateField("managerId", managerId)}
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
            onBlur={() => validateField("startDate", startDate)}
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
            onBlur={() => validateField("description", description)}
            rows="4"
          />
          {descriptionError && (
            <div className="error-message">{descriptionError}</div>
          )}
          {errorMessage && <div className="error-message"> {errorMessage}</div>}
        </div>
        <button className="btn_submit" type="submit">
          Add Project
        </button>
      </form>

      {/* Success Popup */}
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
