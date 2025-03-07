import axios from "axios";

const DOMAIN = 'http://localhost:4000'

export const request = async (method, url, data) => {
    return await axios({
        method,
        url: `${DOMAIN}${url}`,
        data
    })
        .then(res=>res.data)                // axios 는 json 생략
        .catch(error=>console.log(error));  // 예외처리
}

/** axios 요청
 * axios({
    * method: 'GET',
    * url: '주소',
    * data: {}
 * })
 */