import React,{useState,useEffect} from "react";
import { useLocation,useNavigate } from 'react-router-dom';
import DateReverser from "../DateReverser/DateReverser";
import Button from '../Button/Button'
import EmployeeService from "../../service/EmployeeService";
import Popup from "../Popup/Popup";

const Card= ({employee}) => {
  const [showUnassignConfirm, setShowUnassignConfirm] = useState(false);
  const [unassignEmployeeId, setUnassignEmployeeId] = useState(null);

 
  const unassignProject = (employeeId) => {

    setUnassignEmployeeId(employeeId);
    setShowUnassignConfirm(true);
  };

  const confirmUnassign = async () => {
    EmployeeService.unassignProject(`${unassignEmployeeId}`).then((response)=>{
     setShowUnassignConfirm(false);
     window.location.reload();
    }).catch((error)=>{

    })
 };
  const navigate = useNavigate()

  const location = useLocation();
  const stateData = location.stateData;
  // console.log("stateData" + stateData);

  return (
    <>
    <div className="card" key={employee.id}>
    <div className="column1">
              <h2 className="employee_name"> <span className='employee_logo'>&#x1F464;</span> {employee.name}</h2>
              <p >{employee.designation}</p>
              <p>
                  <span className="employee_titles">Project Name :</span>{" "}
                  {employee.projectName ? employee.projectName : "N/A"}
                </p>
              
              <p>
                <span className="employee_titles">Manager :</span>{" "}
                {employee.manager}
              </p>
              <p >
                <span className="employee_titles" >Contact :</span>{" "}
                {employee.contactNumber}
              </p>
              <p>
                <span className="employee_titles">Email :</span>{" "}
                {employee.email}
              </p>
            </div>
            <div className="column2">
              <p>
                <span className="employee_titles">Employee Id :</span> {employee.empId}
              </p>
              <p className="employee_dob">
                <span className="employee_titles">DOB :</span>{" "}
                <DateReverser date={employee.dob} />
              </p>
              <p>
                <span className="employee_titles" >DOJ :{" "}</span>
                <DateReverser date={employee.doj} />
              </p>
              <p>
                <span className="employee_titles">Location :{" "}</span>
                {employee.location}
              </p>
              <div className="assign_project">
                {employee.projectName ? (
                  <Button className="custom-button green-button" onClick={() => unassignProject(employee.id)}
                  text="Unassign Project"/>
                ) : (
                 
                  <Button
                  onClick={() => {
                    navigate( `/assign/project/${employee.id}`, {
                      state: { empId: employee.id, empName: employee.name },
                    });
                  }}
                  className="assign_btn"
                  text=" Assign Project"
                />  
                )}
              </div>
            </div>
            </div>
            
      {showUnassignConfirm && (
        <Popup
          description="Are you sure you want to unassign this project?"
          onClose={() => setShowUnassignConfirm(false)}
          onConfirm={confirmUnassign}
        >
          <button onClick={confirmUnassign}></button>
        </Popup>
      )}
    </>
  );
};

export default Card;
