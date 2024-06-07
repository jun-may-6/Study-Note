// 객체 프로퍼티에 사용
let user = {};
[user.firstName, user.lastName]= "Gwansoon Tu".split(' ')

console.log(user);

// 변수 교환 용도
let student = '학생';
let teacher = '선생님';
// 공간 = 배열 형태
[student, teacher] = [teacher, student];

console.log(`학생: ${student}, 선생님 ${teacher}`); //학생: 선생님, 선생님 학생

// rest parameter ...로 나저미 요소 한번에 가져오기
let [sign1, sign2, ...rest] = ["양자리", "황소자리", "염소자리", "게자리", "물병자리"];
console.log(sign1); //양자리
console.log(sign2); //황소자리
console.log(rest);  //[ '염소자리', '게자리', '물병자리' ]

// 기본값 설정하여 사용
let [firstName3 = "아무개", lastName3 = "홍"] = ["길동"];
console.log(firstName3);    //길동
console.log(lastName3);     //홍
