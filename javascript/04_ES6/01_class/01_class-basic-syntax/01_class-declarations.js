

class Student {
    constructor(name){
        this.name = name;
        this.group = 1;
    }
    introduce(){
        console.log(`안녕하세요 저는 ${this.group}반 ${this.name}입니다.`)
    }
}

let student = new Student("판다");
student.introduce;

console.log(typeof Student);    // function - 클래스는 함수의 한 종류이다.
console.log(Student === Student.prototype.constructor); // true
console.log(Student.prototype.introduce);   // 클래스 내부에 정의한 메소드는 클래스.prototype 에 저장된다.
console.log(Object.getOwnPropertyNames(Student.prototype)); // ['constructor', '']


function Teacher(name){
    this.group = 1;
    this.name = name;
}

Teacher.prototype.introduct = function(){
    console.log(`안녕하세요 저는 ${this.group}반 선생님 ${this.name}입니다.`)
}

let teacher = new Teacher('홍길동')
teacher.introduct();
/* 클래스 생성자를 new와 함께 호출하지 않으면 에러 발생  */
// Student(); TypeError
Teacher();

/*
 * 클래스에 정의 된 메서드는 열거 불가능하다. 
 * 따라서 for.in 으로 객체 순회 시 메소드 순회 대상에서 제외된다.
 */

for(method in student){
    console.log(`반복문 student: ${method}`)
}
for(method in teacher){
    console.log(`반복문 teacher: ${method}`)
}