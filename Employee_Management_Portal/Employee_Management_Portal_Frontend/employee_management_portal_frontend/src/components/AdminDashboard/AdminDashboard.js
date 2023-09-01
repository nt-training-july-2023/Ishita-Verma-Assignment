import React from 'react'
import './admindashboard.css'

const AdminDashboard = () => {
  return (
    <div className='container'>
        <div className='admin_heading'>Admin Dashboard</div>
      <div className='admin_tabs'>
        <div className='admin_employee'>Employee</div>
        <div className='admin_manager'>Manager</div>
        <div className='admin_project'>Project</div>
      </div>
      <div></div>
    </div>
  )
}

export default AdminDashboard
