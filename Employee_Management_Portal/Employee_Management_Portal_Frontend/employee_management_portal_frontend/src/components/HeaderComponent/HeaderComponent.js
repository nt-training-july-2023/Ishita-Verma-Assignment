import React from 'react'
import './headerComponent.css'

const HeaderComponent = ({ activeTab, switchToEmployeeTab, switchToManagerTab, switchToProjectTab }) => {
  return (
    <div className='admin_tabs'>
    <div className={`admin_employee ${activeTab === 'employee' ? 'active' : ''}`} onClick={switchToEmployeeTab}>
      Employee
    </div>
    <div className={`admin_manager ${activeTab === 'manager' ? 'active' : ''}`} onClick={switchToManagerTab}>
      Manager
    </div>
    <div className={`admin_project ${activeTab === 'project' ? 'active' : ''}`} onClick={switchToProjectTab}>
      Project
    </div>
  </div>
);
}

export default HeaderComponent
