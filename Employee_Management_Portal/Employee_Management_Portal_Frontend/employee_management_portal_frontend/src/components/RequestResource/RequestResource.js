import React, { useEffect, useState } from "react";
import './requestResource.css'
import { useNavigate } from "react-router-dom";
import { Link, useParams } from 'react-router-dom';
import ProjectService from "../../service/ProjectService";
import EmployeeService from "../../service/EmployeeService";
import Button from "../Button/Button";
import { 
validateSelectProject,
validateDescription } from '../HandleBlur/HandleBlur';

const RequestResource = () => {
  const [projectsList, setProjectsList] = useState([]);
  const [comment, setComment] = useState("");
  const [managerId, setManagerId] = useState();
  const [projectId, setProjectId] = useState();
  const [message, setMessage] = useState();
  const [projectError, setProjectError] = useState();
  const [descriptionError, setDescriptionError]= useState();

  const {id} =useParams();

  const navigate = useNavigate();

  useEffect(() => {
    getAllProjects();
  }, []);

  const getAllProjects = async () => {
    ProjectService.getProjects().then((response)=>{
      setProjectsList(response.data);
    }).catch((error)=>{

    })
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const requestData = {
      employeeId: id,
      projectId,
      managerId,
      comment,
    };

    EmployeeService.requestResource(requestData).then((response)=>{
      setTimeout(() => {
        navigate("/AdminDashboard");
      }, 2000)
    }).catch((error)=>{

    })
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
    <div className="assign">
      <div className="assign_form">
        <h1>Request Resource</h1>
        <form onSubmit={handleSubmit}>
          <div>
            <div>Select Project:</div>

            <select
              className="assign_input"
              style={{ width: "24rem" }}
              onChange={handleSelectChange}
              onBlur={() =>
                validateSelectProject(
                  projectId,
                  setProjectError
                )
              }
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
          {projectError && <div className="error-message assign_error">{projectError}</div>}
          </div>
          <div>
            <div>Comment:</div>

            <textarea
              value={comment}
              style={{
                border: "solid 0.15rem gray",
                borderRadius: "0.4rem",
                
              }}
              onBlur={() =>
                validateDescription(
                  comment,
                  setDescriptionError
                )
              }
              onChange={(e) => setComment(e.target.value)}
              rows="4"
              cols="50"
            />
          </div>
          {descriptionError && <div className="error-message assign_error">{descriptionError}</div>}
          <Button type="submit" className="assign_btn request_btn" text="Request"/>
           
        </form>
        <Link to="/managerDashboard" className="cancel-assign">
        &#8592; Back to Dashboard
        </Link>
        {message}
      </div>
    </div>
  );
};

export default RequestResource;
