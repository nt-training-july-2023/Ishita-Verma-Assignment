import React, { useEffect, useState } from "react";
import axios from "axios";

const SingleManagerCard = ({ manager }) => {
  const [projectsList, setProjectsList] = useState([]);
  const [selectedProject, setSelectedProject] = useState("");
  const [showDropdown, setShowDropdown] = useState(true);
  const [skills, setSkills] = useState([]);
  const [teams, setTeams] = useState([]);
  const [selectedProjectData, setSelectedProjectData] = useState(null);
  
  async function fetchProjectList() {
    try {
      const response = await axios.get(
        `http://localhost:8080/projects/${manager.id}`
      );
    //   setProjectsList(response.data);

    //   if (response.data.length === 1) {
    //     setSelectedProject(response.data[0].projectId);
    //     setShowDropdown(false);
    //   }
    // } catch (error) {
    //   console.log(error);
    // }
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

  // useEffect(() => {
  //   const selectedProjectData = projectsList.find(
  //     (project) => project.projectId === selectedProject
  //   );

  //   if (selectedProjectData) {
  //     setTeams(selectedProjectData.teams);
  //     setSkills(selectedProjectData.skills);
  //   } else {
  //     setTeams([]);
  //     setSkills([]);
  //   }
  // }, [selectedProject, projectsList]);

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
    // const selectedProjectData = projectsList.find(
    //   (project) => project.projectId === selectedProjectId
    // );

    // if (selectedProjectData) {
    //   const selectedProjectSkills = selectedProjectData.skills;
    //   const selectedProjectTeams = selectedProjectData.teams;
    //   console.log("Selected Project Skills:", selectedProjectSkills);
    //   setTeams(selectedProjectTeams);
    //   setSkills(selectedProjectSkills);
    // } else {
    //   console.log("Selected Project Does Not Exist");
    //   setTeams([]);
    //   setSkills([]);
    // }
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
                  {/* <option value="" disabled>
                    Select Project
                  </option> */}
                  {projectsList.map((project) => {
                    return (
                      <option key={project.projectId} value={project.projectId}>
                        {project.projectName}
                      </option>
                    );
                  })}
                </select>
              ) : (
                // <span>{projectsList[0].projectName}</span>
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
              {/* {showDropdown
                ? projectsList
                    .filter(
                      (project) => project.projectId + "" === selectedProject
                    )
                    .map((project) =>
                      project.skills.map((skill, index) =>
                        index === project.skills.length - 1
                          ? skill
                          : skill + ", "
                      )
                    )
                : skills.join(", ")} */}
                 {selectedProjectData?.skills.join(", ")}
            </p>
            <p>
              <span style={{ fontWeight: "bold" }}>Teams :</span>{" "}
              {/* {showDropdown
                ? projectsList
                    .filter(
                      (project) => project.projectId + "" === selectedProject
                    )
                    .map((project) =>
                      project.teams.map((team, index) =>
                        index === project.teams.length - 1 ? team : team + ", "
                      )
                    )
                : teams.join(", ")} */}
                {selectedProjectData?.teams.join(", ")}
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SingleManagerCard;
