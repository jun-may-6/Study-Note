/* 생성자 함수 프로토타입 */

const user = {
    activate: true,
    login: function () {
        console.log('로그인 되었습니다.')
    }
}

function Student(name){
    this.name = name;
}

// 일반적인 프로퍼티 설정
Student.prototype = user;

// F.prototype 은 new F 를 호출할 때만 사용된다.
// new F 를 호출할 때 만들어지는 새로운 객체의 [[Prototype]]을 할당한다.
// student.__proto__ == user
let student = new Student(`판다`);

console.log(student.activate);