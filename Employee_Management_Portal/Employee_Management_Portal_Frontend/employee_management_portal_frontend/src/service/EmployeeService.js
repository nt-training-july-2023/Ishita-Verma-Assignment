import axios from 'axios'
import {GET_EMPLOYEE_BASE_URL,ADD_EMPLOYEE_BASE_URL,MYPROFILE_BASE_URL,
    ORGANIZATION_BASE_URL,IS_REQUESTED_BASE_URL,SKILLS_AND_UNASSIGN_BASE_URL,UPDATE_SKILLS_BASE_URL,
    ASSIGN_PROJECT_BASE_URL,REQUEST_RESOURCE_BASE_URL,LIST_REQUESTS_BASE_URL,ACCEPT_REQUESTS_BASE_URL,
    REJECT_REQUESTS_BASE_URL,UNASSIGN_PROJECT_BASE_URL} from "./API";
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
         assignProject(id,projectId,managerId){
            return axios.put(ASSIGN_PROJECT_BASE_URL + id ,{
                projectId:projectId,
                managerId:managerId
            })
         }

         requestResource(data){
            console.log(data);
            return axios.post(REQUEST_RESOURCE_BASE_URL ,data);
         }

         listRequestResource(){
            return axios.get(LIST_REQUESTS_BASE_URL);
         }

         acceptRequest(id){
            return axios.post(ACCEPT_REQUESTS_BASE_URL + id);
         }
         rejectRequest(id){
            return axios.delete(REJECT_REQUESTS_BASE_URL + id);
         }
         updateSkills(id,skills){
            return axios.put(UPDATE_SKILLS_BASE_URL + id , {
                skills:skills
            });
         }
         unassignProject(id){
            return axios.post(UNASSIGN_PROJECT_BASE_URL +id);
         }
    }
    export default new EmployeeService();