import React, { useState, useEffect } from "react";
import EmployeeTab from "./EmployeeTab/EmployeeTab";
import ManagerTab from "../AdminDashboard/ManagerTab/ManagerTab";
import ProjectTab from "../AdminDashboard/ProjectTab/ProjectTab";
import HeaderComponent from "../../components/HeaderComponent/HeaderComponent";
import { useNavigate } from "react-router-dom";
import UnAuthorization from "../../components/Unauthorization/Unauthorization";

const ManagerDashboard = () => {
  const [activeTab, setActiveTab] = useState("employee");
  const [role, setRole] = useState(localStorage.getItem('userRole'));
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("email"));
  const [isClick, setIsClick] = useState(false);
  const [check,setCheck]=useState(false);
  const [skills, setSkills] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    setRole(localStorage.getItem('role'));
  }, [])

  const switchToEmployeeTab = () => {
    setActiveTab("employee");
  };

  const switchToManagerTab = () => {
    setActiveTab("manager");
  };

  const switchToProjectTab = () => {
    setActiveTab("project");
  };

  // const handleLogout = () => {
  //   localStorage.removeItem("email");
  //   localStorage.removeItem("userRole");
  //   // setIsLoggedIn(false);
  //   navigate("/login");
  // };

  // const handleSkillChange = (selectedOptions) => {
  //   const selectedSkillsValues = selectedOptions.map((option) => option.value);
  //   setSkills(selectedSkillsValues);
  // };
  // const handleSkillClick = () => {
  //   console.log(skills);
  //   setIsClick(true);
  //   console.log(check)
  //   //setActiveTab("");
  //  {<EmployeeTab skills={skills} isCheck={check} />}
  // };
  // const handleCheckChange=()=>{
  //   setCheck(!check);
  // }
  // const handleChecked = () =>{
  //      setCheck(true);
  // }

  const name= localStorage.getItem("name");

  return (
    <>
    {role === "MANAGER"?(
    <div className="">
      <HeaderComponent  
        activeTab={activeTab}
        switchToEmployeeTab={switchToEmployeeTab}
        switchToManagerTab={switchToManagerTab}
        switchToProjectTab={switchToProjectTab}
      />
     
      <div className="card_container">
        {activeTab === "employee" && (
          <div>
            <EmployeeTab />
          </div>
        )}
        {activeTab === "manager" && (
          <div>
            <ManagerTab />
          </div>
        )}
        {activeTab === "project" && (
          <div>
            <ProjectTab />
          </div>
        )}
      </div>
    </div>
    ): (<UnAuthorization/>)}
    </>
  );
};

export default ManagerDashboard;
