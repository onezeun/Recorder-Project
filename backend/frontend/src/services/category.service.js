import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080';

const createCategory = (categoryId, categoryName ) => {
  return axios.post(API_URL + '/board/categories/', {
    category_id: categoryId,
    categoryName
  }, { headers: authHeader() });
};

const allCategories = () => {
  return axios.get(API_URL + `/board/categories/users/1`, { headers: authHeader() });
};

const findCategory = (category_id) => {
  return axios.get(API_URL + `/board/categories/${category_id}`, { headers: authHeader() });
};

const updateCategory = (category_id, data) => {
  return axios.put(API_URL + `/board/categories/${category_id}`, data, {
    headers: authHeader(),
  });
};
const deleteCategory = (category_id) => {
  return axios.delete(API_URL + `/board/categories/${category_id}`, {
    headers: authHeader(),
  });
};

const CategoryService = {
  createCategory,
  allCategories,
  findCategory,
  updateCategory,
  deleteCategory,
};

export default CategoryService;
