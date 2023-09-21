import React, { useEffect, useState } from "react";
import axios from "axios";

const RequestResource = () => {
  const [projects, setProjects] = useState([]);
  const [selectedProject, setSelectedProject] = useState("");
  const [description, setDescription] = useState("");

  useEffect(() => {
    getAllProjects();
  }, []);

  const getAllProjects = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/admin/projects"
      );
      setProjects(response.data);
    } catch (error) {
      console.error("Error fetching projects:", error);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    // Send the selected project and description to your API endpoint
    try {
      const response = await axios.post(
        "http://localhost:8080/api/submitResourceRequest",
        {
          project: selectedProject,
          description: description,
        }
      );
      
      // Handle the response as needed (e.g., show a success message)
      console.log("Resource request submitted:", response.data);
    } catch (error) {
      console.error("Error submitting resource request:", error);
    }
  };

  return (
    <div className="container">
      <div className='assign_form'> 
      <h1>Request Resource</h1>
      <div onSubmit={handleSubmit}>
            <div> Select Project:</div>
         
          <select
            value={selectedProject}
            className='assign_input'
            style={{width:"24rem"}}
            onChange={(e) => setSelectedProject(e.target.value)}
          >
            <option value="">Select a Project</option>
            {projects.map((project) => (
              <option key={project.id} value={project.name}>
                {project.name}
              </option>
            ))}
          </select>
        </div>
        
        <div>
            <div> Comment:</div>
         
          <textarea
            value={description}
            style={{border:"solid 0.15rem gray", borderRadius:"0.4rem"}}
            onChange={(e) => setDescription(e.target.value)}
            rows="4"
            cols="50"
          />
        </div>
        <br />
        <button type="Request Resource" className="assign_btn">Submit</button>
      </div>
    </div>
  );
};

export default RequestResource;
