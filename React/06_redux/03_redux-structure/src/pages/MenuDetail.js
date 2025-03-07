import { useParams } from "react-router-dom";
import Menu from '../components/item/Menu'

function MenuDetail(){

    const {id} = useParams();
    return (
        <div>
            <h1>메뉴 상세</h1>
            <Menu key={id} id={id}/>
        </div>
    )
}

export default MenuDetail;