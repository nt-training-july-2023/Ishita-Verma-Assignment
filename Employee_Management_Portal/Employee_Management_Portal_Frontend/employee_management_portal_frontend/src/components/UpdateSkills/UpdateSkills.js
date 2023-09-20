import axios from 'axios';
import './updateskills.css'
import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';
import MultiSelectDropdown from '../MultiSelectDropdown/MultiSelectDropdown';
import Skills from '../Data/Skills'


function UpdateSkills() {
    const [employeeDetails, setEmployeeDetails] = useState([]);
    const [projectsList, setProjectsList] = useState([]);
    const [skills, setSkills] = useState([]);
    const [selectedSkills, setSelectedSkills] = useState([]);
    const [fetchData, setFetchData] = useState(false);
    const [showPopup, setShowPopup] = useState(false)
    const [popMessage, setPopMessage] = useState("");
    const [skillsError, setSkillsError] = useState("");

    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        getEmployee();

    }, []);
    const getEmployee = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/admin/all/employee/${id}`)
            setEmployeeDetails(response.data);
            setTimeout(() => {
                setFetchData(true);
            }, 200);
            console.log(response.data);
        }
        catch (error) {
            console.log(error)
        }
    }

    useEffect(() => {
        console.log("effect", employeeDetails.skills);
        if (employeeDetails.skills) {
            setSelectedSkills(employeeDetails.skills);
        }
    }, [employeeDetails]);

    const handleSkillChange = (selectedOptions) => {
        const selectedSkillsValues = selectedOptions.map((option) => option.value);
        setSkills(selectedSkillsValues);
        setSkillsError("");

    };

    const handleSkillBlur = (e) => {
        const skillError = skills.length === 0 ? " Skill is required" : "";

        setSkillsError(skillError);
    };
    const update = async () => {

        if (skills.length === 0) {
            setSkillsError("Atleast update one skills");
            return;
        }
        try {
            const response = await axios.put(`http://localhost:8080/api/admin/employee/${id}/skills`, {
                skills: skills,


            });
            console.log('Employee updated:', response.data);
            setShowPopup(true);
            setPopMessage(response.data.message);
            const navigateToDashboard = () => {
                navigate("/EmployeeDashboard");
            };
            setTimeout(navigateToDashboard, 2000);
        } catch (error) {
            console.error('Error updating employee:', error);
        }
    };

    return (
         <div className='assign'>
             <div className='assign_form'> 
            <h1 className='assignHeading'>Update Skills</h1>
            <h3> {employeeDetails.name}</h3>
            {fetchData && <MultiSelectDropdown
                options={Skills.map((skill) => ({
                    value: skill,
                    label: skill,
                }))}
                selectedOptions={selectedSkills.map((skill) => ({
                    value: skill,
                    label: skill,
                }))}
                onChange={handleSkillChange}
                placeholder="Select Skills"
                onBlur={handleSkillBlur}
                className="skillsInput"
            />}
            {skillsError && <div>{skillsError}</div>}
            <div className='buttonsContainer'>
                <button onClick={(e) => update(e)} className='assign_btn'> Update</button>
                <Link to="/EmployeeDashboard" ><button className='update_cancel_btn'>Cancel</button></Link>
            </div>
            {/* {showPopup && (<PopUpSuccess message={popMessage} />)} */}
        </div>
        </div>
    )
}

export default UpdateSkills;