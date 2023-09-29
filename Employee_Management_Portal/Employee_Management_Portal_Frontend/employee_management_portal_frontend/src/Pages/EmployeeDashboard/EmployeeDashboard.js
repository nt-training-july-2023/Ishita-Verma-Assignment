import React, { useState,useEffect } from "react";
import "./employeedashboard.css"; // Import the CSS file for EmployeeDashboard
import OrganizationTab from "./OrganizationTab/OrganizationTab";
import ProfileTab from "./ProfileTab/ProfileTab";
import HeaderEmployee from "../../components/HeaderEmployee/HeaderEmployee"; // Import the HeaderComponent
import { useNavigate } from "react-router-dom";
import UnAuthorization from "../../components/Unauthorization/Unauthorization";

const EmployeeDashboard = () => {
  const [activeTab, setActiveTab] = useState("profile");
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("email"));
  const [role, setRole] = useState(localStorage.getItem('userRole'));
  
  const navigate = useNavigate();

  const switchToProfileTab = () => {
    setActiveTab("profile");
  };

  const switchToOrganizationTab = () => {
    setActiveTab("organization");
  };

  const name = localStorage.getItem("name");

  // const handleLogout = () => {
  //   localStorage.removeItem("email");
  //   localStorage.removeItem("userRole");
  //   setIsLoggedIn(false);
  //   navigate("/login");
  // };

  // useEffect(() => {
  //   setRole(localStorage.getItem('userRole'));
  // }, [])

  return (
    <>
    {role === "EMPLOYEE"?(
    <div className="container">
       <HeaderEmployee
        activeTab={activeTab}
        switchToEmployeeTab={switchToProfileTab}
        switchToManagerTab={switchToOrganizationTab}
        switchToProjectTab={() => {}}
      />
      
      <div className="admin_heading">
        <p>Welcome {name} </p>
      </div>
      <div className="admin_tabs">
        <div
          className={`admin_employee ${activeTab === "profile" ? "active" : ""}`}
          onClick={switchToProfileTab}
        >
          Profile
        </div>
        <div
          className={`admin_manager ${
            activeTab === "organization" ? "active" : ""
          }`}
          onClick={switchToOrganizationTab}
        >
          Organization
        </div>
      </div>
      <div className="card_container">
        {activeTab === "profile" && (
          <div>
            <ProfileTab />
          </div>
        )}
        {activeTab === "organization" && (
          <div>
            <OrganizationTab />
          </div>
        )}
      </div>
    </div>
     ): (<UnAuthorization/>)}
     </>
  );
};

export default EmployeeDashboard;