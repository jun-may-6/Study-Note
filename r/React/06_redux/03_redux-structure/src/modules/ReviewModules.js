import { createActions, handleActions } from "redux-actions";

/* 모듈 = [초기값, 액션, 리듀서] */
const initialState = {};


/* 액션 */
const GET_REVIEWLIST = 'review/GET_REVIEWLIST';
export const {review: {getReviewlist}} = createActions({
    [GET_REVIEWLIST]: result=>({reviewList: result})
})

/* 리듀서 */
const reviewReducer = handleActions({
    [GET_REVIEWLIST]: (state, {payload})=> payload
}, initialState)

export default reviewReducer;