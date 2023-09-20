import { React, useState } from "react";
import "./employeedashboard.css";
import OrganizationTab from "./OrganizationTab/OrganizationTab";
import ProfileTab from "./ProfileTab/ProfileTab";
import { useNavigate } from "react-router-dom";

const EmployeeDashboard = () => {
  const [activeTab, setActiveTab] = useState("profile");
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("email"));
  const navigate = useNavigate();
  
  const switchToProfileTab = () => {
    setActiveTab("profile");
  };

  const switchToOrganizationTab = () => {
    setActiveTab("organization");
  };
  const name= localStorage.getItem("name");

  const handleLogout = () => {
    localStorage.removeItem("email");
    localStorage.removeItem("userRole");
    setIsLoggedIn(false);
    navigate("/login");
  };
  return (
    <div className="container">
      <div className="admin_heading"> Welcome {name} </div>
      
      <button className="logout" onClick={handleLogout}>
        Log Out
      </button>
      <div className="admin_tabs">
        <div
          className={`admin_employee ${
            activeTab === "profile" ? "active" : ""
          }`}
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
  );
};

export default EmployeeDashboard;
