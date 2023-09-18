import React, { useEffect, useState } from "react";
import axios from "axios";
import "./projecttab.css";
import Popup from "../ProjectTab/Popup";

const ProjectTab = () => {
  const [projects, setProjects] = useState([]);
  const [showPopup, setShowPopup] = useState(false);
  const [selectedDescription, setSelectedDescription] = useState("");
  const [managerNames, setManagerNames] = useState({});

  useEffect(() => {
    getAllProjects();
  }, []);

  useEffect(() => {
    if (projects.length > 0) {
      getManagerNames();
    }
  }, [projects]);

  const getAllProjects = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/admin/projects"
      );
      console.log(response.data);
      setProjects(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  async function getManagerNames() {
    const managerNamePromises = projects.map(async (project) => {
      try {
        const res = await axios.get(
          `http://localhost:8080/api/admin/all/employee/${project.managerId}`
        );
        return { Id: project.projectId, managerName: res.data.name };
      } catch (error) {
        console.log(error);
        return {
          projectId: project.projectId,
          manager: "Error fetching name",
        };
      }
    });

    const managerNameResults = await Promise.all(managerNamePromises);
    const managerNameMap = {};
    managerNameResults.forEach((result) => {
      // console.log("Project ID:", result.projectId);
      // console.log("Manager Name:", result.managerName);
      managerNameMap[result.Id] = result.managerName;
    });
    // console.log("manager name map", managerNameMap);
    // console.log("Projects:", projects);
    // console.log("Manager Name Results:", managerNameResults);
    setManagerNames(managerNameMap);
  }

  const handleReadMoreClick = (description) => {
    setSelectedDescription(description);
    setShowPopup(true);
  };
  const handlePopupClose = () => {
    setShowPopup(false);
    setSelectedDescription("");
  };
  return (
    <div className="card_container">
      {projects.map((project) => (
        <div className="project-info" key={project.projectId}>
          <div className="column1">
            <h2 style={{ fontSize: "1.5rem" }}>{project.name}</h2>
            <p>
              <span style={{ fontWeight: "bold" }}>Head :</span>
              {managerNames[project.projectId]}
            </p>

            <p style={{ fontSize: "1rem" }}>
              <span
                style={{
                  fontWeight: "bold",
                  fontSize: "1rem",
                  marginTop: "2rem",
                }}
              >
                Description :
              </span>
              {project.description.length > 40 ? (
                <p>
                  {project.description.slice(0, 40)}{" "}
                  <span
                    style={{
                      color: "blue",
                      textDecorationLine: "underline",
                      cursor: "pointer",
                    }}
                    onClick={() => handleReadMoreClick(project.description)}
                  >
                    Read More
                  </span>
                </p>
              ) : (
                <p>{project.description}</p>
              )}
            </p>
          </div>
          <div className="column2">
            <p>
              <strong>Project ID:</strong> {project.projectId}
            </p>
            <p>
              <strong>Start Date:</strong> {project.startDate}
            </p>
            <p style={{ fontSize: "1rem" }} className="project_skills">
              
              <span
              className="project_skills"
                style={{
                  fontWeight: "bold",
                  fontSize: "1rem",
                  marginTop: "2rem",
                }}
              >
                Skills:
              </span>{" "}
              {project.skills.join(", ")}
            </p>
            <p>
              <strong>Team:</strong> {project.team}
            </p>
            {showPopup && (
              <Popup
                description={selectedDescription}
                onClose={handlePopupClose}
              />
            )}
          </div>
        </div>
      ))}
    </div>
  );
};

export default ProjectTab;
