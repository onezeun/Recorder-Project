import { USER_GET } from "./types";
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