/* 엄격 모드 활용 (변화 상황) */

// 1. 일반 함수의 this
// 생성자 함수가 아닌 일반 함수 내부에서는 this 를 사용할 필요가 없으므로
// strict mode 에서는 일반 함수로서 호출하면 this 에 undefined 가 바인딩된다.
(function(){
    'use strict'
    function test(){
        console.log(this)       // strict 적용 후 undefined 바인딩
    }
    test();

    new test();
})()

// 2. arguments 객체
// strict mode 에서는 매개변수에 전달된 인수를 재할당하여 변경해도
// arguments 객체에는 반영되지 않는다.
(function(x){
    // 'use strict'
    x = 2;

    console.log(arguments);
})(1);