import { RECENT_POST } from "../actions/types";

export default function postReducer(post = initialState, action) {
    const { type, payload } = action;
    switch (type) {
        case RECENT_POST:
            console.log('post_payload', payload)
            return [...post, payload];
    }
};