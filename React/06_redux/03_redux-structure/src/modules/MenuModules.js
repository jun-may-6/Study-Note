import {createActions, handleActions} from 'redux-actions';
/* 모듈 = [초기값, 액션, 리듀서] */
const initialState = {};

/* 액션 */
const GET_MENULIST = 'menu/GET_MENULIST';   //액션 type
const GET_MENU = 'menu/GET_MENU';
export const {menu: {getMenulist, getMenu}} = createActions({
    [GET_MENULIST]: result=>({menuList: result}),
    [GET_MENU]: result=>({menu: result})
})

/* 리듀서 */
const menuReducer = handleActions({
    [GET_MENULIST]: (state, {payload}) => payload,
    [GET_MENU]: (state, {payload}) => payload
},initialState)


export default menuReducer;