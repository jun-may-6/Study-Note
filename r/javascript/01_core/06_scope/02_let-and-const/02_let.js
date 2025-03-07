/* 2. let */

// 1. 변수 중복 선언 금지
// let, const 키워드로 선언된 변수는 같은 스코프 내에서 중복 선언을 허용하지 않음
let msg = "안녕하세요~~"
// let msg = "안녕히 가세요~~"

// 2. 블럭 레벨 스코프
// let 키워드로 선언한 변수는 모든 코드 블록
// (함수, if, for, while, try/catch문 등)을 지역 스코프로 가진다.
let i = 0;
for(let i = 0; i < 10; i++){
    console.log(`for의 지역 변수 i : ${i}`)
}
console.log(i)

// 3. 변수 호이스팅
// let 키워드로 선언한 변수는 호이스팅이 되지 않는 것처러 ㅁ동작
// var 키워드는 선언과 초기화가 동시에 진행
// let 키워드는 선언 단계와 초기화가 분리
// 따라서 선언은 되었지만 초기화가 되지 않아 참조시 오류 발생

// console.log(x)  //오류 발생
let x;

let y = 1;
if(true){
    console.log(y)  // Cannot access 'y' before initialization
    let y = 2;  // if 문 안의 변수 y선언만 호이스팅 되어 초기화되지 않아 오류 발생
}