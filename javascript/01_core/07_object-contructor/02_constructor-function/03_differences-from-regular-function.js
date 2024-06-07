/* 3. 일반 함수와의 차이점 */

// 첫 문자를 대문자로 기술하여 구별할 수 있도록 한다.
function Teacher(name, hobby){
    this.name = name;
    this.hobby = hobby;
    this.getInfo = function(){
        return `${this.name}의 취미는 ${this.hobby} 입니다.`
    }
}

// new 연산자와 함께 호출하면 생성자 함수로 동작한다.
// 만약, new 연산자와 함께 호출하지 않으면 일반 함수로 동작한다.
const teacher = Teacher(`판다`, `열정적으로 수업하기`);
console.log(teacher);   // 일반 함수로서  Teacher 은 리턴값이 없으므로 undefined 출력
// console.log(hobby)      // 일반 함수로서 호출된 Teacher 내의 this 는 전역 객체를 가리킨다.

/* new.target */
// (생성자 함수가 new 연산자 없이 호출되는 것을 방지하기 위해 ES6에서 지원)
// new 연산자와 함께 생성자 함수로서 호출 시, new.target 은 함수 자신을 가리킨다.
// new 연산자 없이 일반 함수로 호출 시, 함수 내부의 new.target 은 undefined이다.

function Dog(name, skill){
    if(!new.target){
        return new Dog(name, skill)
    }
    this.name = name;
    this.skill = skill;
}

const dog1 = Dog(`뽀삐`, `앉아`)
console.log(dog1)
const dog2 = new Dog(`먼지`, `기다려`)
console.log(dog2)

// 대부분 빌트인 생성자 함수(Object, String, Number, Boolean, 등)는 
// new 연산자와 함께 호출되었는지 확인 후 적절한 값을 리턴한다.
const obj = Object();
console.log(obj);       // new 연산자 없이도 동작함

// String, Number, Boolean 의 경우 new 연산자 없이 호출하면 객체 값이 아닌
// 문자열, 숫자, 논리값을 반환하여 데이터 타입 변환에 이용한다.

