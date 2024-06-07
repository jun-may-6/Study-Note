class Student{
    constructor(name, height){
        this.name = name
        this.height = height
    }
    static compare(studentA, studentB){ // 정적 메소드 명시
        return studentA.height - studentB.height
    }
}

let students = [
    new Student('유관순', 165.5),
    new Student('홍길동', 180.5),
    new Student('선덕여왕', 159.5)
]

students.sort(Student.compare);
console.log(students)

Student.staticMethod = function(){
    console.log('staticMethod 는 메소드를 프로퍼티 형태로 할당하는 것과 동일하다.')
}
Student.staticMethod();

class User{
    constructor(id, registDate){
        this.id = id;
        this.registDate = registDate;
    }
    static registUser(id){
        return new this(id, new Date());
    }
}

let user01 = User.registUser('user01')
console.log(user01);
