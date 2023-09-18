import React from "react";
import { BrowserRouter as Router, Route, Routes,Navigate } from "react-router-dom";
// import ProtectedRoute from "../src/components/Routes/ProtectedRoutes";
import Login from "../src/Pages/Login/Login";
import AdminDashboard from "../src/components/AdminDashboard/AdminDashboard";
import Assign from "./components/AdminDashboard/EmployeeTab/AssignButton/Assign";
import Registration from "./Pages/Registration/Registration"
import EmployeeManagementPage from "../src/components/EmployeeMangementPage/EmployeeManagementPage";
import EmployeeDashboard from "../src/components/EmployeeDashboard/EmployeeDashboard";
import ManagerDashboard from "./components/ManagerDashboard/ManagerDashboard";

function App() {

  return (
   <>
    <Router>
        <Routes>
          <Route path="/" Component={EmployeeManagementPage}/>
          <Route path="/register" Component={Registration} />
          <Route path="/login" Component={Login} />
          <Route path="/admindashboard" Component={AdminDashboard} />
          <Route path="/assign/project/:id" element={Assign}/>
          <Route path="/employeedashboard" Component={EmployeeDashboard}/>
          <Route path="/managerdashboard" Component={ManagerDashboard} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
