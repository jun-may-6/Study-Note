/* 프로토타입 접근 시 사용하는 모던 메소드 */

const user = {
    activate : true
}

// Object.create(proto) : [[Prototype]] 이 proto 를 참조하는 빈 객체 생성
const student = Object.create(user);
console.log(student.activate);

// Object.getPrototypeOf(obj) : obj의 [[Prototype]]을 반환
console.log(Object.getPrototypeOf(student) === user)

// Object.setPrototypeOf(obj, proto) : obj의 [[getPrototypeOf]] 을 proto 로 설정
Object.setPrototypeOf(student, {}) // student 의 프로토타입을 {} 로 변경
console.log(Object.getPrototypeOf(student) === user);