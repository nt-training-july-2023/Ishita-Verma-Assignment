import React from 'react'
import './profile.css'

const ProfileTab = (employee) => {
  const email = localStorage.getItem('email');

  return (
    <div className="employee-details-form">
      <div className="column">
       
        <div>
          <label >Name:</label>
          <span className='profile_field'>{employee.name}</span>
        </div>
        <div>
          <label >Email:</label>
          <span className='profile_field'>{employee.email}</span>
        </div>
        <div>
          <label className='profile_field'>Date of Birth:</label>
          <span>{employee.dob}</span>
        </div>
        <div>
          <label>Skills:</label>
          <span>{employee.skills}</span>
        </div>
      </div>
      <div className="column">
       
        <div>
          <label>Phone Number:</label>
          <span>{employee.phoneNumber}</span>
        </div>
        <div>
          <label>Manager:</label>
          <span>{employee.manager}</span>
        </div>
        <div>
          <label>Project:</label>
          <span>{employee.project}</span>
        </div>
        <div>
          <label>Location:</label>
          <span>{employee.location}</span>
        </div>
        <div>
          <label>Date of Joining:</label>
          <span>{employee.doj}</span>
        </div>
      </div>
    </div>
  )
}

export default ProfileTab
