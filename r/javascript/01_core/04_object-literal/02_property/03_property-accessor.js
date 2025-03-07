/* 03. property 접근 */
var teacher = {
    name : `판다`,
    work : function(subject){
        console.log(`${this.name} 선생님이 ${subject} 를 열심히 가르쳐요!`)
    }
};

// 마침표 표기법 (dot notation)
console.log(teacher.name);
teacher.work(`javaScript`);

// 대괄호 표기법 (square bracket notation)
console.log(teacher[`name`]);
teacher[`work`] (`자바스크립트`);

var testObj ={
    'dash-key' : 'dash-value',
    0 : 1
};


// 프로퍼티 키가 식별자 네이밍 규칙을 준수하지 않는 경우
// 반드시 대괄호 표기법을 사용한다.
// console.log(testObj.dash-key);
// console.log(testObj.'dash-key');
// console.log(testObj[dash-key]);
console.log(testObj[`dash-key`]);

// console.log(testObj.0);
// console.log(testObj.`0`);
console.log(testObj[`0`]);
console.log(testObj[0]);    // 숫자는 따옴표 생략 가능