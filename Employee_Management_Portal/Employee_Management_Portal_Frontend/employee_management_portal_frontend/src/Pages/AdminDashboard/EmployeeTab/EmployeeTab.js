import React, { useEffect, useState } from "react";
import "./employeetab.css";
import EmployeeService from "../../../service/EmployeeService";
import Card from "../../../components/Card/EmployeeCard";

const EmployeeTab = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    getAllEmployees();
  }, []);

  const getAllEmployees = async () => {
    EmployeeService.getEmployees("EMPLOYEE").then((response) => {
      // console.log(response.data);
      setEmployees(response.data);
    }).catch((error) => {
      console.error("Error fetching data:", error);
    })
  };

  return (
    
      <div className="card_container  admin_manager_tab">
        {employees.sort(function (a, b) {
          return a.name.localeCompare(b.name);
        }).map((employee) => {
             return <Card employee={employee}/>
          })} 
    </div>
  );
};

export default EmployeeTab;
