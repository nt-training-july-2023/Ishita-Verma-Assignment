import React, { useEffect, useState } from "react";
import "./employee.css";
import axios from "axios";
import DateReverser from "../../../components/DateReverser/DateReverser";
import Skills from "../../../components/Data/Skills";
import MultiSelectDropdown from "../../../components/MultiSelectDropdown/MultiSelectDropdown";
import { Link } from "react-router-dom";
import Button from "../../../components/Button/Button";

const EmployeeTab = () => {
  const [employees, setEmployees] = useState([]);
  const [selectedSkills, setSelectedSkills] = useState([]);
  const [showAssigned, setShowAssigned] = useState(false);
  const [showUnassigned, setShowUnassigned] = useState(false);
  const [skills, setSkills] = useState([]);
  const [check, setCheck] = useState(false);

  useEffect(() => {
    getAllEmployees();
    IsRequested();
  }, []);

  // const email = localStorage.getItem("email");
  const id = localStorage.getItem('id');

  const getAllEmployees = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/all/EMPLOYEE"
      );
      console.log(response.data);
      setEmployees(response.data);
      response.data.forEach((employee) =>{
        IsRequested(employee);
      });
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const getSkilledEmployee = async (skills, check) => {
    try {
      const response = await axios.get(
        `http://localhost:8080/all/employees/skills?skills=${skills}&isCheck=${check}`
      );
      console.log(response.data);
      setEmployees(response.data);
    } catch (error) {
      console.log(error);
    }
  };
  const handleSkillClick = () => {
    console.log(skills);
    //setIsClick(true);
    console.log(check);
    //setActiveTab("");
    getSkilledEmployee(skills, check);
    //  {<EmployeeTab skills={skills} isCheck={check} />}
  };
  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
  };
  const handleCheckChange = () => {
    setCheck(!check);
  };

  const getUnassignedEmployees = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/admin/unassigned"
      );
      console.log(response.data);
      setEmployees(response.data);
    } catch (error) {
      console.error("Error fetching unassigned employees:", error);
    }
  };

  useEffect(() => {
    if (showUnassigned) {
      getUnassignedEmployees();
    } else {
      // Fetch all employees when showUnassigned is false
      getAllEmployees();
    }
  }, [showUnassigned]);

  useEffect(() => {
    // Fetch employees when showAssigned checkbox changes
    fetchEmployees();
  }, [showAssigned, selectedSkills]);

  const fetchEmployees = async () => {
    try {
      // Define query parameters based on your filters
      const queryParams = {
        showAssigned,
        selectedSkills: selectedSkills.join(","),
      };

      // Make an HTTP GET request to your Spring controller
      const response = await axios.get(
        "http://localhost:8080/unassigned",
        { params: queryParams }
      );

      setEmployees(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const IsRequested = async (employeeObject) => {
    // console.log(id);
    // console.log(employeeObject.id);
    //const isRequested = async () =>{
    try {
      const response = await axios.get(
        "http://localhost:8080/employee/isRequested",

        {
          employeeId: employeeObject.id,
          managerId: id,
        }
      );
      const requested = response.data;

      setEmployees((prevEmployees) =>
        prevEmployees.map((employee) =>
          employee.id === employeeObject.id
            ? { ...employee, requested: requested }
            : employee
        )
      );

      // console.log(value);
    } catch (error) {
      console.log(error);
    }
  };
  useEffect(() => {
    //isRequested(employees);
  }, []);
  return (
    <div>
      <div className="multi_assign_dropdown">
        <MultiSelectDropdown
          options={Skills.map((skill) => ({
            label: skill,
            value: skill,
          }))}
          style={{ marginLeft: "4rem" }}
          selectedOptions={selectedSkills.map((skill) => ({
            value: skill,
            label: skill,
          }))}
          onChange={(event) => {
            {
              handleSkillChange(event);
            }
            {
              //setIsClick(false);
            }
          }}
          placeholder="Select Skills"
        />

        <div className="unassigned">
          <label for="myCheckbox">Unassigned Employees :</label>{" "}
          <input
            type="checkbox"
            name="myCheckbox"
            value="option1"
            onChange={handleCheckChange}
            checked={check}
          />
          <Button onClick={handleSkillClick} className="custom-button search-button" text='Search Employee'></Button>
        </div>
      </div>
      <div className="final">
      {employees.sort(function (a, b) {
                    return a.name.localeCompare(b.name);
                }).map((employee) => (
          <div className="card" key={employee.Id}>
            <div className="column1">
              <h2 className="employee_name">{employee.name}</h2>
              <p style={{ marginTop: "-0.2rem" }}>{employee.designation} </p>
              <p style={{ marginTop: "1rem" }}>
                {employee.projectName ? (
                  <p>
                    <span style={{ fontWeight: "bold" }}>Project Name :</span>{" "}
                    {employee.projectName}
                  </p>
                ) : (
                  <p>
                    <span style={{ fontWeight: "bold" }}>Project Name :</span>
                    N/A{" "}
                  </p>
                )}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Manager :
                  {" "} </span>
                {employee.manager}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Contact :
                  {" "} </span>
                {employee.contactNumber}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Email :
                  {" "}</span>
                {employee.email}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Skills :
                  {" "} </span>
                {employee.skills.join(", ")}
              </p>
            </div>
            <div className="column2">
              <p
                className="employee_id"
                style={{ marginBottom: "2.6rem", fontSize: "1rem" }}
              >
                <span style={{ fontWeight: "bold" }}>Employee ID :</span>{" "}
                {employee.empId}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  DOB :
                </span>{" "}
                <DateReverser date={employee.dob} />
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  DOJ :{" "}
                </span>{" "}
                <DateReverser date={employee.doj} />
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Location :{" "}
                </span>{" "}
                {employee.location}
              </p>
              <div style={{ marginTop: "1rem" }}>
                {employee.projectName === null && (
                  <p>
                    {console.log(employee.requested)}
                    {employee.requested ? (
                      <button className="requested_btn" disabled>Requested</button>
                    ) : (
                      <Link
                        to={`/requestResource/${employee.id}`}
                        className="assign_btn"
                        return
                        employee={employee}
                      >
                        Request Resource
                      </Link>
                    )}
                  </p>
                )}
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default EmployeeTab;
