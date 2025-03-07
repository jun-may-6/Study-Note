/* 1. [[Prototype]] */

const user = {
    activate : true,
    login : function(){
        console.log(`로그인 되었습니다.`)
    }
}

const student = {
    passion : true
}

// __proto__ 는 [[Prototype]] 의 getter, setter이다.
// Object.getPrototypeOf, Object.setPrototypeOf 를 써서 prototype 을 get, set 하는 것이 좋다
student.__proto__ = user;

console.log(student.passion);
console.log(student.activate)
student.login();

// 프로토타입 체인
const class8Student = {
    classNo : 8,
    __proto__: student
}

// 프로토타입 체이닝은 순환 참조가 허용되지 않는다.
// user.__proto__ = class8Student;  // TypeError: Cyclic __proto__ value

console.log(class8Student.passion)      // student 에서 상속
console.log(class8Student.activate)     // user 에서 상속