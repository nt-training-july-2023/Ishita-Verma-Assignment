import React from 'react'
import './employeemanagementpage.css'
import main_page from '../../Assests/Images/mainpage.png'
import { useNavigate } from "react-router-dom";

const EmployeeManagementPage = () => {
    const navigate = useNavigate();
  return (
    <div className='container'>
    <div><img src={main_page} className='main_page'/></div>
    <div className='page_heading'>Employee Management Portal</div>
    <div className='page_description'> An employee management portal is a software application that provides a centralized platform for organizations to efficiently manage various aspects of their workforce. It helps streamline and automate tasks related to employee data, administration, communication, and performance.</div>
    
    <div class="button">
            <div className="btn" onClick={() => navigate("/register")} type="submit">
              <span className="btn-text">Register</span>
            </div>
            <div className="btn" onClick={() => navigate("/login")}>
              <span className="btn-text">Login</span>
            </div>
          </div>
    
    </div>
  )
}

export default EmployeeManagementPage
