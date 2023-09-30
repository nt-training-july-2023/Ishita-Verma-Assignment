import axios from 'axios'
import {GET_EMPLOYEE_BASE_URL,ADD_EMPLOYEE_BASE_URL,MYPROFILE_BASE_URL,
    ORGANIZATION_BASE_URL,IS_REQUESTED_BASE_URL,SKILLS_AND_UNASSIGN_BASE_URL,UPDATE_SKILLS_BASE_URL} from "./API";
    class EmployeeService{
        getEmployees(role){
            return axios.get(GET_EMPLOYEE_BASE_URL + role)
         }
        getEmployeeById(id){
            return axios.get(MYPROFILE_BASE_URL+id);
        }
        getOrganizationEmployee(){
            return axios.get(ORGANIZATION_BASE_URL);
         }
         isRequested(empId,managerId){
            console.log(empId,managerId)
            return axios.get(IS_REQUESTED_BASE_URL + `empId=${empId}&managerId=${managerId}`);
            
         }
    }
    export default new EmployeeService();