import { CREATE_CATEGORY, ALL_CATEGORIES, FIND_CATEGORY, UPDATE_CATEGORT, DELETE_CATEGORY } from "./types";
import CategoryService from "../../services/category.service";



export const createCategory = (user_id, categoryName) => async (dispatch) => {
  try {
    const res = await CategoryService.createCategory({ user_id, categoryName });
    dispatch({
      type: CREATE_CATEGORY,
      payload: res.data,
    });
    return Promise.resolve(res.data);
  } catch (err) {
    return Promise.reject(err);
  }
};

// export const allCategories = (categoryId, categoryName) => (dispatch) => {
//   return AuthService.allCategories(
//     categoryId,
//     categoryName,
//   ).then((response) => {
//       dispatch({
//         type: ALL_CATEGORIES
//       })
//       return Promise.resolve();
//       })
//     .catch((error) => {
//       console.error(error);
//     });
//   }

export const allCategories = () => async (dispatch) => {
  try {
    const res = await CategoryService.allCategories();
    dispatch({
      type: ALL_CATEGORIES,
      payload: res.data
    });
  } catch (err) {
    console.log(err);
  }
};

export const findCategory = (categoryName) => async (dispatch) => {
  try {
    const res = await CategoryService.findCategory(categoryName);
    dispatch({
      type: FIND_CATEGORY,
      payload: res.data,
    });
  } catch (err) {
    console.log(err);
  }
};

export const updateCategory = (id, data) => async (dispatch) => {
  try {
    const res = await CategoryService.updateCategory(id, data);
    dispatch({
      type: UPDATE_CATEGORT,
      payload: data,
    });
    return Promise.resolve(res.data);
  } catch (err) {
    return Promise.reject(err);
  }
};

export const deleteCategory = (id) => async (dispatch) => {
  try {
    await CategoryService.deleteCategory(id);
    dispatch({
      type: DELETE_CATEGORY,
      payload: { id },
    });
  } catch (err) {
    console.log(err);
  }
};





