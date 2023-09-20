import React, { useEffect, useState } from "react";
import axios from "axios";
import DateReverser from "../../DateReverser/DateReverser";
import Skills from "../../Data/Skills"
import MultiSelectDropdown from "../../MultiSelectDropdown/MultiSelectDropdown";

const EmployeeTab = () => {
  const [employees, setEmployees] = useState([]);
  const [showAssign, setshowAssign] = useState(false);
  const [selectedSkills, setSelectedSkills] = useState("");

  useEffect(() => {
    getAllEmployees();
  }, []);

  //Assign Button
  const toggleAssign = () => {
    setshowAssign(!showAssign);
  };

  const cancelAssign = () => {
    setshowAssign(false);
  };

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
  const handleSkillSelection = (selectedOptions) => {
    setSelectedSkills(selectedOptions.map((option) => option.value));
  };

  const filteredEmployees = employees.filter((employee) => {
    if (selectedSkills.length === 0) {
      return true;
    }
    return selectedSkills.some((skill) => employee.skills.includes(skill));
  });
  
  return (
    <div>
      <div className="card_container">
      <MultiSelectDropdown
          options={Skills.map((skill) => ({
            label: skill,
            value: skill,
          }))}
          style={{marginLeft:"4rem"}}
          selectedOptions={selectedSkills}
          onChange={handleSkillSelection}
          placeholder="Select Skills"
        />
        { filteredEmployees.map((employee) => (
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
              {employee.projectName === null && (
                <button
                  onClick={toggleAssign}
                  className="assign_btn"
                  style={{ marginTop: "0.6rem" }}
                >
                  Request Resource
                </button>
              )}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default EmployeeTab;
