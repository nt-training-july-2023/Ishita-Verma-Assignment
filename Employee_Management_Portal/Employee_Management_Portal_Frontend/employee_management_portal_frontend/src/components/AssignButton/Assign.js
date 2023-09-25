import React, { useState, useEffect } from 'react';
import './assign.css';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

const Assign = () => {
  const [projectsList, setProjectsList] = useState([]);
  const [employeeDetails, setEmployeesDetails] = useState([]);
  const [managerId, setManagerId] = useState(0);
  const [projectId, setProjectId] = useState(0);
  const [message, setMessage] = useState("");
  const [projectError, setProjectError] = useState("");

  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    getEmployee();
    getAllProjects();
  }, []);

  const getEmployee = async () => {
    if (!projectId) {
      setProjectError("Select a project");
      return;
    }
    try {
      const response = await axios.get(
        `http://localhost:8080/api/admin/all/employee/${id}`
      );
      setEmployeesDetails(response.data);
      console.log(response.data);
    } catch (error) {
      console.log(error);
    }
  };

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
      await axios.put(`http://localhost:8080/api/admin/employee/${id}/assignProject`, {
        projectId: projectId,
        managerId: managerId
      });
      setMessage("Assigned");
      setTimeout(() => {
        navigate("/adminDashboard");
      }, 2000);
    } catch (error) {
      console.error('Error updating employee:', error);
    }
  };

  const handleSelectChange = (e) => {
    const selectedOption = e.target.options[e.target.selectedIndex];
    const selectedProjectId = e.target.value;
    const selectedManagerId = selectedOption.getAttribute('data-managerid');
    console.log(typeof(selectedManagerId));
    setProjectId(selectedProjectId);
    setManagerId(selectedManagerId);
    console.log(typeof(selectedManagerId, "from handleSelectChange"));
    setProjectError("");
  };

  return (
    <>
      <div className='assign '>
        <div className='assign_form'>
          <h2 className='assign_heading'>Assign Project</h2>
          <div className='assign_project'>
            <h3 style={{ fontWeight: 'bold' }}>{employeeDetails.name}</h3>
            <select onChange={handleSelectChange} className='assign_input'>
              <option value="">Select Project</option>
              {projectsList.map((item) => (
                <option key={item.projectId} value={item.projectId} data-managerid={item.managerId}>
                  {item.projectId} - {item.projectName}
                </option>
              ))}
            </select>
            <div style={{ marginTop: "1rem" }}> <button onClick={updateEmployee} className='assign_btn'>Save</button></div>
            <div>{message}</div>
            <div style={{ marginTop: "1rem" }}>
              <button onClick={() => navigate("/adminDashboard")}>Back to Dashboard</button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Assign;
