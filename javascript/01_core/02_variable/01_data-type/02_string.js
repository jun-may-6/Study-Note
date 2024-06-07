/* 02. 문자열 타입 */
var string;
string = 'JavaScript';      // 작은 따옴표''
string = "JavaScript";      // 큰 따옴표 ""
string = `JavaScript`;      // 백틱 ``

string = '작은 따옴표로 감싼 문자열 내의 "큰 따옴표" 는 문자열로 인식'
string = "큰 따옴표로 감싼 문자열 내의 '작은 따옴표' 는 문자열로 인식"

console.log(string);

/* 템플릿 리터럴 */
/*
    ES6 부터 도입된 백틱을 사용한 표현식으로
    멀티라인 문자열, 표현식 삽입 등
    편리한 문자열 처리 기능을 제공하는 문자열 표기법이다.
*/

// 일반 문자열 내에서는 줄바꿈이 허용되지 않는다.

// var str = '안녕하세요, 
// 판다입니다.';

// 이스케이프 시퀀스
var str = '안녕하세요, \n판다입니다. :)'
console.log(str);

// 백틱 사용
var multiline = `안녕하세요,
판다입니다 :)`
console.log(multiline);


var lastName = '다';
var firstName = '람쥐';
console.log('안녕하시오, ' + lastName + '가 ' + firstName + '이올시다.');
console.log(`안녕하시오, ${lastName} 가 ${firstName} 이올시다.`);
console.log('안녕하시오, ${lastName} 가 ${firstName} 이올시다.');