/* 전체 메뉴 목록 조회용 API */
import menus from '../data/menu-detail.json'
export function getMenuList(){
    return menus;
}
/* 메뉴 코드로 메뉴 조회 API */
export function getMenuDetail(menuCode){
    return menus.find(menu=>menu.menuCode == menuCode);
}
/* 메뉴 이름 검색 API */
export function getSearchMenu(menuName){
    /* match -> 포함 */
    return menus.filter(menu=>menu.menuName.match(menuName))
}