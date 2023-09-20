import React, { useState, useEffect } from 'react';
import './assign.css'
import axios from 'axios';
import { useParams } from 'react-router-dom';

const Assign = ({employeeId,name}) => {
  const [projectsList, setProjectsList] = useState([]);
  const [selectedProjectId, setSelectedProjectId] = useState('');
  const [employeeDetails,setEmployeesDetails] = useState([]);
  const [managerID,setManagerID] = useState(0);
  const [projectID,setProjectID] = useState(0);
  const [message,setMessage] = useState("");

  const {id} = useParams();

  useEffect(() => {
    getEmployee();
    getAllProjects();
  }, []);

  const getEmployee = async () => {
    try {
        const resposne = await axios.get(
            `http://localhost:8080/api/admin/all/employee/${id}`
        );
        setEmployeesDetails(resposne.data);
        console.log(resposne.data);
    }catch(error){
    console.log(error);
}
}
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
        projectId: selectedProjectId,

      });
      setMessage("Assigned");
    } catch (error) {
      console.error('Error updating employee:', error);
    }
  };

  const handleSelectChange = (e) => {
    setSelectedProjectId(e.target.value);
  };

  return (
  <>
    <div className='assign '>
      <div className='assign_form'> 
      <h2 className='assign_heading'>Assign Project</h2>
      <div className='assign_project'>
      <select onChange={handleSelectChange} className='assign_input'>
        <option value="" >Select Project</option>
        {projectsList.map((item) => (
          <option  key={item.projectId} value={item.projectId}>
            {item.projectId} - {item.name}
          </option>
        ))}
      </select>
    <div style={{marginTop:"1rem"}}> <button onClick={updateEmployee} className='assign_btn'>Save</button></div> 
    <div>{message}</div>
    </div>
    </div>
    </div>
    </>
  );
};

export default Assign;
