import { Menu } from "./model/restaurant"
/* 상속을 통하여 필드 생략 */

/* 1. 인터페이스 활용 */
// interface OwnProps extends Menu {
//     showBestMenuName(name:string):string
// }

/* 2. 타입 활용 */
type OwnProps = Omit<Menu, 'price'> & {
    showBestMenuName(name:string):string
}

export const BestMenu:React.FC<OwnProps>= ({name, category,  showBestMenuName}) => {
    return (
        <div>{name}</div>
    )
}