import axios from 'axios'
import {GET_PROJECTS_BASE_URL,ADD_PROJECT_BASE_URL,ASSIGN_PROJECT_BASE_URL,UNASSIGN_PROJECT_BASE_URL,GET_PROJECT_BY_ID_BASE_URL} from "./API";

class ProjectService{
    getProjects(){
        return axios.get(GET_PROJECTS_BASE_URL);
     }
     addProject(data){
      return axios.post(ADD_PROJECT_BASE_URL,data);
   }
     assignProject(projectId,managerId,empId){
        return axios.put(ASSIGN_PROJECT_BASE_URL+empId,{
             projectId: projectId,
             managerId: managerId,
        });
     }
}
export default new ProjectService();