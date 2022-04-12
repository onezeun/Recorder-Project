import { USER_GET } from "../actions/types";

const user = JSON.parse(localStorage.getItem('user'));

const initialState = user ? { isLoggedIn: true, user} : { isLoggedIn: false, user: null};

export default function getUser(user = initialState, action) {
    const { type, payload } = action;
    switch (type) {
        case USER_GET:
            return payload;
    }
}