import { combineReducers } from 'redux';
import auth from './auth';
import message from './message';
import category from './category';
import user from './user';

export default combineReducers({
  auth,
  message,
  category,
  user,
});
