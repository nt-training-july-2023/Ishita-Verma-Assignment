import axios from 'axios';

const registerURL = "http://localhost:8080/api/admin/register";
const loginURL = "http://localhost:8080/api/admin/login";
 class AdminService{
   
    registerAdmin(admin){
        return axios.post(registerURL,admin);
    }
    loginAdmin(admin){
        return axios.post(loginURL,admin);
    }
    

}
export default new AdminService();