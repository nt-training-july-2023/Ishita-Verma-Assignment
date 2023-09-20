import React, { useEffect, useState } from "react";
import "./employeetab.css";
import axios from "axios";
import Assign from "./AssignButton/Assign";
import { Link } from 'react-router-dom';
import DateReverser from "../../DateReverser/DateReverser";

const EmployeeTab = () => {
  const [employees, setEmployees] = useState([]);
  const [showAssign, setShowAssign] = useState(false);
  const [selectedEmployeeId, setSelectedEmployeeId] = useState(null);
  

  useEffect(() => {
    getAllEmployees();
  }, []);

  const toggleAssign = (employeeId) => {
    setSelectedEmployeeId(employeeId);
    setShowAssign(true);
  };

  const cancelAssign = () => {
    setSelectedEmployeeId(null);
    setShowAssign(false);
  };

  const getAllEmployees = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/admin/all/EMPLOYEE"
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
        {employees.map((employee) => (
          <div className="card" key={employee.Id}>
            <div className="column1">
              <h2 className="employee_name">{employee.name}</h2>
              <p style={{ marginTop: "-0.2rem" }}>{employee.designation} </p>
              <p style={{ marginTop: "1rem" }}>
                
                  <p>
                    <span style={{ fontWeight: "bold" }}>Project Name :</span>
                    { employee.projectName ? employee.projectName : "N/A"}{" "}
                  </p>
               
                
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Manager :
                </span>
                {employee.manager}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Contact :
                </span>
                {employee.contactNumber}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Email :
                </span>
                {employee.email}
              </p>
            </div>
            <div className="column2">
              <p
                className="employee_id"
                style={{ marginBottom: "1.3rem", fontSize: "1rem" }}
              >
                <span style={{ fontWeight: "bold" }}>Employee ID:</span>{" "}
                {employee.empId}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  DOB :
                </span>{" "}
                <DateReverser date={employee.dob} />
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  DOJ:{" "}
                </span>{" "}
                <DateReverser date={employee.doj} />
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Location :{" "}
                </span>{" "}
                {employee.location}
              </p>

             <div className="assign_project">
              {!employee.projectName && (
                <Link
                to={`/assign/project/${employee.id}`}
                  className="assign_btn"
                  style={{ marginTop: "1rem" }}
                  return employee={employee}
                >
                  Assign Project
                </Link>
              )}
              </div>
            </div>
          </div>
        ))}
      </div>
      {showAssign && (
        <div className="add_employee_form assign">
          <Assign
            employeeId={selectedEmployeeId}
            onCancel={cancelAssign}
          />
        </div>
      )}
    </div>
  );
};

export default EmployeeTab;
