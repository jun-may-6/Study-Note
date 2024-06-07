/* 함수 레벨 스코프 */
/* 
    var 키워드로 선언된 변수는 오로지 함수의 코드 블록만을 지역 스코프로 인정하는
    함수 레벨 스코프 (function level scope)를 가진다.
    따라서 함수 외의 코드 블록(if, for, while, try/catch 등)은 지역 스코프로 인정하지 않는다.
*/

var i = 0;  // 함수 밖에서 var 키워드로 선언된 i 는 전역변수

for(var i = 0 ; i < 10 ; i++){  // 이미 선언된 i가 있어 중복 선언됨
    console.log(`${i} 번째 실행중`)
}

console.log(i)      // 의도와 달리 0이 아닌 10이 출력

