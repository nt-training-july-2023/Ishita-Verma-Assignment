import React, { useState, useEffect } from 'react';
import './assign.css';
import axios from 'axios';
import { useParams, useNavigate,useLocation } from 'react-router-dom';
import ProjectService from '../../service/ProjectService';

const Assign = () => {
  const [projectsList, setProjectsList] = useState([]);
  const [employeeDetails, setEmployeesDetails] = useState([]);
  const [managerId, setManagerId] = useState(0);
  const [projectId, setProjectId] = useState(0);
  const [message, setMessage] = useState("");
  const [projectError, setProjectError] = useState("");

  const { id } = useParams();
  const navigate = useNavigate();

  const location = useLocation();
  const stateData = location.state;
  console.log(stateData);

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
        `http://localhost:8080/all/employee/${id}`
      );
      setEmployeesDetails(response.data);
      console.log(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const getAllProjects = async () => {
    ProjectService.getProjects().then((response)=>{
      console.log(response.data);
      setProjectsList(response.data);
    }). catch ((error) => {
      console.error("Error fetching data:", error);
    })
  };

  const updateEmployee = async () => {
    try {
      await axios.put(`http://localhost:8080/employee/assignProject/${id}`, {
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
  // const updateEmployee = async () => {
  //   if(!projectId){
  //     setProjectError("Select a project");
  //     return;
  //   }
//   ProjectService.assignProject(projectId,managerId,`${stateData.empId}`).then((response)=>{
//     console.log('Employee updated:', response.data);
//     // navigate("/adminDashboard");
//     // setShowPopup(true);
//     setMessage("Project assigned succesfully");
//     const navigateToDashboard = () => {
//       navigate("/AdminDashboard");
//     };
//     setTimeout(navigateToDashboard, 2000);
//   }).catch((error)=>{
//     console.error('Error updating employee:', error);
//   })
// }
 
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
          <h3> {stateData.empName}</h3>
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
              <button onClick={() => navigate("/adminDashboard")} className='dashboard_btn'>&#8592; Back to Dashboard</button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Assign;
