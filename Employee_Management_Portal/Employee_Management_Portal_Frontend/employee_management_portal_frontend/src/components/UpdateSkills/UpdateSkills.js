import React, { useEffect, useState } from 'react'
import './updateskills.css'
import { Link, useNavigate, useParams } from 'react-router-dom';
import MultiSelectDropdown from '../MultiSelectDropdown/MultiSelectDropdown';
import Skills from '../Data/Skills'
import EmployeeService from '../../service/EmployeeService';
import Button from '../Button/Button';

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
        EmployeeService.getEmployeeById(`${id}`).then((response)=>{
            setEmployeeDetails(response.data);
            setTimeout(() => {
                setFetchData(true);
            }, 200);
            console.log(response.data);
        })
    }

    useEffect(() => {
        console.log("effect", employeeDetails.skills);
        if (employeeDetails.skills) {
            setFetchData(true);
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
        EmployeeService.updateSkills(`${id}`,skills).then((response)=>{
            setShowPopup(true);
            setPopMessage(response.data.message);
            const navigateToDashboard = () => {
                navigate("/EmployeeDashboard");
            };
            setTimeout(navigateToDashboard, 2000);
        }).catch((error)=>{

        })
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
                <Button onClick={(e) => update(e)} className='assign_btn' text="Update"/>
                <Link to="/EmployeeDashboard" >
                    <Button className='update_cancel_btn' text="Cancel" /></Link>
            </div>
        </div>
        </div>
    )
}

export default UpdateSkills;