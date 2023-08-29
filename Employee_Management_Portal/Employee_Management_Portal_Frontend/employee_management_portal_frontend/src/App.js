import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Registration from './components/Registration/Registration';
import Login from './components/Login/Login';
import AdminDashboard from './components/AdminDashboard/AdminDashboard';
import EmployeeManagementPage from './components/EmployeeMangementPage/EmployeeManagementPage';
import dashboard from './components/dashboard/dashboard';
function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/" Component={EmployeeManagementPage}/>
          <Route path="/register" Component={Registration} />
          <Route path="/login" Component={Login} />
          {/* <Route path="/admindashboard" Component={AdminDashboard} /> */}
          <Route path="/dashboard" Component={dashboard}/>
        </Routes>
      </Router>
    </>
  );
}

export default App;
