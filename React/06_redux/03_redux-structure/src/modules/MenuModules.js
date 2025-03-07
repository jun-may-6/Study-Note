import {createActions, handleActions} from 'redux-actions';
/* 모듈 = [초기값, 액션, 리듀서] */
const initialState = {};

/* 액션 */
const GET_MENULIST = 'menu/GET_MENULIST';   //액션 type
const GET_MENU = 'menu/GET_MENU';
/* export 되어있으므로 바로 getMenulist 메소드 사용 가능 */
export const {menu: {getMenulist, getMenu}} = createActions({
    /* api의 결과값을 menuList 에 바인딩하는 메소드 */
    /* 결과적으로는 
    {
        type: 'menu/GET_MENULIST',
        payload: {
            menuList: apiData
        }
    }
    형태 */
    [GET_MENULIST]: result=>({menuList: result}),
    [GET_MENU]: result=>({menu: result})
})

/* 리듀서 */
const menuReducer = handleActions({
    /* 함수가 아닌 액션이 왔을 때 실행됨 */
    /* 스프레드 문법을 사용하지 않으므로 새로 받아온 값만 state에 저장됨 */
    [GET_MENULIST]: (state, {payload}) => payload,
    [GET_MENU]: (state, {payload}) => payload
},initialState)


export default menuReducer;