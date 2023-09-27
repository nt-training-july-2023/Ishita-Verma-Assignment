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
        <h2 style={{ fontSize: "1.5rem" }}>{project.projectName}</h2>
        <p>
          <span style={{ fontWeight: "bold" }}>Head :</span> {managerName}
        </p>
        <p style={{ fontSize: "1rem" }}>
          <span
            style={{
              fontWeight: "bold",
              fontSize: "1rem",
             
            }}
          >
            Description :
          </span>
          {project.description.length > 40 ? (
            <p>
              {project.description.slice(0, 20)}{" "}
              <span
                style={{
                  color: "blue",
                  textDecorationLine: "underline",
                  cursor: "pointer",
                }}
                onClick={handleReadMoreClick}
              >
                Read More
              </span>
            </p>
          ) : (
            <p>{project.description}</p>
          )}
        </p>
        <p>
          <strong>Team:</strong> {project.teams.join(", ")}
        </p>
      </div>
      <div className="column2">
        <p>
          <strong>Project ID:</strong> {project.projectId}
        </p>
        <p>
          <strong>Start Date:</strong>{" "}
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
            Skills:
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
