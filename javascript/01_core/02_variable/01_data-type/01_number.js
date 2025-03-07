/* 01. 숫자 타입 */ 
// 정수, 실수, 음수 모두 숫자 타입이다.
var integer = 10;
var double = 5.5;
var negative = -10;
// 숫자타입은 모두 실수로 처리
console.log(10 === 10.0)

console.log(typeof integer)
console.log(typeof double)

// 실수끼리의 나누기이므로 소수점까지 처리됨
console.log(10/4);


console.log(10/0);          //Infinity 양의 무한
console.log(10/-0);         //-Infinity 음의 무한
console.log(1 * '문자열');  //NaN = Not a Number
