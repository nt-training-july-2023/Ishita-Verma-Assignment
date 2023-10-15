import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './requestresourcetable.css';
import Button from '../Button/Button';
import EmployeeService from '../../service/EmployeeService';
import SubmitPopup from '../SubmitPopup/SubmitPopup';
import RequestStatusPopup from '../RequestPopup/RequestStatusPopup'; 
import accept_request from "../../Assests/Images/accept_request.gif"
import reject_request from '../../Assests/Images/reject_request.gif'

const RequestResourceTable = () => {
  const [requestList, setRequestList] = useState([]);
  const [showNoRequestsPopup, setShowNoRequestsPopup] = useState(false);
  const [showRequestStatusPopup, setShowRequestStatusPopup] = useState(false);
  const [requestStatusMessage, setRequestStatusMessage] = useState('');

  useEffect(() => {
    getResourceList();
  }, []);

  const getResourceList = async () => {
    EmployeeService.listRequestResource().then((response) => {
      setRequestList(response.data);

      if (response.data.length === 0) {
        setShowNoRequestsPopup(true);
      }
    }).catch((error) => {});
  };

  const accept = async (id, employeeName) => {
    EmployeeService.acceptRequest(`${id}`)
      .then((response) => {
        setRequestStatusMessage(`Request accepted for ${employeeName}`);
        setShowRequestStatusPopup(true);
        getResourceList(); 
      })
      .catch((error) => {});
  };

  const reject = async (id, employeeName) => {
    EmployeeService.rejectRequest(`${id}`)
      .then((response) => {
        setRequestStatusMessage(`Request rejected for ${employeeName}`);
        setShowRequestStatusPopup(true);
        getResourceList(); 
      })
      .catch((error) => {});
  };

  return (
    <div className="container">
      <h2 className="request_heading">ALL REQUESTS</h2>

      <table className="custom-table">
        <thead>
          <tr className="table_headings">
            <th>Manager</th>
            <th>Employee</th>
            <th>Project</th>
            <th>Description</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {requestList.length === 0 ? (
            <tr>
              <td colSpan="5">No pending requests</td>
            </tr>
          ) : (
            requestList.map((request) => (
              <tr key={request.resourceId} className="custom-table-row">
                <td>
                  {request.managerId} - {request.managerName}
                </td>
                <td>
                  {request.empId} - {request.employeeName}
                </td>
                <td>{request.projectName}</td>

                <td>{request.comment}</td>
                <td className='request_actions'>
                  <Button
                    className="custom-button green-button"
                    onClick={() => {
                      accept(request.id,request.employeeName);
                    }}
                    text="✔ Accept"
                  ></Button>
                  <Button
                    className="custom-button red-button"
                    onClick={() => {
                      reject(request.id,request.employeeName);
                    }}
                    text="✘ Reject"
                  ></Button>
                </td>
              </tr>
            ))
          )}
        </tbody>
      </table>

      <Link to="/admindashboard">
        <button className="admin_dashboard_button">&#8592; Back to Admin Dashboard</button>
      </Link>
      {showRequestStatusPopup && (
        <RequestStatusPopup
          message={requestStatusMessage}
          onClose={() => {
            setShowRequestStatusPopup(false);
            setRequestStatusMessage('');
          }}
          img={requestStatusMessage.startsWith("Request accepted") ? accept_request : reject_request}
          
          />
      )}
     {showNoRequestsPopup && (
       <SubmitPopup
       description="No pending requests"
       onClose={() => setShowNoRequestsPopup(false)}
       onConfirm={() => setShowNoRequestsPopup(false)}
       />
       )}
       </div>
  );
};

export default RequestResourceTable;
