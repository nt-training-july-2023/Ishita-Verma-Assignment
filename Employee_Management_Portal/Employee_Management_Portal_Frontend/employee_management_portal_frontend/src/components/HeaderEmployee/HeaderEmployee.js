import {React,useState} from 'react';
import '../HeaderComponent/headerComponent.css'; 
import { useNavigate } from 'react-router-dom';
import mainpage from '../../Assests/Images/mainpage.png';
import Button from '../../components/Button/Button';


const HeaderEmployee = () => {
  const navigate = useNavigate();
  const [activeTab, setActiveTab] = useState("profile");
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem('email'));

  const handleLogout = () => {
    localStorage.removeItem('email');
    localStorage.removeItem('userRole');
    localStorage.removeItem('name');
    localStorage.removeItem('id');
    localStorage.removeItem('IsLoggedIn')
    navigate('/');
  };
  const switchToProfileTab = () => {
    setActiveTab("profile");
  };

  const switchToOrganizationTab = () => {
    setActiveTab("organization");
  };
  return (
    <div className='header-container'>
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
  );
};

export default HeaderEmployee;
