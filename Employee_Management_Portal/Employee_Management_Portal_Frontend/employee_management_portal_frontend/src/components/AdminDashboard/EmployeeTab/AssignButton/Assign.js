import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const Assign = ({ employeeId }) => {
  const [projectsList, setProjectsList] = useState([]);
  const [selectedProjectId, setSelectedProjectId] = useState('');

  useEffect(() => {
    getAllProjects();
  }, []);

  const getAllProjects = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/admin/projects');
      setProjectsList(response.data);
    } catch (error) {
      console.error('Error fetching projects:', error);
    }
  };

  const updateEmployee = async () => {
    try {
      await axios.put(`http://localhost:8080/api/admin/employee/${employeeId}/assignProject`, {
        projectId: selectedProjectId,
      });
      // Handle successful update, e.g., show a success message or redirect
    } catch (error) {
      console.error('Error updating employee:', error);
      // Handle error, e.g., show an error message
    }
  };

  const handleSelectChange = (e) => {
    setSelectedProjectId(e.target.value);
  };

  return (
    <div>
      <select onChange={handleSelectChange}>
        <option value="">Select Project</option>
        {projectsList.map((item) => (
          <option key={item.projectId} value={item.projectId}>
            {item.projectId} - {item.name}
          </option>
        ))}
      </select>
      <button onClick={updateEmployee}>Save</button>
    </div>
  );
};

export default Assign;
