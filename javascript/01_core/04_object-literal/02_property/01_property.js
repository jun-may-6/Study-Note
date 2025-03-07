/* 1. property */
/* 객체는 프로퍼티의 집합이며, 프로퍼티는 키와 값으로 구성된다. */

var idol = {
    name: 'BTS',
    count: 7,       // 쉼표 붙혀도 상관없음
}

console.log(idol)

var testObj = {
    normal: 'normal value',
    '@ s p a c e @' : 'space value',
    '' : '',    // 빈 문자열 키는 오류가 발생하지 않지만 권장하지 않음
    0 : 1,      // 숫자 키는 내부적으로 문자로 변환
    var : 'var',    // 예약어 키는 오류가 발생하지 않지만 권장하지 않음
    normal : 'new normal value' // 이미 존재하는 키를 중복 선언하면 나중에 선언한 프로퍼티로 덮어쓰임
}

var key = 'test';
// 프로퍼티 키 동적 생성
testObj[key] = 'test value';

console.log(testObj);   // 객체 정렬은 정수 나열 이후로 최근 순으로 정렬된다.