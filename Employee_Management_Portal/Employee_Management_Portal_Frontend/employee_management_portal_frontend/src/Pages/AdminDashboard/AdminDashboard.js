import { React, useEffect, useState } from "react";
import "./admindashboard.css";
import AddEmployee from "../../components/AddEmployee/AddEmployee";
import EmployeeTab from "./EmployeeTab/EmployeeTab";
import ManagerTab from "./ManagerTab/ManagerTab";
import ProjectTab from "./ProjectTab/ProjectTab";
import AddProject from "../../components/AddProject/AddProject";
import { useNavigate, Link } from "react-router-dom";
import Button from "../../components/Button/Button";
import HeaderComponent from "../../components/HeaderComponent/HeaderComponent";
import UnAuthorization from "../../components/Unauthorization/Unauthorization";

const AdminDashboard = () => {
  const [showAddEmployee, setShowAddEmployee] = useState(false);
  const [showAddProject, setShowAddProject] = useState(false);
  const [activeTab, setActiveTab] = useState("employee");
  const [role, setRole] = useState(localStorage.getItem("userRole"));

  const toggleAddEmployee = () => {
    setShowAddEmployee(!showAddEmployee);
  };

  const cancelAddEmployee = () => {
    setShowAddEmployee(false);
  };

  const toggleAddProject = () => {
    setShowAddProject(!showAddProject);
  };

  const cancelAddProject = () => {
    setShowAddProject(false);
  };
  const switchToEmployeeTab = () => {
    setActiveTab("employee");
  };

  const switchToManagerTab = () => {
    setActiveTab("manager");
  };

  const switchToProjectTab = () => {
    setActiveTab("project");
  };

  useEffect(() => {
    setRole(localStorage.getItem("role"));
  }, []);

  return (
    <>
      {role === "ADMIN" ? (
        <div className="admindashboard_header">
          <HeaderComponent
            activeTab={activeTab}
            switchToEmployeeTab={switchToEmployeeTab}
            switchToManagerTab={switchToManagerTab}
            switchToProjectTab={switchToProjectTab}
          />
          <Link to={`/requestResource`} className="admin_add_employee">
            &#9993; Request Resource
          </Link>
          {showAddEmployee && (
            <div className="overlay">
              <div className="add_employee_form">
                <AddEmployee />
                <button onClick={cancelAddEmployee} className="exit_btn">
                  Exit
                </button>
              </div>
            </div>
          )}
          {showAddProject && (
            <div className="overlay">
              <div className="add_employee_form">
                <AddProject />
                <button onClick={cancelAddProject} className="exit_btn">
                  Exit
                </button>
              </div>
            </div>
          )}
          {activeTab === "employee" && (
            <div className="addEmployee_div">
              <Button
                onClick={toggleAddEmployee}
                text="Add Employee"
                className="add_employee_btn"
              />
            </div>
          )}

          {activeTab === "project" && !showAddProject && (
            <div>
              <Button
                onClick={toggleAddProject}
                text="Add Project"
                className="admin_add_project"
              />
            </div>
          )}

          <div className="tabs">
            {activeTab === "employee" && <EmployeeTab />}
            {activeTab === "manager" && <ManagerTab />}
            {activeTab === "project" && <ProjectTab />}
          </div>
        </div>
      ) : (
        <UnAuthorization />
      )}
    </>
  );
};

export default AdminDashboard;
