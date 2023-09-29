import React, { useState, useEffect } from 'react';
import './organization.css' 
import axios from 'axios'; 
import DateReverser from '../../../components/DateReverser/DateReverser';

const OrganizationTab = () => {
    const [employees, setEmployees] = useState([]);

    useEffect(() => {
      getAllEmployees();
    },[]);
  
    const getAllEmployees = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/getall"
        );
        console.log(response.data);
        setEmployees(response.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };
  
    return (
      <div>
        <div className="card_container">
          {employees.map((employee) => (<div className="card" key={employee.id}>
            <div className="column1">
              <h2 className="employee_name">{employee.name}</h2>
              <p className='org_designation'>{employee.designation} </p>
              <p className='org_fields'><span className='org_headers' >Manager :</span>  {employee.manager}</p>
              <p className='org_fields'><span className='org_headers'>Contact :</span> {employee.contactNumber}</p>
              <p className='org_fields'><span className='org_headers'>Email : </span> {employee.email}</p>
            </div>
            <div className="column2">
              <p className="employee_id"><span className='org_headers'>Employee ID:</span>  {employee.empId}</p>
              <p className='org_fields'><span className='org_headers'>DOB :</span> <DateReverser date={employee.dob} /></p>
              <p className='org_fields'><span className='org_headers'>DOJ : </span> <DateReverser date={employee.doj} /></p>
              <p className='org_fields'><span className='org_headers'>Location : </span> {employee.location}</p>
            </div>
          </div>))}
          
        </div>
      </div>
    );
}

export default OrganizationTab;
