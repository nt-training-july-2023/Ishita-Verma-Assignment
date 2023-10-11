import React from "react";
import Popup from "../Popup/Popup";
import DateReverser from "../DateReverser/DateReverser";

const ProjectCard = ({
  project,
  managerName,
  onReadMoreClick,
  onClosePopup,
  showPopup,
}) => {
  const handleReadMoreClick = () => {
    onReadMoreClick(project.description);
  };

  return (
    <div className="project-info" key={project.projectId}>
      <div className="column1">
        <h2>&#128189;{project.projectName}</h2>
        <p>
          <strong>Head :</strong> {managerName}
        </p>
        <p >
          <strong>          
            Description :
          </strong>
          {project.description.length > 40 ? (
            <p>
              {project.description.slice(0, 20)}{" "}
              <span
                onClick={handleReadMoreClick}
              >
              <span className="description_readmore"> Read More</span> 
              </span>
            </p>
          ) : (
            <p>{project.description}</p>
          )}
        </p>
        <p>
          <strong>Team :</strong> {project.teams.join(", ")}
        </p>
      </div>
      <div className="column2">
        <p>
          <strong>Project ID :</strong> {project.projectId}
        </p>
        <p>
          <strong>Start Date :</strong>{" "}
          <DateReverser date={project.startDate} />
        </p>
        <p style={{ fontSize: "1rem" }} className="project_skills">
          <span
            className="project_skills"
            style={{
              fontWeight: "bold",
              fontSize: "1rem",
              
            }}
          >
            Skills :
          </span>{" "}
          {project.skills.join(", ")}
        </p>

        {showPopup && (
          <Popup description={project.description} onClose={onClosePopup} />
        )}
      </div>
    </div>
  );
};

export default ProjectCard;
