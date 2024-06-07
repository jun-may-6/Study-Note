/* 3. 에러 상황 */

// 1. 암묵적 전역
(function(){
    // 'use strict'     // ReferenceError: x is not defined
    x = 1;
    console.log(x);
})();

// 2. 변수, 함수, 매개변수의 삭제
(function(){
    // 'use strict'
    var x = 1;
    // 엄격 모드에서는 식별자에 대해 'delete' 를 호출할 수 없다.
    delete x;
})();

// 3. 매개변수 이름의 중복
(function(){
    'use strict'    // 사용함으로서 파라미터 오류 방지
    function test (x, x){       // 마지막에 대입된 파라미터만 적용
        // SyntaxError: Duplicate parameter name not allowed in this context
        return x + x;
    }

    console.log(test(1,2))
})();