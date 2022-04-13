import { USER_GET, USER_UPDATE } from "./types";
import UserService from "../../services/user.service";

export const getUser = (user_id) => async (dispatch) => {
    try {
        const res = await UserService.getUser(user_id);
        dispatch({
            type: USER_GET,
            payload: res.data
        })
    } catch (error) {
        console.error(error.message);
    }
}

export const updateUser = (user_id, email, nickname, domain, introduce) => async (dispatch) => {
    try {
        const res = await UserService.updateUser(user_id, email, nickname, domain, introduce);
        dispatch({
            type: USER_UPDATE,
            payload: res.data,
        })
        return Promise.resolve(res.data);
    } catch (error) {
        return Promise.reject(error);
    }
};