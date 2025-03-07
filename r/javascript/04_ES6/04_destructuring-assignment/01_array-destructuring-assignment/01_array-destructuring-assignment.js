// 배열 구조 분해 할당
// 구조 분해 할당을 사용하면 배열이나 객체를 변수로 분해하여 연결할 수 있다.

let nameArr = ['Gldong', 'hong']

// let firstName = nameArr[0];
// let lastName = nameArr[1];
let [firstName, lastName] = nameArr;
console.log(firstName);
console.log(lastName);
// 반환 값이 배열인 split 메소드 활용
let [firstName2, lastName2] = "Siamdang Shin".split(' ')
console.log(firstName2);
console.log(lastName2);

let arr = ['first', 'middle', 'last']
// 쉼표 사용하여 배열 요소 버리기
let [first3, , last3] = arr;
console.log(first3);
console.log(last3);
