import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from 'react-router-dom';

const RequestResource = () => {
  const [projectsList, setProjectsList] = useState([]);
  const [selectedProject, setSelectedProject] = useState("");
  //const [description, setDescription] = useState("");
  const [comment, setComment] = useState("");
  const [managerId, setManagerId] = useState();
  const [projectId, setProjectId] = useState();
  const [message, setMessage] = useState();

  const {id} =useParams();

  useEffect(() => {
    getAllProjects();
  }, []);

  const getAllProjects = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/admin/projects');
      // console.log(response.target.value);
      setProjectsList(response.data);
    } catch (error) {
      console.error('Error fetching projects:', error);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log("Resource request submitted");
    const requestData = {
      employeeId: id,
      projectId,
      managerId,
      comment,
    };

    // Send the selected project and description to your API endpoint
    try {
      console.log(requestData);
      const response = await axios.post(
        "http://localhost:8080/api/admin/request/resource",
        
          requestData,
          setMessage("Requested")
        
      );

      // Handle the response as needed (e.g., show a success message)
      console.log("Resource request submitted:", response.data);
    } catch (error) {
      console.error("Error submitting resource request:", error);
    }
  };

  const handleSelectChange = (e) => {
    const selectedOption = e.target.options[e.target.selectedIndex];
    const selectedProjectId = e.target.value;
    const selectedManagerId = selectedOption.getAttribute('data-managerid');
    console.log(typeof(selectedManagerId));
    setProjectId(selectedProjectId);
    setManagerId(selectedManagerId);
    console.log(typeof(selectedManagerId,"from handleSelectChange"));
  };

  return (
    <div className="container">
      <div className="assign_form">
        <h1>Request Resource</h1>
        <form onSubmit={handleSubmit}>
          <div>
            <div>Select Project:</div>

            <select
              value={selectedProject}
              className="assign_input"
              style={{ width: "24rem" }}
              onChange={handleSelectChange}
            >
              <option value="">Select a Project</option>
              {projectsList.map((item) => (
          <option
            key={item.projectId}
            value={item.projectId}
            data-managerid={item.managerId}
          >
            {item.projectId} - {item.projectName}
          </option>
        ))}
            </select>
          </div>

          <div>
            <div>Comment:</div>

            <textarea
              value={comment}
              style={{
                border: "solid 0.15rem gray",
                borderRadius: "0.4rem",
              }}
              onChange={(e) => setComment(e.target.value)}
              rows="4"
              cols="50"
            />
          </div>
          <br />
          <button type="submit" className="assign_btn">
          Request Resource
          </button>
        </form>
        <Link to="/managerDashboard" className="cancle-assign">
          Cancel
        </Link>
        {message}
      </div>
    </div>
  );
};

export default RequestResource;
