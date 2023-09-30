import React from 'react';
import '../HeaderComponent/headerComponent.css'; // Import the CSS file for HeaderComponent
import { useNavigate } from 'react-router-dom';
import mainpage from '../../Assests/Images/mainpage.png';
import Button from '../../components/Button/Button';

const HeaderEmployee = ({ activeTab }) => {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem('email');
    localStorage.removeItem('userRole');
    navigate('/');
  };

  return (
    <div className='header-container'>
      <div className='admin_tabs'>
        <div
          className={`admin_employee ${activeTab === 'profile' ? 'active' : ''}`}
          onClick={() => navigate('/employee/profile')}
        >
          Profile
        </div>
        <div
          className={`admin_manager ${activeTab === 'organization' ? 'active' : ''}`}
          onClick={() => navigate('/employee/organization')}
        >
          Organization
        </div>
      </div>
      <div className='header-actions'>
        <Button onClick={handleLogout} className='custom-button logout' text='Logout' />
        <img src={mainpage} className='header_img' alt='Main Page' />
      </div>
    </div>
  );
};

export default HeaderEmployee;
