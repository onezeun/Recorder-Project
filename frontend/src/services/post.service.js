import axios from "axios";

const API_URL = 'http://localhost:8080/board/posts/';

const getRecentPost = (postId, userId, categoryId, title, content, summary, hits, exposure, thumbnailImage) => {
    return axios
        .get(API_URL + 'v1', {
            postId,
            userId,
            categoryId,
            title,
            content,
            summary,
            hits,
            exposure,
            thumbnailImage
        })
        .catch((error) => {
            console.error(error);
        });
}


const PostService = {
    getRecentPost,
}

export default PostService;