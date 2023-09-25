import {React,useEffect,useState} from 'react'
import './admindashboard.css'
import AddEmployee from '../../components/AddEmployee/AddEmployee'
import EmployeeTab from './EmployeeTab/EmployeeTab'
import ManagerTab from './ManagerTab/ManagerTab'
import ProjectTab from './ProjectTab/ProjectTab'
import AddProject from '../../components/AddProject/AddProject'
import { useNavigate,Link } from 'react-router-dom'
import Button from "../../components/Button/Button"
import HeaderComponent from '../../components/HeaderComponent/HeaderComponent'

const AdminDashboard = () => {

  const [showAddEmployee, setShowAddEmployee] = useState(false);
  const [showAddProject, setShowAddProject] = useState(false);
  const [activeTab, setActiveTab] = useState('employee');
 
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
      <div className='admindashboard_header'>
       
        <HeaderComponent
        activeTab={activeTab}
        switchToEmployeeTab={switchToEmployeeTab}
        switchToManagerTab={switchToManagerTab}
        switchToProjectTab={switchToProjectTab}
      />
      
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
      {activeTab === 'employee' && (
  <div>
    
    <Button
      onClick={toggleAddEmployee}
      text="Add Employee"
      className="admin_add_employee"
    />
    {/* <Link
      to={`/requestResource`}
      className="admin_add_employee"
    >
      Request Resource
    </Link> */}
  </div>
)}
      <div className='admin_heading'>Welcome Ankita Sharma</div>
     <div>
  {activeTab === 'project' && !showAddProject && (
    <Button
      onClick={toggleAddProject}
      text="Add Project"
      className="admin_add_employee"
    />
  )}
  {/* {activeTab === 'employee' && !showAddEmployee && (
    <Link
      to={`/requestResource`}
      className="admin_add_employee"
      // style={{ marginTop: '1rem', background: 'white', textDecoration: 'none' }}
    >
      Request Resource
    </Link>
  )} */}
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