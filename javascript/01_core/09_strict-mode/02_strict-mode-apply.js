/* 엄격 모드 적용 */
/* 
    전역의 선두 또는 함수 몸체의 선두에 'use strict'를 추가한다.
*/

// 'use strict';

function test(){
    'use strict'
    x = 10;
    // 코드의 선두에 위치시키지 않으면 strict mode 가 제대로 동작하지 않는다.
    // 'use strict'
}

test(); // x is not defined

console.log(x)

(function(){
    'use strict';
})();