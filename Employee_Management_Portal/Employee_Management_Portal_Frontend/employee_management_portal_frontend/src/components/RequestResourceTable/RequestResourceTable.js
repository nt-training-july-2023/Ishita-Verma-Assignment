import React from 'react';
import { Link } from 'react-router-dom'; // Import Link from React Router
import './requestresourcetable.css';

const RequestResourceTable = () => {
  return (
    <div className='container'>
      <h2 className='request_heading'>Request Resource</h2>
     
      <table className='custom-table'>
        <thead>
          <tr>
            <th>Project Name</th>
            <th>Manager Name</th>
            <th>Employee Name</th>
            <th>Description</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Ishita Verma</td>
            <td>Project A</td>
            <td>Manager X</td>
            <td>Data 1</td>
            <td>
              <button>Accept</button>
              <button>Reject</button>
            </td>
          </tr>
        </tbody>
      </table>
      <Link to="/admindashboard"> 
        <button className="admin_dashboard_button">Navigate to Admin Dashboard</button>
      </Link>
    </div>
  );
};

export default RequestResourceTable;
