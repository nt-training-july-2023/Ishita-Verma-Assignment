import React, { useEffect, useState } from "react";
import axios from "axios";
import ProjectService from "../../../service/ProjectService";

const SingleManagerCard = ({ manager }) => {
  const [projectsList, setProjectsList] = useState([]);
  const [selectedProject, setSelectedProject] = useState("");
  const [showDropdown, setShowDropdown] = useState(true);
  const [selectedProjectData, setSelectedProjectData] = useState(null);

  async function fetchProjectList() {
    try {
      const response = await axios.get(
        `http://localhost:8080/projects/${manager.id}`
      );
      const projectData = response.data;

      if (projectData.length > 0) {
        const firstProject = projectData[0];
        setSelectedProjectData(firstProject);
        setSelectedProject(firstProject.projectID);
        setShowDropdown(projectData.length > 1);
      } else {
        setSelectedProjectData(null);
        setSelectedProject("N/A");
        setShowDropdown(false);
      }
      setProjectsList(projectData);
    } catch (error) {
      console.log(error);
    }
  }
  useEffect(() => {
    fetchProjectList();
  }, []);

  function handleChange(event) {
    const selectedProjectId = event.target.value;
    setSelectedProject(selectedProjectId);
    const projectData = projectsList.find(
      (project) => project.projectId.toString() === selectedProjectId
    );
    if (projectData) {
      setSelectedProjectData(projectData);
    } else {
      setSelectedProjectData(null);
    }
  }

  return (
    <div>
      <div>
        <div className="card" key={manager.id}>
          <div className="column1">
            <h2 className="employee_name">
              <span className="employee_logo">&#x1F464;</span>
              {manager.name}
            </h2>
            <p>
              <span>{manager.designation}</span>
            </p>
            <p className="manager_titles">
              <span className="employee_titles">Project :</span>{" "}
              {showDropdown ? (
                <select
                  name="projectName"
                  className="select"
                  onChange={handleChange}
                  value={selectedProject}
                >
                  {projectsList.map((project) => {
                    return (
                      <option key={project.projectId} value={project.projectId}>
                        {project.projectName}
                      </option>
                    );
                  })}
                </select>
              ) : (
                <span>
                  {selectedProject === "N/A"
                    ? "N/A"
                    : selectedProjectData?.projectName}
                </span>
              )}
            </p>
            <p className="manager_titles">
              <span className="employee_titles">Location : </span>
              {manager.location}
            </p>
            <p className="manager_titles">
              <span className="employee_titles">Contact : </span>
              {manager.contactNumber}
            </p>
            <p>
              <span className="employee_titles">Email : </span>
              {manager.email}
            </p>
          </div>
          <div className="column2">
            <p>
              <span className="employee_titles">Employee id : </span>
              {manager.empId}
            </p>

            <p className="employee_dob manager_titles">
              <span className="employee_titles">Project Skills :</span>{" "}
              {selectedProjectData?.skills.length > 0
                ? selectedProjectData?.skills.join(", ")
                : "N/A"}
            </p>
            <p>
              <span className="employee_titles">Teams :</span>{" "}
              {selectedProjectData?.teams.length > 0
                ? selectedProjectData?.teams.join(", ")
                : "N/A"}
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SingleManagerCard;
