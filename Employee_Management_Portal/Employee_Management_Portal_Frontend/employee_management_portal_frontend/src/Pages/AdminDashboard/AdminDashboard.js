import {React,useEffect,useState} from 'react'
import './admindashboard.css'
import AddEmployee from '../../components/AddEmployee/AddEmployee'
import EmployeeTab from './EmployeeTab/EmployeeTab'
import ManagerTab from './ManagerTab/ManagerTab'
import ProjectTab from './ProjectTab/ProjectTab'
import AddProject from '../../components/AddProject/AddProject'
import { useNavigate } from 'react-router-dom'
import Button from "../../components/Button/Button"
import HeaderComponent from '../../components/HeaderComponent/HeaderComponent'


const AdminDashboard = () => {

  const [showAddEmployee, setShowAddEmployee] = useState(false);
  const [showAddProject, setShowAddProject] = useState(false);
  const [activeTab, setActiveTab] = useState('employee');
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("email"));
 
  const navigate = useNavigate();

  const toggleAddEmployee = () => {
    setShowAddEmployee(!showAddEmployee);
  };

  const cancelAddEmployee = () => {
    setShowAddEmployee(false);
  };

  const toggleAddProject = () =>{
    setShowAddProject(!showAddProject);
  }

  const cancelAddProject = () => {
    setShowAddProject(false);
  }
  const switchToEmployeeTab = () => {
    setActiveTab('employee');
  };

  const switchToManagerTab = () => {
    setActiveTab('manager');
  };

  const switchToProjectTab = () => {
    setActiveTab('project')
  }

  const handleLogout = () => {
    localStorage.removeItem("email");
    localStorage.removeItem("userRole");
    setIsLoggedIn(false);
    navigate("/login");
  };

  return (
    <div className='container'>
      <div className='admindashboard_header'>
        <div className='admin_heading'>Admin Dashboard</div>
        <HeaderComponent
        activeTab={activeTab}
        switchToEmployeeTab={switchToEmployeeTab}
        switchToManagerTab={switchToManagerTab}
        switchToProjectTab={switchToProjectTab}
      />
      <div>
          <Button onClick={handleLogout} text="Logout" />
        </div>
      </div>
      {showAddEmployee && (
        <div className='add_employee_form'>
          <AddEmployee />
          <button onClick={cancelAddEmployee} className='exit_btn'>Exit</button>
        </div>
      )}
      {showAddProject && (
        <div className='add_employee_form'>
          <AddProject />
          <button onClick={cancelAddProject} className='exit_btn'>Exit</button>
        </div>
      )}
      <div>
      {activeTab === 'employee' && !showAddEmployee && (
          <Button
            onClick={toggleAddEmployee}
            text="Add Employee"
            className="add-employee"
          />
        )}
      </div>
      
      <div>
        {activeTab=== 'project' && !showAddProject && (
          <button className='admin_add_employee' onClick={toggleAddProject}>Add Project</button>
          )}
      </div>

     
      <div className='card_container'>
      {activeTab === 'employee' && (
          <div>
           <EmployeeTab/>
          </div>
        )}
         {activeTab === 'manager' && (
           <div >
           <ManagerTab/>
          </div>
        )}
        {activeTab === 'project' && (
          <div >
           <ProjectTab/>
          </div>
        )}
      </div>
    </div>
  )
}

export default AdminDashboard