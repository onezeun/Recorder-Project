import { USER_GET, USER_UPDATE } from "../actions/types";

const initialState = {};

export default function getUser(user = initialState, action) {
    const { type, payload } = action;
    switch (type) {
        case USER_GET:
            return payload;

        case USER_UPDATE:
            return [...user, payload];
            
        default:
        return user;
    }
}