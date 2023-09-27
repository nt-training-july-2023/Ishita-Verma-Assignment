import React, { useEffect, useState } from "react";
import axios from "axios";
import "./managertab.css";
import SingleManagerCard from "./SingleManagerCard";

const ManagerTab = () => {
  const [managers, setManagers] = useState([]);
 
  useEffect(() => {
    getAllManagers();
  }, []);

  const getAllManagers = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/admin/all/MANAGER"
      );
      console.log(response.data);
      setManagers(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

return (
  <div className="final">
    <div className="card_container managerAdmin">
    {managers.map((manager) => (
    <SingleManagerCard key={manager.id} manager={manager} />
))}

    </div>
  </div>
);
    }
export default ManagerTab;
