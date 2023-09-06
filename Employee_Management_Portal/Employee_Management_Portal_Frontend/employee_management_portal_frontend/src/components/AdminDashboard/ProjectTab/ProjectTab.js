import React, { useEffect, useState } from "react";
import axios from "axios";
import './projecttab.css'

const ProjectTab = () => {
  const [projects, setProjects]  = useState([]);

   useEffect(() => {
    getAllProjects();
  },[]);

  const getAllProjects = async () => {
    try{
       const response = await axios.get(
        "http://localhost:8080/api/admin/projects"
        );
         console.log(response.data);
         setProjects(response.data);
    }
    catch(error){
       console.error("Error fetching data:", error);
    }
  }
  return (
    <div className="card_container">
      {projects.map((project) => (
        <div className="project-info" key={project.projectId}>
          <div className="column">
            <p><strong>Project Name:</strong> {project.name}</p>
            <p><strong>Manager:</strong> {project.managerId}</p>
            <p><strong>Description:</strong> {project.description}</p>
            {/* <p><strong>Team:</strong> {project.team}</p> */}
            <p><strong>Skills:</strong> {project.skills}</p>
          </div>
          <div className="column">
            <p><strong>Project ID:</strong> {project.projectId}</p>
            <p><strong>Start Date:</strong> {project.startDate}</p>
          </div>
        </div>
      ))}
    </div>
  );
};

export default ProjectTab;