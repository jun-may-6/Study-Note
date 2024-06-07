import { useState, useEffect } from 'react';
import {useNavigate} from 'react-router-dom'
import { getMenuList } from '../api/MenuAPI'
import boxStyle from "./Menu.module.css"    //클래스명의 충돌 방지
import MenuItem from "../components/MenuItem";
function Menu() {

    const [menuList, setMenuList] = useState();
    const [searchValue, setSearchValue] = useState('');
    const navigate = useNavigate();
    const onClickHandler = () => {
        navigate(`/menu/search?menuName=${searchValue}`)
    }

    useEffect(() => {
        setMenuList(getMenuList());
    }, []);

    return (
        <div>
            <h1>메뉴 목록</h1>
            <input
                type='search'
                name="menuName"
                value={searchValue}
                onChange={(e) => {setSearchValue(e.target.value)}}
            />
            <button onClick={onClickHandler}>검색</button>
            <div className={boxStyle.MenuBox}>
                {menuList?.map(menu => <MenuItem key={menu.menuCode} menu={menu} />)}
            </div>
        </div>
    );
}

export default Menu;