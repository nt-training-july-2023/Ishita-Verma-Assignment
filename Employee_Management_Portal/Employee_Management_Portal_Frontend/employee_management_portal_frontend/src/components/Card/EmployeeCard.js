import React from "react";
import { Link } from "react-router-dom";
import DateReverser from "../DateReverser/DateReverser";

const Card = ({
  data,
  onUnassignProject,
  onAssignProject,
  managerName,
  managerEmail,
  managerContact,
}) => {
  const {
    id,
    name,
    designation,
    projectName,
    manager,
    contactNumber,
    email,
    dob,
    doj,
    location,
  } = data;

  const handleUnassignProject = () => {
    onUnassignProject(id);
  };

  const handleAssignProject = () => {
    onAssignProject(id);
  };

  return (
    <div className="card" key={id}>
      <div className="column1">
        <h2 className="employee_name">{name}</h2>
        <p style={{ marginTop: "-0.2rem" }}>{designation}</p>
        <p style={{ marginTop: "1rem" }}>
          <p style={{ marginBottom: "0.3rem" }}>
            <span style={{ fontWeight: "bold" }}>Project Name :</span>{" "}
            {projectName ? projectName : "N/A"}{" "}
          </p>
        </p>
        <p style={{ marginBottom: "0.3rem" }}>
          <span style={{ fontWeight: "bold", fontSize: "1rem" }}>Manager :</span>{" "}
          {manager}
        </p>
        <p style={{ marginBottom: "0.3rem" }}>
          <span style={{ fontWeight: "bold", fontSize: "1rem" }}>Contact :</span>{" "}
          {contactNumber}
        </p>
        <p style={{ marginBottom: "0.3rem" }}>
          <span style={{ fontWeight: "bold", fontSize: "1rem" }}>Email :</span>{" "}
          {email}
        </p>
      </div>
      <div className="column2">
        <p className="employee_id" style={{ marginBottom: "2.3rem", fontSize: "1rem" }}>
          <span style={{ fontWeight: "bold" }}>Employee ID :</span> {id}
        </p>
        <p style={{ marginBottom: "0.3rem" }}>
          <span style={{ fontWeight: "bold", fontSize: "1rem" }}>DOB :</span>{" "}
          <DateReverser date={dob} />
        </p>
        <p style={{ marginBottom: "0.3rem" }}>
          <span style={{ fontWeight: "bold", fontSize: "1rem" }}>DOJ :{" "}</span>
          <DateReverser date={doj} />
        </p>
        <p>
          <span style={{ fontWeight: "bold", fontSize: "1rem" }}>Location :{" "}</span>
          {location}
        </p>
        <div className="assign_project">
          {projectName ? (
            <button className="custom-button green-button" onClick={handleUnassignProject}>
              Unassign Project
            </button>
          ) : (
            <Link
            to={{
              pathname: `/assign/project/${id}`,
              state: { empId: id, empName: name },
            }}
              className="assign_btn"
              style={{ marginTop: "1rem" }}
              
            >
              Assign Project
            </Link>
          )}
        </div>
      </div>
      {managerName && managerEmail && managerContact && (
        <div className="column3">
          <p style={{ fontWeight: "bold" }}>Manager:</p>
          <p>{managerName}</p>
          <p style={{ fontWeight: "bold" }}>Email:</p>
          <p>{managerEmail}</p>
          <p style={{ fontWeight: "bold" }}>Contact:</p>
          <p>{managerContact}</p>
        </div>
      )}
    </div>
  );
};

export default Card;
