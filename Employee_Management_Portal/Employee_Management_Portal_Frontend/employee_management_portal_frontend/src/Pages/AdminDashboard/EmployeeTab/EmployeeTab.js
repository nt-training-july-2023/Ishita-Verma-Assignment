import React, { useEffect, useState } from "react";
import {useLocation} from 'react-router-dom';
import "./employeetab.css";
import axios from "axios";
import Assign from "../../../components/AssignButton/Assign";
import Card from "../../../components/Card/EmployeeCard"; // Import the Card component
import Popup from "../../../components/Popup/Popup";
import EmployeeService from "../../../service/EmployeeService";
import { Router } from "react-router-dom";
// import EmployeeService from '../../service/EmployeeService';

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

  const getAllEmployees  = async () => {
      EmployeeService.getEmployees("EMPLOYEE").then((response) =>{
      console.log(response.data);
      setEmployees(response.data);
    }). catch ((error) =>  {
      console.error("Error fetching data:", error);
    })
  };

  const unassignProject = (employeeId) => {
    setUnassignEmployeeId(employeeId);
    setShowUnassignConfirm(true);
  };

  const confirmUnassign = async () => {
    try {
      await axios.post(
        `http://localhost:8080/unassign/${unassignEmployeeId}`
      );
      getAllEmployees();
      setShowUnassignConfirm(false);
    } catch (error) {
      console.error("Error unassigning project:", error);
    }
  };
  const location = useLocation();
  const stateData = location.stateData;
  console.log("stateData"+ stateData);

  console.log(stateData);

  return (
    <div>
      <div className="card_container">
      {employees.sort(function (a, b) {
                    return a.name.localeCompare(b.name);
                }).map((employee) => (
          <Card
            key={employee.id}
            data={employee}
            onUnassignProject={unassignProject}
            />
            ))}
      </div>
     
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
