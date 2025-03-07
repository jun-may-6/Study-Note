// 스프레드 문법
// 하나로 뭉쳐져 있는 여러 값들의 집합을 전개해서 개별적인값들의 목록을 만든다. (배열, 객체 등)
let arr = [2, 5, 15]
console.log(`가장 큰 값 : ${Math.max(arr)}`);   // NaN
console.log(`가장 큰 값 : ${Math.max(2, 5, 15)}`);   // 15
// ...을 사용하여 인수 목록으로 확장
console.log(`가장 큰 값 : ${Math.max(...arr)}`);   // 15

let arr1 = [5, 8, 22];
let arr2 = [34, 55, 97];
/* 배열 여러개 전달 가능 */
console.log(`가장 작은 값 : ${Math.min(...arr1, ...arr2)}`);    // 5
/* 일반 값과 혼합 사용 가능 */
console.log(`가장 작은 값 : ${Math.min(1, ...arr1, 3, ...arr2, 7)}`);    // 5
/* 간단한 배열 병합 */
let merged = [0, ...arr1, 2, ...arr2];
console.log(merged);
/* 문자열을 배열로 나열 */
let str = "JavaScript"
console.log([...str]); 
