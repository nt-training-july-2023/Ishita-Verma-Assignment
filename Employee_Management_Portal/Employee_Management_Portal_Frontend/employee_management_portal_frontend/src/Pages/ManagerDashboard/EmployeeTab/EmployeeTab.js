import React, { useEffect, useState } from "react";
import "./employee.css";
import axios from "axios";
import DateReverser from "../../../components/DateReverser/DateReverser";
import Skills from "../../../components/Data/Skills";
import MultiSelectDropdown from "../../../components/MultiSelectDropdown/MultiSelectDropdown";
import { useNavigate } from "react-router-dom";
import Button from "../../../components/Button/Button";
import EmployeeService from "../../../service/EmployeeService";

const EmployeeTab = () => {
  const [employees, setEmployees] = useState([]);
  const [selectedSkills, setSelectedSkills] = useState([]);
  const [showUnassigned, setShowUnassigned] = useState(false);
  const [skills, setSkills] = useState([]);
  const [check, setCheck] = useState(false);
  const [error, setError] = useState("");

  useEffect(() => {
    getAllEmployees();
    
  }, []);
  const navigate = useNavigate();

  const ID = localStorage.getItem('id');

  const getAllEmployees = async () => {

    EmployeeService.getEmployees("EMPLOYEE").then((response)=>{
      console.log(response.data);
      setEmployees(response.data);
      response.data.forEach((employee) =>{
        console.log(employee);
        IsRequested(employee);
      });
    }).catch((error)=>{

    })
  };

  const getSkilledEmployee = async (skills, check) => {
    
    try {
      const response = await axios.get(
        `http://localhost:8080/all/employees/skills?skills=${skills}&isCheck=${check}`
      );
      console.log(response.data);
      setEmployees(response.data);
      response.data.forEach((employee) =>{
        console.log(employee);
        IsRequested(employee);
      });
    } catch (error) {
      console.log(error);
    }
  };
  const handleSkillClick = () => {
    if(check===false && skills.length === 0){
      getAllEmployees()
      return
    }
    else{
      getSkilledEmployee(skills, check);
    }
  };
  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
  };
  const handleCheckChange = () => {
    setCheck(!check);
  };

  useEffect(() => {
    if (showUnassigned ) {
      getSkilledEmployee();
    } else {
      getAllEmployees();
    }
  }, [showUnassigned]);

  const IsRequested = async (employeeObject) => {
    EmployeeService.isRequested(`${employeeObject.id}`,`${ID}`).then((response)=>{
     console.log(response.data);
     const requested = response.data;

     setEmployees((prevEmployees) =>
       prevEmployees.map((employee) =>
         employee.id === employeeObject.id
           ? { ...employee, requested: requested }
           : employee
       )
     );
    }).catch((error)=>{
     console.log(error);
    })
  }

  return (
    <div>
      <div className="multi_assign_dropdown search_skill">
        <MultiSelectDropdown
          options={Skills.map((skill) => ({
            label: skill,
            value: skill,
          }))}
         
          selectedOptions={selectedSkills.map((skill) => ({
            value: skill,
            label: skill,
          }))}
          onChange={(event) => {
            {
              handleSkillChange(event);
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
        {error}
      </div>
      <div className="final">
      {employees.sort(function (a, b) {
                    return a.name.localeCompare(b.name);
                }).map((employee) => (
          <div className="card" key={employee.id}>
            <div className="column1">
              <h2 className="employee_name"> <span className='employee_logo'>&#x1F464;</span>{employee.name}</h2>
              <p >{employee.designation} </p>
              <p >
                {employee.projectName ? (
                  <p>
                    <span className="employee_titles">Project Name :</span>{" "}
                    {employee.projectName}
                  </p>
                ) : (
                  <p>
                    <span className="employee_titles">Project Name :</span>{" "}
                    N/A{" "}
                  </p>
                )}
              </p>
              <p>
                <span className="employee_titles">
                  Manager :
                  {" "} </span>
                {employee.manager}
              </p>
              <p>
                <span className="employee_titles">
                  Contact :
                  {" "} </span>
                {employee.contactNumber}
              </p>
              <p>
                <span className="employee_titles">
                  Email :
                  {" "}</span>
                {employee.email}
              </p>
              <p>
                <span className="employee_titles">
                  Skills :
                  {" "} </span>
                {employee.skills.join(", ")}
              </p>
            </div>
            <div className="column2">
              <p
                // className="employee_id"
              >
                <span className="employee_titles">Employee Id :</span>{" "}
                {employee.empId}
              </p>
              <p className="employee_dob">
                <span className="employee_titles">
                  DOB :
                </span>{" "}
                <DateReverser date={employee.dob} />
              </p>
              <p>
                <span className="employee_titles">
                  DOJ :{" "}
                </span>{" "}
                <DateReverser date={employee.doj} />
              </p>
              <p>
                <span className="employee_titles">
                  Location :{" "}
                </span>{" "}
                {employee.location}
              </p>
              <div >
                {employee.projectName === null && (
                  <p>
                    {employee.requested ? (
                      <Button className="requested_btn" text="Requested" />
                    ) : (

                      <Button

                        className="assignProjectbtn"
                        text="Request Resource"
                        onClick={() => {
                          navigate(`/requestResource/${employee.id}`, {
                            state: {
                              empId: employee.id,
                              empName: employee.name,
                            },
                          });
                        }}

                        />
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
