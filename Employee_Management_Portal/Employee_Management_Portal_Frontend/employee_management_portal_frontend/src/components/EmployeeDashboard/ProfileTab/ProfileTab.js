import {React,useState,useEffect} from 'react'
import './profile.css'
import { Link } from "react-router-dom";
import axios from 'axios'

const ProfileTab = () => {
  const email = localStorage.getItem('email');
  const [employeeDetails, setEmployeeDetails] = useState([]); 
  const [managerNames, setManagerNames] = useState({});

  // function reverseDateFormat(inputDate) {
  //   // Split the input date using the '-' separator
  //   const dateParts = inputDate.split('-');
  //   // Check if the input has three parts (year, month, day)
  //   if (dateParts.length === 3) {
  //     // Reverse the parts and join them with '-' separator
  //     const reversedDate = dateParts[2] + '-' + dateParts[1] + '-' + dateParts[0];
  //     return reversedDate;
  //   } else {
  //     // Handle invalid input format
  //     return 'Invalid Date Format';
  //   }
  // }

  // async function getEmployee() {
  //   const response = await axios.get(`http://localhost:8080/api/admin/employee/${email}`);
  //   setEmployee(response.data);
  //   // console.log(employee);
  // }
  // useEffect(() => {
  //   getEmployee();
  // }, []);
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
            <div className="column01 grid-container">

            <div className="column01">
              {/* <h2>Column 1</h2> */}

              <strong>Name</strong>
              <p className="field_input">{employeeDetails.name}</p>

              <strong>Email</strong>
              <p className="field_input">{employeeDetails.email}</p>

              <strong>DOB</strong>
              <p className="field_input">{(employeeDetails.dob)}</p>

              <strong>Skills</strong> 
            <p className="field_input">{employeeDetails.skills}</p>

            <Link to="/updateSkills" className="update-skills">Update Skills</Link>
          
         </div>

            <div className="column01">
              {/* <h2>Column 2</h2> */}
              {/* <div className="grid-container"> */}

              <strong>Contact No</strong>
              <p className="field_input">{employeeDetails.contactNumber}</p>

              <strong>Project Name</strong>
              <p className="field_input">{employeeDetails.project}</p>

              <strong>Manager</strong>
              <p className="field_input">{employeeDetails.managerId}</p>

              <strong>DOJ</strong>
              <p className="field_input">{(employeeDetails.doj)}</p>

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
