import React, { useEffect, useState } from "react";
import axios from "axios";
import './managertab.css'

const ManagerTab = () => {
  const [employees, setEmployees] = useState([]);
  const [projects, setProjects] = useState([]);
  const [selectedProjectSkills, setSelectedProjectSkills] = useState({});

  useEffect(() => {
    getAllManagers();
    getAllProjects();
  }, []);

  const getAllManagers = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/admin/all/MANAGER"
      );
      console.log(response.data);
      setEmployees(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const getAllProjects = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/admin/projects"
      );
      console.log(response.data);
      setProjects(response.data);
    } catch (error) {
      console.error("Error fetching projects:", error);
    }
  };

  const handleProjectChange = async (employeeId, name) => {
    try {
      const response = await axios.get(
        `http://localhost:8080/api/admin/project/skills?name=${name}`
      );
      const skillsForSelectedProject = response.data;
      setSelectedProjectSkills({
        ...selectedProjectSkills,
        [employeeId]: skillsForSelectedProject,
      });
    } catch (error) {
      console.error("Error fetching skills for project:", error);
    }
  };

  return (
    <div>
      <div className="card_container">
        {employees.map((employee) => (
          <div className="card" key={employee.id}>
            <div className="column">
              <h2 className="employee_name">{employee.name}</h2>
              <p style={{ marginTop: "-0.2rem" }}>{employee.designation}</p>
              <select
                id={`projectDropdown_${employee.id}`}
                defaultValue={employee.project}
                className="manager_project"
                onChange={(e) =>
                  handleProjectChange(employee.id, e.target.value)
                }
              >
                {projects.map((project) => (
                  <option key={project.id} value={project.name}>
                    {project.name}
                  </option>
                ))}
              </select>
              <p><span style={{ fontWeight: "bold", fontSize: "1rem" }}>Contact :</span> {employee.contactNumber}</p>
              <p><span style={{ fontWeight: "bold", fontSize: "1rem" }}>Email : </span> {employee.email}</p>
            </div>
            <div className="column">
              <p className="employee_id" style={{ marginBottom: "1.3rem", fontSize: "1rem" }}><span style={{ fontWeight: "bold" }}>Employee ID:</span> {employee.empId}</p>
              <p><span style={{ fontWeight: "bold", fontSize: "1rem" }}>Project Skills :</span> {selectedProjectSkills[employee.id] || 'No skills available'}</p>
              <p><span style={{ fontWeight: "bold", fontSize: "1rem" }}>Team :</span> </p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default ManagerTab;
