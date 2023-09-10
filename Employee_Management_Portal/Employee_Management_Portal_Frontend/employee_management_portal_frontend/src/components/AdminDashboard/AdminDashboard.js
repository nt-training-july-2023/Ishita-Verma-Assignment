import {React,useEffect,useState} from 'react'
import './admindashboard.css'
import AddEmployee from './AddEmployee/AddEmployee'
import EmployeeTab from './EmployeeTab/EmployeeTab'
import ManagerTab from './ManagerTab/ManagerTab'
import ProjectTab from './ProjectTab/ProjectTab'
import AddProject from './AddProject/AddProject'
import { useNavigate } from 'react-router-dom'


const AdminDashboard = ({isLoggedIn}) => {

  const [showAddEmployee, setShowAddEmployee] = useState(false);
  const [showAddProject, setShowAddProject] = useState(false);
  const [activeTab, setActiveTab] = useState('employee');
  const navigate = useNavigate();

  // useEffect(() => {
  //   if(!isLoggedIn){
  //     navigate("/login")
  //   }
  // },[isLoggedIn])
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

  return (
    <div className='container'>
        <div className='admin_heading'>Admin Dashboard</div>
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
        {activeTab=== 'employee' && !showAddEmployee && (
          <button className='admin_add_employee' onClick={toggleAddEmployee}>Add Employee</button>
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
