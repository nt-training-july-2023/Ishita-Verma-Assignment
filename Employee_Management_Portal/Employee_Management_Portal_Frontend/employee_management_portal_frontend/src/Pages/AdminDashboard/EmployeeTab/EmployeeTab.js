import React, { useEffect, useState } from "react";
import "./employeetab.css";
import axios from "axios";
import Assign from "../../../components/AssignButton/Assign";
import { Link } from 'react-router-dom';
import DateReverser from "../../../components/DateReverser/DateReverser";
import Popup from "../../../components/Popup/Popup"; 

const EmployeeTab = () => {
  const [employees, setEmployees] = useState([]);
  const [showAssign, setShowAssign] = useState(false);
  const [selectedEmployeeId, setSelectedEmployeeId] = useState(null);
  const [showUnassignConfirm, setShowUnassignConfirm] = useState(false); 
  const [unassignEmployeeId, setUnassignEmployeeId] = useState(null); 


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

  const unassignProject = (employeeId) => {
    setUnassignEmployeeId(employeeId);
    setShowUnassignConfirm(true);
  };

  const confirmUnassign = async () => {
    try {
      await axios.post(`http://localhost:8080/api/admin/unassign/${unassignEmployeeId}`);
      getAllEmployees();
      setShowUnassignConfirm(false);
    } catch (error) {
      console.error("Error unassigning project:", error);
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
                
                  <p style={{marginBottom:"0.3rem"}}>
                    <span style={{ fontWeight: "bold"}}>Project Name :</span>
                    { employee.projectName ? employee.projectName : "N/A"}{" "}
                  </p>
               
                
              </p>
              <p style={{marginBottom:"0.3rem"}}>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Manager :
                </span>
                {employee.manager}
              </p>
              <p style={{marginBottom:"0.3rem"}}>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Contact :
                </span>
                {employee.contactNumber}
              </p>
              <p style={{marginBottom:"0.3rem"}}>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Email :
                </span>
                {employee.email}
              </p>
            </div>
            <div className="column2">
              <p
                className="employee_id"
                style={{ marginBottom: "2.3rem", fontSize: "1rem" }}
              >
                <span style={{ fontWeight: "bold"}}>Employee ID:</span>{" "}
                {employee.empId}
              </p>
              <p style={{marginBottom:"0.3rem"}}>
                <span style={{ fontWeight: "bold", fontSize: "1rem"}}>
                  DOB :
                </span>{" "}
                <DateReverser date={employee.dob} />
              </p>
              <p style={{marginBottom:"0.3rem"}}>
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
             {employee.projectName ? (
                <button
                  className="assign_btn"
                  onClick={() => unassignProject(employee.id)}
                >
                  Unassign Project
                </button>
              ) : (
                <Link
                  to={`/assign/project/${employee.id}`}
                  className="assign_btn"
                  style={{ marginTop: "1rem" }}
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
      {/* Render the unassign confirmation popup */}
      {showUnassignConfirm && (
        <Popup
          description="Are you sure you want to unassign this project?"
          onClose={() => setShowUnassignConfirm(false)} // Close the popup when the "Close" button is clicked
          onConfirm={confirmUnassign}
        >
          {/* Render content inside the popup */}
          <button onClick={confirmUnassign}>Confirm</button>
        </Popup>
      )}
    </div>
  );
};

export default EmployeeTab;


