import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/users/';

const getUser = (user_id) => {
     return axios
     .get(API_URL + `${user_id}`, { headers: authHeader() }) 
     .catch((error) => {
         console.error(error);
     });
}

const UserService = {
    getUser,
}
  
export default UserService;