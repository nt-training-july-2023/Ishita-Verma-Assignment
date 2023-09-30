import React, { useState } from 'react';
import './headerComponent.css';
import { useNavigate } from 'react-router-dom';
import Button from '../../components/Button/Button';
import mainpage from '../../Assests/Images/mainpage.png';

const HeaderComponent = ({
  activeTab,
  switchToEmployeeTab,
  switchToManagerTab,
  switchToProjectTab,
}) => {
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem('email'));

  const navigate = useNavigate();

  const handleLogout = () => {
    
    localStorage.removeItem('email');
    localStorage.removeItem('userRole');
    localStorage.removeItem('name');
    localStorage.removeItem('id')
    setIsLoggedIn(false);
    navigate('/');
  };
  console.log(isLoggedIn);
  

  return (
    <div className='header-container'>
      <div className='admin_tabs'>
        <div
          className={`admin_employee ${activeTab === 'employee' ? 'active' : ''}`}
          onClick={switchToEmployeeTab}
        >
          Employee
        </div>
        <div
          className={`admin_manager ${activeTab === 'manager' ? 'active' : ''}`}
          onClick={switchToManagerTab}
        >
          Manager
        </div>
        <div
          className={`admin_project ${activeTab === 'project' ? 'active' : ''}`}
          onClick={switchToProjectTab}
        >
          Project
        </div>
      </div>
      <div className='header-actions'>
        <Button onClick={handleLogout} className='custom-button logout' text='Logout' />
        <img src={mainpage} className='header_img' alt='Main Page' />
      </div>
    </div>
  );
};

export default HeaderComponent;
