import React, { useState,useEffect } from "react";
import "./employeedashboard.css"; 
import OrganizationTab from "./OrganizationTab/OrganizationTab";
import ProfileTab from "./ProfileTab/ProfileTab";
import HeaderEmployee from "../../components/HeaderEmployee/HeaderEmployee"; // Import the HeaderComponent
import { useNavigate } from "react-router-dom";
import UnAuthorization from "../../components/Unauthorization/Unauthorization";
import mainpage from '../../Assests/Images/mainpage.png';
import Button from '../../components/Button/Button';

const EmployeeDashboard = () => {
  const [activeTab, setActiveTab] = useState("profile");
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("email"));
  const [role, setRole] = useState(localStorage.getItem('role'));
  
  const navigate = useNavigate();

  const switchToProfileTab = () => {
    setActiveTab("profile");
  };

  const switchToOrganizationTab = () => {
    setActiveTab("organization");
  };
  const handleLogout = () => {
    localStorage.removeItem('email');
    localStorage.removeItem('userRole');
    localStorage.removeItem('name');
    localStorage.removeItem('id')
    navigate('/');
  };
  const name = localStorage.getItem("name");

  return (
    <>
    
    {role === "EMPLOYEE"?(
      <>
    <div className="headeremployee">
      <div className="admin_heading">
        <p>Welcome {name} !!</p>
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
        <div className='header-actions'>
        <Button onClick={handleLogout} className='custom-button logout' text='Logout' />
        <img src={mainpage} className='header_img' alt='Main Page' />
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
    </>
     ): (<UnAuthorization/>)}
     </>
  );
};

export default EmployeeDashboard;
