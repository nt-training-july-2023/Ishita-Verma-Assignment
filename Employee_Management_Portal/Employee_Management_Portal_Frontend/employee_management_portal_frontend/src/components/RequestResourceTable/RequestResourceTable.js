import {React,useState,useEffect} from 'react';
import { Link } from 'react-router-dom'; 
import axios from 'axios'
import './requestresourcetable.css';
import Button from '../Button/Button';

const RequestResourceTable = () => {
  const [requestList, setRequestList] = useState([]);
  useEffect(() => {
    getResourceList();
  }, []);

  const getResourceList = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/admin/requests");
      console.log(response.data);
      setRequestList(response.data);
    } catch (error) {
      console.log(error);
    }
  };
  const accept = async (id)=>{
    try{
     const response = await axios.post(`http://localhost:8080/api/admin/manager/request/${id}`);
     console.log(response.data);
     window.location.reload();
    }
    catch(error){
     console.log(error);
    }
  
 }
 const reject = async (id) =>{
  
   try{ 
       const response = await axios.delete(`http://localhost:8080/api/admin/manager/request/delete/${id}`);
       console.log(response.data);
       window.location.reload();
      
     }catch(error){
       console.log(error);
     }
 }
  return (
    <div className='container'>
      <h2 className='request_heading'>ALL REQUESTS</h2>
     
      <table className='custom-table'>
        <thead>
          <tr  className='table_headings' >
            <th>Manager </th>
            <th>Employee </th>
            <th>Project </th>
            <th>Description</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
            {requestList.map((request) => (
              <tr key={request.resourceId} className="custom-table-row">
                <td>
                  {request.managerId} - {request.managerName}
                </td>
                <td>
                  {request.empId} - {request.employeeName}
                </td>
                <td>{request.projectName}</td>
                
                <td>{request.comment}</td>
                <td>
                  <Button
                     className="custom-button  green-button"
                    onClick={() => {
                      accept(request.id);
                    }}
                    text="✔ Accept"
                  >
                  </Button>
                  <Button
                    className="custom-button  red-button"
                    onClick={() => {
                      reject(request.id);
                    }}
                    text="✘ Reject"
                  >
                  </Button>
                </td>
              </tr>
            ))}
          </tbody>
      </table>
      <Link to="/admindashboard"> 
        <button className="admin_dashboard_button">&#8592; Back to Admin Dashboard</button>
      </Link>
    </div>
  );
};

export default RequestResourceTable;
