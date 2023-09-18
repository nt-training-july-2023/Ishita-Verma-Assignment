import React, { useState, useEffect } from 'react'; // Import React, useState, and useEffect
import axios from 'axios'; // Import axios

const OrganizationTab = () => {
    const [employees, setEmployees] = useState([]);

    useEffect(() => {
      getAllEmployees();
    },[]);
  
    const getAllEmployees = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/api/admin/getall"
        );
        console.log(response.data);
        setEmployees(response.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };
  
    return (
      <div>
        <div className="card_container">
          {employees.map((employee) => (<div className="card" key={employee.id}>
            <div className="column1">
              <h2 className="employee_name">{employee.name}</h2>
              <p style={{marginTop:"-0.2rem"}}>{employee.designation} </p>
              <p style={{marginTop:"1rem"}}>
                  {employee.project ? (
                    <p><span style={{fontWeight:"bold"}}>Project Name :</span> {employee.project}</p>
                  ) : (
                    <p><span style={{fontWeight:"bold"}}>Project Name :</span> N/A</p>
                  )}
                </p>
              <p><span style={{fontWeight:"bold", fontSize:"1rem"}}>Role :</span>  {employee.role}</p>
              <p><span style={{fontWeight:"bold", fontSize:"1rem"}}>Contact :</span> {employee.contactNumber}</p>
              <p><span style={{fontWeight:"bold", fontSize:"1rem"}}>Email : </span> {employee.email}</p>
            </div>
            <div className="column2">
              <p className="employee_id" style={{marginBottom:"1.3rem", fontSize:"1rem" }} ><span style={{fontWeight:"bold" }}>Employee ID:</span>  {employee.empId}</p>
              <p><span style={{fontWeight:"bold", fontSize:"1rem"}}>DOB :</span>  {employee.dob}</p>
              <p><span style={{fontWeight:"bold", fontSize:"1rem"}}>DOJ: </span> {employee.doj}</p>
              <p><span style={{fontWeight:"bold", fontSize:"1rem"}}>Location : </span> {employee.location}</p>
            </div>
          </div>))}
          
        </div>
      </div>
    );
}

export default OrganizationTab;
