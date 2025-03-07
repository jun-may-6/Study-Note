/* 일급 객체 */

/*
    함수를 객체와같은 형태로 사용 가능
    1. 무명의 리터럴로 생성 가능(런타임시 생성 가능)    
    2. 변수나 자료구조(객체, 배열 등) 에 저장 가능
    3. 함수의 매개변수로 전달 가능
    4. 함수의 반환 값으로 사용 가능
*/

// 1 & 2
// 변수에 저장
var hello = function(){
    return'안녕하세요'
}
// 객체에 저장
var obj = {hello};

// 3
function repeat(func, count){
    for(var i = 0; i < count ; i++){
        console.log(func())
    }
    // 4
    return function(){
        console.log(`${count}번 반복 완료`)
    }
}
var returnFunc = repeat(obj.hello, 50)
returnFunc();