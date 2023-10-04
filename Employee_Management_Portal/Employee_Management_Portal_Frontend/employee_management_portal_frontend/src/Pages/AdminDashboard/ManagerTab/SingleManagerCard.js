import React, { useEffect, useState } from "react";
import axios from "axios";
import ProjectService from "../../../service/ProjectService";

const SingleManagerCard = ({ manager }) => {
  const [projectsList, setProjectsList] = useState([]);
  const [selectedProject, setSelectedProject] = useState("");
  const [showDropdown, setShowDropdown] = useState(true);
  const [selectedProjectData, setSelectedProjectData] = useState(null);
  
  async function fetchProjectList() {

    ProjectService.getProjectById(`${manager.id}`).then((response)=>{

    }).catch((error)=>{
      
    })
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
    console.log(selectedProjectId);
    const projectData = projectsList.find(
      (project) => project.projectId.toString() === selectedProjectId
    );
        console.log(projectData);
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
            <h2 className="employee_name">{manager.name}</h2>
            <p style={{marginBottom:"0.3rem"}}>
              <span style={{ fontSize: "1rem" }}>{manager.designation}</span>
            </p>
            <p className="p-project" style={{marginBottom:"0.3rem"}}>
              <span style={{ fontWeight: "bold" }}>Project :</span>{" "}
              {showDropdown ? (
                <select
                  style={{ marginTop: "0.5rem" }}
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
                <span>{selectedProjectData?.projectName}</span>
              )}
            </p>
            <p style={{marginBottom:"0.3rem"}}>
              <span style={{ fontWeight: "bold" }}>Location : </span>
              {manager.location}
            </p>
            <p style={{marginBottom:"0.3rem"}}>
              <span style={{ fontWeight: "bold" }}>Contact : </span>
              {manager.contactNumber}
            </p>
            <p style={{marginBottom:"0.3rem"}}>
              <span style={{ fontWeight: "bold" }}>Email : </span>
              {manager.email}
            </p>
          </div>
          <div className="column2">
            <p style={{ fontSize: "15px", marginTop: "0.5rem" }}>
              <span style={{ fontWeight: "bold" }}>Employee id : </span>
              {manager.empId}
            </p>

            <p style={{ marginTop: "1rem" }}>
              <span style={{ fontWeight: "bold" }}>Project Skills :</span>{" "}
                 {selectedProjectData?.skills.join(", ")}
            </p>
            <p>
              <span style={{ fontWeight: "bold" }}>Teams :</span>{" "}
                {selectedProjectData?.teams.join(", ")}
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SingleManagerCard;
