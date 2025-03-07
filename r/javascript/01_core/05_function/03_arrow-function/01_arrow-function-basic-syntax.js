/* 화살표 함수 (arrow-function) */

/* 
    ES6에서 도입된 화살표 함수는 function 키워드 대신 화살표를 사용해 좀 더
    간략하게 함수를 선언할 수 있다.
    화살표 함수는 항상 익명 함수로 정의하며, 본문이 한 줄인 함수를 작성할 때 유용하다. 
*/

var message;

// 기본 function
message = function(){
    return "Hello JavaSecipt World"
}
console.log(message())

// function 키워드 생략 가능
message = () => {
    return "Hello JavaSecipt World"
}
console.log(message())

// 명령문이 하나만 있는 경우 중괄호 생략 가능
// 이 때, 함수 몸체 내부의 실행문이 값으로 평가될 수 있는 표현식이라면
// 암묵적으로 return 되므로 생략 가능
message = () => "Hello javaScript World";
console.log(message())

message = (val1, val2) => "Arrow" + val1 + val2;
console.log(message(`Function`, `nice!`))

// 파라미터가 하나인 경우, 소괄호 생략 가능
// 단 파라미터가 없거나 여러개일 경우 생략 불가
message = val1 => "Arrow" + val1;
console.log(message("Function good!!!"))