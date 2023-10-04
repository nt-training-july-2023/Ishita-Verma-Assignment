import React, { useEffect, useState } from "react";
import "./managertab.css";
import SingleManagerCard from "./SingleManagerCard";

import EmployeeService from "../../../service/EmployeeService";
const ManagerTab = () => {
  const [managers, setManagers] = useState([]);
 
  useEffect(() => {
    getAllManagers();
  }, []);

  const getAllManagers = async () => {
  
    EmployeeService.getEmployees("MANAGER").then((response)=>{
      console.log(response.data);
      setManagers(response.data);
    }). catch ((error) => {
      console.error("Error fetching data:", error);
    })
  };

return (
  <div>
    <div className="card_container admin_manager_tab">
      {managers.sort(function (a, b) {
        return a.name.localeCompare(b.name);
    }).map((manager) => (
    <SingleManagerCard key={manager.id} manager={manager} />
))}

    </div>
  </div>
);
    }
export default ManagerTab;
