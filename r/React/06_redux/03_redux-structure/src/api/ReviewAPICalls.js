import { getReviewlist } from "../modules/ReviewModules"
import { request } from "./api"

export function callReviewListAPI(){
    return async (dispatch, getState) => {
        const result = await request('GET', '/review')
        dispatch(getReviewlist(result))
    }
}