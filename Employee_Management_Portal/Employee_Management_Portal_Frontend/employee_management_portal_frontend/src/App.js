import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Registration from './components/Registration/Registration';
import Login from './components/Login/Login';

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/register" Component={Registration} />
          <Route path="/login" Component={Login} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
