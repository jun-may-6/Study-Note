import { getMenulist, getMenu} from "../modules/MenuModules"
import { request } from "./api"
export function callGetMenuListAPI(){
    return async (dispatch, getState) => {
        const result = await request('GET', '/menu')
        /* API 호출을 통해 반환 받은 데이터를 Store에 저장하기 위해 다시 dispatch(action객체) 호출 */
        dispatch(getMenulist(result));
    }
}

export function callGetMenuAPI(id){
    return async (dispatch, getState) => {
        const result = await request('GET', `/menu/${id}`)
        dispatch(getMenu(result))
    }
}