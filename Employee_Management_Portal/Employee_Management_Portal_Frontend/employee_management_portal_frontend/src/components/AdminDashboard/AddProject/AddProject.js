import React, { useState } from 'react';
import Select from 'react-select';
import './addproject.css';
import Skills from "../../Data/Skills";
import AdminService from '../../service/AdminService';

const AddProject = () => {
  
  const [name, setName] = useState('');
  const [managerId, setManagerId] = useState('');
  const [startDate, setStartDate] = useState('');
  const [skills, setSkills] = useState([]);
  const [description, setDescription] = useState('');
  const [errorMessage, setErrorMessage] = useState("");
 
  const [nameError, setNameError] = useState('');
  const [managerIdError, setManagerIdError] = useState('');
  const [startDateError, setStartDateError] = useState('');
  const [skillsError, setSkillsError] = useState('');
  const [descriptionError, setDescriptionError] = useState('');

  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
  };
  
  // Function to validate if a field is empty
  const validateField = (field, value) => {
    if (value.trim() === '') {
      switch (field) {
        case 'name':
          setNameError('Project Name is required');
          break;
        case 'managerId':
          setManagerIdError('Manager ID is required');
          break;
        case 'startDate':
          setStartDateError('Start Date is required');
          break;
        case 'skills':
          setSkillsError('Skills are required');
          break;
        case 'description':
          setDescriptionError('Description is required');
          break;
        default:
          break;
      }
      return false; // Field is empty
    } else {
      // Clear the error message if the field is not empty
      switch (field) {
        case 'name':
          setNameError('');
          break;
        case 'managerId':
          setManagerIdError('');
          break;
        case 'startDate':
          setStartDateError('');
          break;
        case 'skills':
          setSkillsError('');
          break;
        case 'description':
          setDescriptionError('');
          break;
        default:
          break;
      }
      return true; // Field is not empty
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Validate each field before submission
    const isNameValid = validateField('name', String(name));
    const isManagerIdValid = validateField('managerId', managerId);
    const isStartDateValid = validateField('startDate', startDate);
    const isSkillsValid = skills.length > 0;
    const isDescriptionValid = validateField('description', description);

    
    if (!isNameValid || !isManagerIdValid || !isStartDateValid || !isSkillsValid || !isDescriptionValid) {
      return;
    } 

    const project = {
      name,
      managerId,
      startDate,
      skills,
      description,
    };
 console.log(project);
    AdminService.addProject(project)
      .then((response) => {
        console.log(response.data);
        setErrorMessage("Successfully added.");

        // navigate("");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className='add_project'>
      <form onSubmit={handleSubmit}>
        <div className="input_form_field">
          <input
            type="text"
            id="projectName"
            value={name}
            placeholder='Project Name'
            onChange={(e) => setName(e.target.value)}
            onBlur={() => validateField('name', name)}
            
          />
          {nameError && <div className="error-message">{nameError}</div>}
        </div>
        <div className="input_form_field">
          <input
            type="text"
            id="managerId"
            value={managerId}
            placeholder='Manager ID'
            onChange={(e) => setManagerId(e.target.value)}
            onBlur={() => validateField('managerId', managerId)}
            
          />
          {managerIdError && <div className="error-message">{managerIdError}</div>}
        </div>
        <div className="input_form_field">
          <div><label className="startDate">Start Date</label></div>
          <input
            type="date"
            id="startDate"
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
            onBlur={() => validateField('startDate', startDate)}
            
          />
          {startDateError && <div className="error-message">{startDateError}</div>}
        </div>
        <div className=" input_form_field">
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
        <div className="input_form_field">
          <textarea
            id="description"
            value={description}
            placeholder='Description'
            onChange={(e) => setDescription(e.target.value)}
            onBlur={() => validateField('description', description)}
            rows="4"
            
          />
          {descriptionError && <div className="error-message">{descriptionError}</div>}
        </div>
        <button className="btn_submit" type="submit">Add Project</button>
      </form>
    </div>
  );
};

export default AddProject;
