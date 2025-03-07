/* 일반 배열과의 차이 */
/* 
    자바스크립트의 배열은 일반적인 배열의 동작을 흉내낸
    특수한 '객체'로 각각의 메모리 공간이 동일한 크기를 갖지 않아도 되고
    연속적으로 이어져 있지 않을 수도 있다.    
*/

/* 배열 = 인덱스를 나타내는 문자열을 프로퍼티 키로 가지며,
        length 프로퍼티를 갖는 특수한 객체 */
// 자바스크립트의 모든 값이 객체의 프로퍼티 값이 될 수 있으므로
// 자바스크립트의 모든 값이 배열의 요소가 될 수 있다.
const arr = [
    '판다',
    '20',
    null,
    true,
    undefined,
    NaN,
    Infinity,
    [],
    {},
    function(){},
    Symbol(),
]

console.log(arr)

/*
    <프로퍼티 플래그>
    객체 프로퍼티는 값(value)과 함께 플래그(flag)라는 특별한 속성 세 가지를 가진다.
    writable : true 면 값 수정 가능, 그렇지 않다면 읽기만 가능
    enumerable : true 면 반복문 사용해 나열 가능, 그렇지 않다면 불가능
    configurable : true 면 프로퍼티 삭제 및 플래그 수정 가능, 그렇지 않다면 불가능
*/
console.log(Object.getOwnPropertyDescriptors([1, 2, 3]))