import axios from 'axios';
import { REGISTER } from './types';

export function register(data) {
  const req = axios.post('http://localhost:8080/api/users/account/signup', data)
    .then(res => res.data);
  return { type: REGISTER, payload: req }
}