import React, { useEffect, useState } from "react";
import axios from "axios";

const EmployeeTab = () => {
  const [employees, setEmployees] = useState([]);
  const [managerNames, setManagerNames] = useState({});
  const [showAssign, setshowAssign] = useState(false);

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

  // async function getManagerNames() {
  //   const managerNamePromises = employees.map(async (employee) => {
  //     try {
  //       const res = await axios.get(
  //         `http://localhost:8080/api/admin/employee/${employee.managerId}`
  //       );
  //       return { id: employee.Id, managerName: res.data.name };
  //     } catch (error) {
  //       console.log(error);
  //       return { id: employee.id, managerName: "Error fetching name" };
  //     }
  //   });

  //   const managerNameResults = await Promise.all(managerNamePromises);
  //   const managerNameMap = {};
  //   managerNameResults.forEach((result) => {
  //     managerNameMap[result.id] = result.managerName;
  //   });
  //   // console.log("manager name map", managerNameMap);
  //   setManagerNames(managerNameMap);
  // }
  // useEffect(() => {
  //   if (employees.length > 0) {
  //     getManagerNames();
  //   }
  // }, [employees]);

  return (
    <div>
      <div className="card_container">
        {employees.map((employee) => (
          <div className="card" key={employee.Id}>
            <div className="column1">
              <h2 className="employee_name">{employee.name}</h2>
              <p style={{ marginTop: "-0.2rem" }}>{employee.designation} </p>
              <p style={{ marginTop: "1rem" }}>
                {employee.project ? (
                  <p>
                    <span style={{ fontWeight: "bold" }}>Project Name :</span>
                    {employee.project}
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
                {employee.dob}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  DOJ:{" "}
                </span>{" "}
                {employee.doj}
              </p>
              <p>
                <span style={{ fontWeight: "bold", fontSize: "1rem" }}>
                  Location :{" "}
                </span>{" "}
                {employee.location}
              </p>
              <button onClick={toggleAssign} className="assign_btn">
                Request Resource
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default EmployeeTab;
