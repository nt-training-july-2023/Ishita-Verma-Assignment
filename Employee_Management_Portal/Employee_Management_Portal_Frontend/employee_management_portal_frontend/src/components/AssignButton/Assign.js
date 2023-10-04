import React, { useState, useEffect } from 'react';
import './assign.css';
import { useParams, useNavigate,useLocation } from 'react-router-dom';
import ProjectService from '../../service/ProjectService';
import EmployeeService from '../../service/EmployeeService';
import { validateSelectProject } from '../HandleBlur/HandleBlur';

const Assign = () => {
  const [projectsList, setProjectsList] = useState([]);
  const [employeeDetails, setEmployeesDetails] = useState([]);
  const [managerId, setManagerId] = useState(0);
  const [projectId, setProjectId] = useState(0);
  const [message, setMessage] = useState("");
  const [projectError, setProjectError] = useState("");
  const [isSaveButtonDisabled, setIsSaveButtonDisabled] = useState(true);

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
      return;
    }
    EmployeeService.getEmployeeById(`${id}`).then((response)=>{
      setEmployeesDetails(response.data);
    }).catch((error)=>{

    })
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
    EmployeeService.assignProject(`${id}`,projectId,managerId).then((response)=>{
      setMessage("Assigned");
      setTimeout(() => {
        navigate("/adminDashboard");
      }, 2000);
    }).catch((error)=>{

    })
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
    setIsSaveButtonDisabled(!selectedProjectId); 
  };

  return (
    <>
      <div className='assign '>
        <div className='assign_form'>
          <h2 className='assign_heading'>Assign Project</h2>
          <h3 className='assign_name'> {stateData.empName}</h3>
          <div className='assign_project'>
            <select onChange={handleSelectChange} 
              className='assign_input'
              onBlur={() =>
                validateSelectProject(
                  projectId,
                  setProjectError
                )
              }
            >
              <option value="">Select Project</option>
              {projectsList.map((item) => (
                <option key={item.projectId} value={item.projectId} data-managerid={item.managerId}>
                  {item.projectId} - {item.projectName}
                </option>
              ))}
            </select>
            {projectError && <div className="error-message assign_error">{projectError}</div>}
            <div style={{ marginTop: "1rem" }}>
              <button onClick={updateEmployee} className='assign_btn' disabled={isSaveButtonDisabled}>
                Save
              </button>
            </div>
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
