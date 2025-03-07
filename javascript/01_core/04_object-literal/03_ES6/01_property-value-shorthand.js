/* 1. 프로퍼티 값 단축 구문 */

var productName = "iPhone15 pro"
var price = 1800000;

var product = {
    productName : productName,
    price : price,
}

console.log(product)


/* ES6 부터 있는 기능 */
// 프로퍼티 값으로 변수를 사용하는 경우
// 변수 이름과 프로퍼티 키가 동일한 이름일 때 프로퍼티 키를 생략할 수 있다.
var product2 = {
    productName,        // 키와 변수의 이름이 같을 경우 생략 가능
    price
}