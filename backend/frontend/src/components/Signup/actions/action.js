import axios from 'axios';
import { REGISTER_USER } from './types';

export function registerUser(dataTosubmit) {
  const request = axios.post('/users/account/signup', dataTosubmit)
    .then((response) => response.data);
  return { type: REGISTER_USER, payload: request };
}