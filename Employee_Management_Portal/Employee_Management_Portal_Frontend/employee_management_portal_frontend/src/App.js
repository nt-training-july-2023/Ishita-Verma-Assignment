import React from "react";
import { BrowserRouter as Router, Route, Routes,Navigate } from "react-router-dom";
import Login from "../src/Pages/Login/Login"
import AdminDashboard from "./Pages/AdminDashboard/AdminDashboard";
import Assign from "./components/AssignButton/Assign";
import Registration from '../src/Pages/Registration/Registration'
import EmployeeManagementPage from "./Pages/EmployeeMangementPage/EmployeeManagementPage";
import EmployeeDashboard from "./Pages/EmployeeDashboard/EmployeeDashboard";
import ManagerDashboard from "./Pages/ManagerDashboard/ManagerDashboard";
import UpdateSkills from "./components/UpdateSkills/UpdateSkills";
import RequestResource from "./components/RequestResource/RequestResource";


function App() {

  return (
   <>
    <Router>
        <Routes>
          <Route path="/" Component={EmployeeManagementPage}/>
          <Route path="/register" Component={Registration} />
          <Route path="/login" Component={Login} />
          <Route path="/admindashboard" Component={AdminDashboard} />
          <Route path="/employeedashboard" Component={EmployeeDashboard}/>
          <Route path="/managerdashboard" Component={ManagerDashboard} />
          <Route path="/assign/project/:id" Component={Assign}/>
          <Route path="/updateProject/:id" Component={UpdateSkills}/>
          <Route path="/requestResource/:id" Component={RequestResource}/>
        </Routes>
      </Router>
      {/* <RequestResource/> */}
    </>
  );
}

export default App;
