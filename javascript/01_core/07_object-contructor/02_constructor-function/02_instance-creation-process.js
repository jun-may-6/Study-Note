/* 2. 인스턴스 생성 과정 */

function Student(name, hobby){
    // 1. 암묵적으로 인스턴스가 생성되고  this 에 바인딩되는 과정이 런타임 잊너에 실행된다.
    console.log(this);

    // 2. this 에 바인딩 되어 있는 인스턴스를 초기화 한다.
    this.name = name;
    this.hobby = hobby;
    this.getInfo = function(){
        return `${this.name}의 취미는 ${this.hobby}입니다.`
    }
        // 3. 완성된 인스턴스가 바인딩된 this 가 암묵적으로 반환된다.
        // return{}; // 만약 명시적으로 객체를 반환하면 암묵적인 this 반환 무시
        // return 1; // 명시적으로 원시값은 반환하면 원시값은 무시하고 this 반환
        // 생성자 내부에서 return 은 생략하는 것이 기본이다.

}
const student = new Student(`김우준`, 'MyBatis 과제하기')
console.log(student)