import React, { useState } from 'react';
import './addproject.css'

const AddProject = () => {
  // Define state variables to store form input values
  const [projectName, setProjectName] = useState('');
  const [managerId, setManagerId] = useState('');
  const [startDate, setStartDate] = useState('');
  const [skillsRequired, setSkillsRequired] = useState('');
  const [description, setDescription] = useState('');

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    // You can perform actions with the form data here (e.g., send it to an API).
    console.log('Form submitted with data:', {
      projectName,
      managerId,
      startDate,
      skillsRequired,
      description,
    });
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div className="input_form_field">
          <input
            type="text"
            id="projectName"
            value={projectName}
            placeholder='Project Name'
            onChange={(e) => setProjectName(e.target.value)}
            required
          />
        </div>
        <div className="input_form_field">
          <input
            type="text"
            id="managerId"
            value={managerId}
            placeholder='Manager ID'
            onChange={(e) => setManagerId(e.target.value)}
            required
          />
        </div>
        <div className="input_form_field">
       <div>   <label className="startDate">Start Date</label></div>
          <input
            type="date"
            id="startDate"
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
            required
          />
        </div>
        <div className="input_form_field">
          <input
            type="text"
            id="skillsRequired"
            value={skillsRequired}
            placeholder='Skills'
            onChange={(e) => setSkillsRequired(e.target.value)}
            required
          />
        </div>
        <div className="input_form_field">
          <textarea
            id="description"
            value={description}
            placeholder='Description'
            onChange={(e) => setDescription(e.target.value)}
            rows="4"
            required
          />
        </div>
        <button  className="btn_submit" type="submit">Add Project</button>
      </form>
    </div>
  );
};

export default AddProject;
