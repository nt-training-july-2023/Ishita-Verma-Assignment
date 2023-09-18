import axios from 'axios';

const registerURL = "http://localhost:8080/api/admin/register";
const loginURL = "http://localhost:8080/api/admin/login";
const addEmployeeURL = "http://localhost:8080/api/admin/addEmployee"
const addProjectURL = "http://localhost:8080/api/admin/addProject"
const assignProjectURL = "http://localhost:8080/api/admin/employee/{id}/assignProject"
 class AdminService{
   
    registerAdmin(admin){
        return axios.post(registerURL,admin);
    }
    loginAdmin(admin){
        return axios.post(loginURL,admin);
    }
    addEmployee(user){
        return axios.post(addEmployeeURL,user)
    }
    addProject(project){
        return axios.post(addProjectURL,project);
    }
    

}
export default new AdminService();