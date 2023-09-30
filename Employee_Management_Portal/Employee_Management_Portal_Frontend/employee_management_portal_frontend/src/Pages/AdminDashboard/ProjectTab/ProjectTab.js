import React, { useEffect, useState } from "react";
import axios from "axios";
import "./projecttab.css";
import ProjectCard from "../../../components/Card/ProjectCard";
import Popup from "../../../components/Popup/Popup";
import ProjectService from "../../../service/ProjectService";

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
    ProjectService.getProjects().then((response)=>{
      console.log(response.data);
      setProjects(response.data);
    }). catch ((error) => {
      console.error("Error fetching data:", error);
    })
  };

  async function getManagerNames() {
    const managerNamePromises = projects.map(async (project) => {
      try {
        const res = await axios.get(
          `http://localhost:8080/all/employee/${project.managerId}`
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
    <div>
      <div className="card_container">
        {projects.map((project) => (
          <ProjectCard
            key={project.projectId}
            project={project}
            managerName={managerNames[project.projectId]}
            onReadMoreClick={(description) => handleReadMoreClick(description)}
            // onClosePopup={handlePopupClose}
            // showPopup={showPopup}
          />
        ))}
      </div>
      {showPopup && (
        <Popup
          description={selectedDescription}
          onClose={handlePopupClose}
          onConfirm={null}
        />
      )}
      </div>
    );
  };

export default ProjectTab;
