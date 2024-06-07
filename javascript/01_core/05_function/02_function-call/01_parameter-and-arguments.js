/* 1. 매개변수와 인소 (parameter and arguments) */

function hello(name){
    console.log(name)
    // 모든 인수는 암묵적으로  arguments 객체의 프로퍼티로 보관된다.
    console.log(arguments)

    return`${name}님 안녕하세요~!`
}

// console.log(name)    // 매개변수는 함수 몸체 안에서만 참조 가능

var result = hello(`판다`);
console.log(result);

// 매개변수보다 인수가 더 많은 경우, 초과된 인수는 무시된다.=
result = hello(`판다`, `다람쥐`, `원숭이`)
console.log(result)

result = hello()        //undefined 출력
console.log(result)

function hi (name = `홍길동`){  //undefined 일 경우 기본값 사용 (ES6부터)
    if(arguments.length !== 1 || typeof name !== `string` || name.length ===0){
        return `${name} 안녕~!`
    } 
}
result = hi();
console.log(result);

// TypeError 발생
// result = hi(``);
// result = hi(`다람쥐`, `언숭이`, `판다`);
// result = hi(1);