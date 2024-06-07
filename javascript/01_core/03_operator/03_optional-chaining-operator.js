/* 3. optional chaining operator */

/* 
    ES11(ECAMAScript 2020) 에서 도입된 연산자로
    좌향의 피연산자가 null 또는 undifined 인 경우 undifined 를 반환
    그렇지 않을 경우 우항의 프로터피 참조 이어감
 */

var obj = null;

// let val = obj.value; //TypeError: Cannot read properties of null

var val = obj?.value;
console.log(val);   //undefined

var str = "";

// len 이 Falsy 값이므로 이후 연산이 되지 않음.
var len = str && str.length;
console.log(len)

// optional chaining 사용
len = str?.length;
console.log(len)