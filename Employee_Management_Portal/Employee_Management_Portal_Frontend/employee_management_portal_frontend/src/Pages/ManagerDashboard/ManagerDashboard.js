import React, { useState, useEffect } from "react";
import EmployeeTab from "./EmployeeTab/EmployeeTab";
import ManagerTab from "../AdminDashboard/ManagerTab/ManagerTab";
import ProjectTab from "../AdminDashboard/ProjectTab/ProjectTab";
import HeaderComponent from "../../components/HeaderComponent/HeaderComponent";
import UnAuthorization from "../../components/Unauthorization/Unauthorization";
import DisableBackButton from "../../components/DisableBackButton/DisableBackButon";

const ManagerDashboard = () => {
  const [activeTab, setActiveTab] = useState("employee");
  const [role, setRole] = useState(localStorage.getItem('userRole'));

  useEffect(() => {
    setRole(localStorage.getItem('role'));
  }, [])

  const switchToEmployeeTab = () => {
    setActiveTab("employee");
  };

  const switchToManagerTab = () => {
    setActiveTab("manager");
  };

  const switchToProjectTab = () => {
    setActiveTab("project");
  };

  const name= localStorage.getItem("name");

  return (
    <>
    <DisableBackButton/>
    {role === "MANAGER"?(
    <div className="">
      <HeaderComponent  
        activeTab={activeTab}
        switchToEmployeeTab={switchToEmployeeTab}
        switchToManagerTab={switchToManagerTab}
        switchToProjectTab={switchToProjectTab}
      />
     
      <div className="card_container">
        {activeTab === "employee" && (
          <div>
            <EmployeeTab />
          </div>
        )}
        {activeTab === "manager" && (
          <div className="managertab_manager">
            <ManagerTab />
          </div>
        )}
        {activeTab === "project" && (
          <div>
            <ProjectTab />
          </div>
        )}
      </div>
    </div>
    ): (<UnAuthorization/>)}
    </>
  );
};

export default ManagerDashboard;
