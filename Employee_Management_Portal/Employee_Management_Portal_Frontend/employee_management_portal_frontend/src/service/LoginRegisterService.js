import axios from 'axios'
import {LOGIN_BASE_URL, REGISTER_BASE_URL} from "./API";

class LoginRegisterService{
    addAdmin(admin){
        return axios.post(REGISTER_BASE_URL,admin)
     }
 
     login(loginData){
         return axios.post(LOGIN_BASE_URL,loginData);
     }
}