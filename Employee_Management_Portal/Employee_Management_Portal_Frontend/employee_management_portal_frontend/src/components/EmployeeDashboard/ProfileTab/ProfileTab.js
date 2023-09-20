import {React,useState,useEffect} from 'react'
import './profile.css'
import { Link } from "react-router-dom";
import axios from 'axios'
import DateReverser from "../../DateReverser/DateReverser";

const ProfileTab = () => {
  const email = localStorage.getItem('email');
  const [employeeDetails, setEmployeeDetails] = useState([]); 
  const [managerNames, setManagerNames] = useState({});

  useEffect(() => {
    if (email) {
      axios.get(`http://localhost:8080/api/admin/employee/${email}`)
        .then((response) => {
          console.log(response.data);
          setEmployeeDetails(response.data); 
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }, [email]); 

  return (
    <div className="main">
      {employeeDetails ? (
        <div>
          
          <p style={{color:"white", marginLeft:"0.8rem",fontSize:"1.5rem"}}>Emp ID: {employeeDetails.empId}</p>
          <div className="details-container">
              {/* <h4 style={{color:"white", marginLeft:"0.8rem",fontSize:"1.5rem",color:"black"}}>Welcome {employeeDetails.name}</h4> */}
            <div className="column01 grid-container">

            <div className="column01">
              {/* <p style={{fontSize:"1.2rem",fontWeight:"bold"}}>Welcome {employeeDetails.name}</p> */}
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
              {/* <h2>Column 2</h2> */}
              {/* <div className="grid-container"> */}

              <strong>Contact No</strong>
              <p className="field_input">{employeeDetails.contactNumber}</p>

              <strong>Project Name</strong>
              <p className="field_input">{employeeDetails.projectId}</p>

              <strong>Manager</strong>
              <p className="field_input">{employeeDetails.manager}</p>

              <strong>DOJ</strong>
              <p className="field_input"><DateReverser date={employeeDetails.doj} /></p>

              <strong>Location</strong>
              <p className="field_input">{employeeDetails.location}</p>
                 </div>
              {/* </div> */}
           
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
