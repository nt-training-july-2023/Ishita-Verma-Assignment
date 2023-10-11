import React, { useState,useEffect } from 'react';
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
  const [userName, setUserName] = useState('');
  const navigate = useNavigate();
  useEffect(() => {
    // Retrieve the user's name from local storage
    const name = localStorage.getItem('name');
    setUserName(name || ''); // Set the user's name in state
  }, []);

  const handleLogout = () => {
    
    localStorage.removeItem('email');
    localStorage.removeItem('role');
    localStorage.removeItem('name');
    localStorage.removeItem('id');
    localStorage.removeItem('isLoggedIn');
    // setIsLoggedIn(false);
    navigate('/');
  };
  // console.log(isLoggedIn);
  

  return (
    <div className='back'>
    <div className='header-container'>
        <div className='admin_heading'>Welcome {userName} !!</div>
      <div className='admin_tabs'>
        <div
          className={`admin_employee ${activeTab === 'employee' ? 'active' : ''}`}
          onClick={switchToEmployeeTab}
        >
        <span className='employee_logo'>&#x1F464;</span>  Employee 
        </div>
        <div
          className={`admin_manager ${activeTab === 'manager' ? 'active' : ''}`}
          onClick={switchToManagerTab}
        >
         <span className='employee_logo'>&#x1F464;</span>  Manager 
        </div>
        <div
          className={`admin_project ${activeTab === 'project' ? 'active' : ''}`}
          onClick={switchToProjectTab}
        >
           <span className='employee_logo'>&#128193;</span> Project
        </div>
      </div>
      <div className='header-actions'>
        <Button onClick={handleLogout} className='custom-button logout' text={<>&#x2192; Logout</>}  />
        <img src={mainpage} className='header_img' alt='Main Page' />
      </div>
    </div>
    </div>
  );
};

export default HeaderComponent;
