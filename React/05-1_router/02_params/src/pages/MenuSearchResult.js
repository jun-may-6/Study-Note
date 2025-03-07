import { useSearchParams } from 'react-router-dom'
import { useEffect, useState } from 'react'
import { getSearchMenu } from '../api/MenuAPI'
import boxStyle from "./Menu.module.css"
import MenuItem from '../components/MenuItem'


export default function MenuSearchResult() {
    /* 쿼리 스트링 형태로 전달된 값은 useSearchParams로 꺼낼 수 있다. */
    const [searchParams] = useSearchParams();

    /* 쿼리 스트링의 키 값을 get 함수에 전달하여 파라미터 값을 가져온다. */
    const menuName = searchParams.get('menuName');

    const [menuList, setMenuList] = useState();
    useEffect(() => {
        setMenuList(getSearchMenu(menuName))
    }, [])
    return (
        <div>
            <h1>메뉴 검색 결과</h1>
            <div className={boxStyle.MenuBox}>
                {menuList?.map(menu => <MenuItem key={menu.menuCode} menu={menu} />)}
            </div>
        </div>
    )
}