import {React,useState,useEffect} from 'react'
import './profile.css'
import { Link } from "react-router-dom";
import axios from 'axios'
import DateReverser from "../../../components/DateReverser/DateReverser";
import EmployeeService from '../../../service/EmployeeService'

const ProfileTab = () => {
  const email = localStorage.getItem('email');
  const id = localStorage.getItem("id")
  const [employeeDetails, setEmployeeDetails] = useState([]); 
  const [managerNames, setManagerNames] = useState({});

  async function getEmployee(){
    EmployeeService.getEmployeeById(`${id}`).then((response)=>{
      setEmployeeDetails(response.data);
    }).catch((error)=>{
      console.log(error);
    })
  }

  useEffect(() => {
    getEmployee();
  }, []);

  return (
    <div className="main">
      {employeeDetails ? (
        <div>
          <p className='empId_profile'>Emp ID: {employeeDetails.empId}</p>
          <div className="details-container">
             
            <div className="column01 grid-container">

            <div className="column01">
             
              <strong>Name</strong>
              <p className="field_input">{employeeDetails.name}</p>

              <strong>Email</strong>
              <p className="field_input">{employeeDetails.email}</p>

              <strong>DOB</strong>
              <p className="field_input"><DateReverser date={employeeDetails.dob} /></p>

              <strong>Skills</strong>
                {employeeDetails.skills ? (
                  <p className="field_input skills">{employeeDetails.skills.join(', ')}</p>
                ) : (
                  <p className="field_input">No skills available</p>
                )}

            <Link to={`/updateProject/${employeeDetails.id}`} className="update-skills">Update Skills</Link>
          
         </div>

            <div className="column01">
             <strong>Contact No</strong>
              <p className="field_input">{employeeDetails.contactNumber}</p>

              <strong>Project Name</strong>
              <p className="field_input">{employeeDetails.projectName}</p>

              <strong>Manager</strong>
              <p className="field_input">{employeeDetails.manager}</p>

              <strong>DOJ</strong>
              <p className="field_input"><DateReverser date={employeeDetails.doj} /></p>

              <strong>Location</strong>
              <p className="field_input">{employeeDetails.location}</p>
                 </div>   
            </div>
          </div>
        </div>
      ) : (
        <p>Loading employee details...</p>
      )}
    </div>
  );
}

export default ProfileTab
