import React, { useEffect, useState } from "react";
import './employee.css'
import axios from "axios";
import DateReverser from "../../../components/DateReverser/DateReverser";
import Skills from "../../../components/Data/Skills";
import MultiSelectDropdown from "../../../components/MultiSelectDropdown/MultiSelectDropdown";
import { Link } from "react-router-dom";

const EmployeeTab = () => {
  const [employees, setEmployees] = useState([]);
  const [selectedSkills, setSelectedSkills] = useState([]);
  const [showAssigned, setShowAssigned] = useState(false);
  const [showUnassigned, setShowUnassigned] = useState(false);
  const [skills, setSkills] = useState([]);
  const [check,setCheck]=useState(false);

  useEffect(() => {
    getAllEmployees();
  }, []);

  const getAllEmployees = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/admin/all/EMPLOYEE"
      );
      console.log(response.data);
      setEmployees(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const getSkilledEmployee =async (skills,check) =>{
    try{
      const response= await axios.get(`http://localhost:8080/api/admin/all/employees/skills?skills=${skills}&isCheck=${check}`)
      console.log(response.data);
      setEmployees(response.data);
    }catch(error){
      console.log(error);
    }
    }
 const handleSkillClick = () => {
  console.log(skills);
  //setIsClick(true);
  console.log(check);
  //setActiveTab("");
  getSkilledEmployee(skills,check);
//  {<EmployeeTab skills={skills} isCheck={check} />}

};
const handleSkillChange = (selectedOptions) => {
  const selectedSkillsValues = selectedOptions.map((option) => option.value);
  setSkills(selectedSkillsValues);
};
const handleCheckChange=()=>{
  setCheck(!check)
  
}

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
        "http://localhost:8080/api/admin/unassigned",
        { params: queryParams }
      );

      setEmployees(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };
<div>
<label>Search Skills:</label>
<div className="managerDashboard_dropdown">
  <MultiSelectDropdown
    options={Skills.map((skill) => ({
      value: skill,
      label: skill,
    }))}
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
    //onBlur={handleSkillBlur}
    //className="skillsInput"
  />
  
  <label for="myCheckbox">Unassigned Employee:</label>
<input type="checkbox" name="myCheckbox" value="option1"
onChange={handleCheckChange}
checked={check}
/>
{/* <label for="myCheckbox">Option 1</label> */}   
<button onClick={handleSkillClick}>Search Employee</button>
</div>
{/* <EmployeeTab/> */}
{/* <EmployeeTab skills={skills} isCheck={check} /> */}
{/* {!isClick && <EmployeeTab />}
{isClick && <SearchSkills skills={skills} isCheck={check} />} */}
 </div>
  return (
    <div>
      <div>
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
      </div>
      <div>
      <label for="myCheckbox">Unassigned Employee:</label>
<input type="checkbox" name="myCheckbox" value="option1"
onChange={handleCheckChange}
checked={check}
/>
<button onClick={handleSkillClick}>Search Employee</button>
      </div>
  
      <div className="card_container">
        {employees.map((employee) => (
          <div className="card" key={employee.Id}>
            <div className="column1">
              <h2 className="employee_name">{employee.name}</h2>
              <p style={{ marginTop: "-0.2rem" }}>{employee.designation} </p>
              <p style={{ marginTop: "1rem" }}>
                {employee.projectName ? (
                  <p>
                    <span style={{ fontWeight: "bold" }}>Project Name :</span>
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
                </span>
                { employee.manager}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Contact :
                </span>
                {employee.contactNumber}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Email :
                </span>
                {employee.email}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Skills :
                </span>
                {employee.skills.join(', ')}
              </p>

             
            </div>
            <div className="column2">
              <p
                className="employee_id"
                style={{ marginBottom: "1.3rem", fontSize: "1rem" }}
              >
                <span style={{ fontWeight: "bold" }}>Employee ID:</span>{" "}
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
                  DOJ:{" "}
                </span>{" "}
                <DateReverser date={employee.doj} />
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Location :{" "}
                </span>{" "}
                {employee.location}
              </p>
              <div style={{marginTop:"2rem"}}>
              {employee.projectName === null && (
                <Link
                to={`/requestResource/${employee.id}`}
                className="assign_btn" 
                return employee={employee}
              >
                Request Resource
              </Link>
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
