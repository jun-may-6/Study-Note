/* 01. 엄격 모드 (strict mode) */

function test(){
    x = 10; // 암묵적으로 전역 변수가 된다. (키워드가 없음 var, let 등)
}

test();

console.log(x);         // 10