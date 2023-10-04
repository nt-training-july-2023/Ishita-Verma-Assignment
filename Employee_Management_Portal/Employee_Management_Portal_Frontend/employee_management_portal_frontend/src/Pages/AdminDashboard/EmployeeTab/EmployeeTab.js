import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from 'react-router-dom';
import "./employeetab.css";
import DateReverser from "../../../components/DateReverser/DateReverser";
import Button from '../../../components/Button/Button'
import Popup from "../../../components/Popup/Popup";
import EmployeeService from "../../../service/EmployeeService";

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

  const navigate = useNavigate();

  const cancelAssign = () => {
    setSelectedEmployeeId(null);
    setShowAssign(false);
  };

  const getAllEmployees = async () => {
    EmployeeService.getEmployees("EMPLOYEE").then((response) => {
      console.log(response.data);
      setEmployees(response.data);
    }).catch((error) => {
      console.error("Error fetching data:", error);
    })
  };

  const unassignProject = (employeeId) => {
    setUnassignEmployeeId(employeeId);
    setShowUnassignConfirm(true);
  };

  const confirmUnassign = async () => {
     EmployeeService.unassignProject(`${unassignEmployeeId}`).then((response)=>{
      getAllEmployees();
      setShowUnassignConfirm(false);
     }).catch((error)=>{

     })
  };

  const location = useLocation();
  const stateData = location.stateData;
  console.log("stateData" + stateData);

  console.log(stateData);

  return (
    
      <div className="card_container  admin_manager_tab">
        {employees.sort(function (a, b) {
          return a.name.localeCompare(b.name);
        }).map((employee) => (
          <div className="card" key={employee.id}>
            <div className="column1">
              <h2 className="employee_name">{employee.name}</h2>
              <p style={{ marginTop: "-0.2rem" }}>{employee.designation}</p>
              <p style={{ marginTop: "1rem" }}>
                <p style={{ marginBottom: "0.3rem" }}>
                  <span style={{ fontWeight: "bold" }}>Project Name :</span>{" "}
                  {employee.projectName ? employee.projectName : "N/A"}
                </p>
              </p>
              <p style={{ marginBottom: "0.3rem" }}>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>Manager :</span>{" "}
                {employee.manager}
              </p>
              <p style={{ marginBottom: "0.3rem" }}>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>Contact :</span>{" "}
                {employee.contactNumber}
              </p>
              <p style={{ marginBottom: "0.3rem" }}>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>Email :</span>{" "}
                {employee.email}
              </p>
            </div>
            <div className="column2">
              <p className="employee_id" style={{ marginBottom: "2.3rem", fontSize: "1rem" }}>
                <span style={{ fontWeight: "bold" }}>Employee ID :</span> {employee.id}
              </p>
              <p style={{ marginBottom: "0.3rem" }}>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>DOB :</span>{" "}
                <DateReverser date={employee.dob} />
              </p>
              <p style={{ marginBottom: "0.3rem" }}>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>DOJ :{" "}</span>
                <DateReverser date={employee.doj} />
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>Location :{" "}</span>
                {employee.location}
              </p>
              <div className="assign_project">
                {employee.projectName ? (
                  <Button className="custom-button green-button" onClick={() => unassignProject(employee.id)}
                  text="Unassign Project"/>
                ) : (
                 
                  <Button
                  onClick={() => {
                    navigate( `/assign/project/${employee.id}`, {
                      state: { empId: employee.id, empName: employee.name },
                    });
                  }}
                  className="assign_btn"
                  text=" Assign Project"
                />  
                )}
              </div>
            </div>
            {stateData && (
              <div className="column3">
                <p style={{ fontWeight: "bold" }}>Manager:</p>
                <p>{stateData.managerName}</p>
                <p style={{ fontWeight: "bold" }}>Email:</p>
                <p>{stateData.managerEmail}</p>
                <p style={{ fontWeight: "bold" }}>Contact:</p>
                <p>{stateData.managerContact}</p>
              </div>
            )}
          </div>
        ))}
     

      {showUnassignConfirm && (
        <Popup
          description="Are you sure you want to unassign this project?"
          onClose={() => setShowUnassignConfirm(false)}
          onConfirm={confirmUnassign}
        >
          <button onClick={confirmUnassign}></button>
        </Popup>
      )}
    </div>
  );
};

export default EmployeeTab;
