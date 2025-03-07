/* length */

// length 프로퍼티는 요소의 갯수를 나타내는 0이상이 정수를 값으로 갖는다.
const arr = [1, 2, 3, 4, 5]
console.log(arr.length)

arr.push(6)     // 인자로 전달한 요소 추가
console.log(arr.length)

console.log(`arr.pop : ${arr.pop()}`)     // 마지막 요소 리턴하고 제거
console.log(arr.length)

console.log(arr)

// length 프로퍼티보다 작은 숫자 값을 할당하면 배열의 길이가 줄어든다
arr.length = 3;
console.log(arr)

// length 프로퍼티보다 큰 숫자 값을 할당하면 length 프로퍼티 값은 변경되지만
// 배열의 길이가 늘어나지는 않는다.
arr.length = 7;
console.log(arr)
console.log(arr.length)
console.log(Object.getOwnPropertyDescriptors(arr))

// 자바스크립트는 배열의 요소가 연속적으로 위치하지 않고
// 일부가 비어있는 희소 배열을 문법적으로 허용한다.
const sparse = [ , 2 , , 4 , 5]
console.log(sparse)
console.log(sparse.length)