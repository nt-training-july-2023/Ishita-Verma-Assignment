import React from "react";
import "./admindashboard.css";
import { useNavigate } from "react-router-dom";

const AdminDashboard = () => {
  const navigate = useNavigate();
  const employees = [
    {
      id: 1,
      name: "John Doe",
      employeeId: "E12345",
      dob: "1990-05-15",
      doj: "2020-01-10",
      doe: "2023-01-10",
      location: "New York",
      designation: "Software Engineer",
      contact: "johndoe@example.com",
      manager: "Jane Smith",
      project: "Project X",
    },
    {
      id: 1,
      name: "John Doe",
      employeeId: "E12345",
      dob: "1990-05-15",
      doj: "2020-01-10",
      doe: "2023-01-10",
      location: "New York",
      designation: "Software Engineer",
      contact: "johndoe@example.com",
      manager: "Jane Smith",
      project: "Project X",
    },
    {
      id: 1,
      name: "John Doe",
      employeeId: "E12345",
      dob: "1990-05-15",
      doj: "2020-01-10",
      doe: "2023-01-10",
      location: "New York",
      designation: "Software Engineer",
      contact: "johndoe@example.com",
      manager: "Jane Smith",
      project: "Project X",
    },
    {
      id: 1,
      name: "John Doe",
      employeeId: "E12345",
      dob: "1990-05-15",
      doj: "2020-01-10",
      doe: "2023-01-10",
      location: "New York",
      designation: "Software Engineer",
      contact: "johndoe@example.com",
      manager: "Jane Smith",
      project: "Project X",
    },
    {
      id: 1,
      name: "John Doe",
      employeeId: "E12345",
      dob: "1990-05-15",
      doj: "2020-01-10",
      doe: "2023-01-10",
      location: "New York",
      designation: "Software Engineer",
      contact: "johndoe@example.com",
      manager: "Jane Smith",
      project: "Project X",
    },
    {
      id: 1,
      name: "John Doe",
      employeeId: "E12345",
      dob: "1990-05-15",
      doj: "2020-01-10",
      doe: "2023-01-10",
      location: "New York",
      designation: "Software Engineer",
      contact: "johndoe@example.com",
      manager: "Jane Smith",
      project: "Project X",
    },
    {
      id: 1,
      name: "John Doe",
      employeeId: "E12345",
      dob: "1990-05-15",
      doj: "2020-01-10",
      doe: "2023-01-10",
      location: "New York",
      designation: "Software Engineer",
      contact: "johndoe@example.com",
      manager: "Jane Smith",
      project: "Project X",
    },
    {
      id: 1,
      name: "John Doe",
      employeeId: "E12345",
      dob: "1990-05-15",
      doj: "2020-01-10",
      doe: "2023-01-10",
      location: "New York",
      designation: "Software Engineer",
      contact: "johndoe@example.com",
      manager: "Jane Smith",
      project: "Project X",
    },
    {
      id: 1,
      name: "John Doe",
      employeeId: "E12345",
      dob: "1990-05-15",
      doj: "2020-01-10",
      doe: "2023-01-10",
      location: "New York",
      designation: "Software Engineer",
      contact: "johndoe@example.com",
      manager: "Jane Smith",
      project: "Project X",
    },
  ];
  return (
    <div className="table-container">
      <div className="table_heading">Admin Dashboard</div>
      <div class="button">
        <div className="btn" type="submit">
          <span className="btn-text"> Employee</span>
        </div>
        <div className="btn">
          <span className="btn-text">Manager</span>
        </div>
        <div className="btn">
          <span className="btn-text">Project</span>
        </div>
      </div>
      <div className="table-header">
        <div className="id">ID</div>
        <div className="name">Name</div>
        <div className="employee_id">Emp ID</div>
        <div className="dob">DOB</div>
        <div className="doj">DOJ</div>
        <div className="doe">DOE</div>
        <div className="location">Location</div>
        <div className="designation">Designation</div>
        <div className="contact"> Contact</div>
        <div className="manager">Manager</div>
        <div className="project">Project</div>
      </div>
      {employees.map((employee) => (
        <div className="table-row" key={employee.id}>
          <div>{employee.id}</div>
          <div>{employee.name}</div>
          <div>{employee.employeeId}</div>
          <div>{employee.dob}</div>
          <div>{employee.doj}</div>
          <div>{employee.doe}</div>
          <div>{employee.location}</div>
          <div>{employee.designation}</div>
          <div>{employee.contact}</div>
          <div>{employee.manager}</div>
          <div>{employee.project}</div>
        </div>
      ))}
    </div>
  );
};

export default AdminDashboard;
