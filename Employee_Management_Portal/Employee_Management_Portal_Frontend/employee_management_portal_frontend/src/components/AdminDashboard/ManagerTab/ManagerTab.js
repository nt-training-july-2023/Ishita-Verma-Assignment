import React, { useEffect, useState } from "react";
import axios from "axios";

const ManagerTab = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    getAllManagers();
  },[]);

  const getAllManagers = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/admin/all/MANAGER"
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
          <div className="column">
            <h2 className="employee_name">{employee.name}</h2>
            <p style={{marginTop:"-0.2rem"}}>{employee.designation} </p>
            <p><span style={{fontWeight:"bold", fontSize:"1rem"}}>Project :</span>  {employee.project}</p>
            <p><span style={{fontWeight:"bold", fontSize:"1rem"}}>Manager :</span>  {employee.manager}</p>
            <p><span style={{fontWeight:"bold", fontSize:"1rem"}}>Contact :</span> {employee.contactNumber}</p>
            <p><span style={{fontWeight:"bold", fontSize:"1rem"}}>Email : </span> {employee.email}</p>
          </div>
          <div className="column">
            <p className="employee_id" style={{marginBottom:"1.3rem", fontSize:"1rem" }} ><span style={{fontWeight:"bold" }}>Employee ID:</span>  {employee.empId}</p>
            <p><span style={{fontWeight:"bold", fontSize:"1rem"}}>Skills :</span>  {employee.skills}</p>
            <p><span style={{fontWeight:"bold", fontSize:"1rem"}}>Team :</span> </p>
          </div>
        </div>))}
        
      </div>
    </div>
  );
}

export default ManagerTab
