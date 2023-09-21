import { React, useState } from "react";
import EmployeeTab from "./EmployeeTab/EmployeeTab";
import ManagerTab from "./ManagerTab/ManagerTab";
import ProjectTab from "./ProjectTab/ProjectTab";
import { useNavigate } from "react-router-dom";

const ManagerDashboard = () => {
  const [activeTab, setActiveTab] = useState("employee");
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("email"));
  const navigate = useNavigate();

  const switchToEmployeeTab = () => {
    setActiveTab("employee");
  };

  const switchToManagerTab = () => {
    setActiveTab("manager");
  };

  const switchToProjectTab = () => {
    setActiveTab("project");
  };

  const handleLogout = () => {
    localStorage.removeItem("email");
    localStorage.removeItem("userRole");
    setIsLoggedIn(false);
    navigate("/login");
  };

  return (
    <div className="container">
      <div className="admin_heading">Manager Dashboard</div>
      <button className="logout" onClick={handleLogout}>
        Log Out
      </button>
      <div className="admin_tabs">
        <div
          className={`admin_employee ${
            activeTab === "employee" ? "active" : ""
          }`}
          onClick={switchToEmployeeTab}
        >
          Employee
        </div>
        <div
          className={`admin_manager ${activeTab === "manager" ? "active" : ""}`}
          onClick={switchToManagerTab}
        >
          Manager
        </div>
        <div
          className={`admin_project ${activeTab === "project" ? "active" : ""}`}
          onClick={switchToProjectTab}
        >
          Project
        </div>
      </div>
      <div className="card_container">
        {activeTab === "employee" && (
          <div>
            <EmployeeTab />
          </div>
        )}
        {activeTab === "manager" && (
          <div>
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
  );
};

export default ManagerDashboard;
