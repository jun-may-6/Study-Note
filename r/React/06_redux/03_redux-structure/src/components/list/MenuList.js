import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { callGetMenuListAPI } from "../../api/MenuAPICalls";
import MenuItem from "../item/MenuItem";


function MenuList() {
    const dispatch = useDispatch();
    const { menuList } = useSelector(state => state.menuReducer)
    useEffect(() => {
        /* 메뉴 목록을 조회하는 API를 호출하는 로직을 담은 함수를 전달한다. */
        dispatch(callGetMenuListAPI());
    }, [])
    console.log('test', menuList)
    return (
        <div className="menuBox">
            {menuList?.map(menu => { return <MenuItem key={menu.id} menu={menu} /> })}
        </div>
    )
}

export default MenuList;