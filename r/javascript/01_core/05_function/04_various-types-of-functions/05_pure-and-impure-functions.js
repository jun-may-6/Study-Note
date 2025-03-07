/* 5. 순수 함수 & 비순수 함수 */
/*
    순수 함수 : 외부 상태에 의존하지도 않고 외부 상태를 변경하지도 않는 함수
    비순수 함수 : 외부 상태에 의존하거나 외부 상태를 변경하는 함수    
*/

var cnt = 0;
function increase(n){
    return ++n;
}
increase(cnt);
console.log("순수 함수 실행후", cnt)
cnt = increase(cnt);
console.log("순수함수 실행을 통한 재할당 후", cnt)

// 비순수 함수
function decrease(){
    return --cnt;   // 외부 상태에 이존하며 외부 상태 변경
}

decrease();
console.log("비순수 함수 실행 후", cnt)

cnt = decrease();
console.log("비순수 함수 실행을 통한 재할당 후", cnt)
