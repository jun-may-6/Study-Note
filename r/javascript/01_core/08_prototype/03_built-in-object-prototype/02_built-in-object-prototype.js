// 2. 내장 객체 프로토타입

const num = new Number(20);

// num 은 Number.prototype 을 상속받음
console.log(num.__proto__ === Number.prototype);

// num 은 Object.prototype 을 상속받음
console.log(num.__proto__.__proto__ === Object.prototype);

// 프로토타입 체인 최상단에는 null이 있음
console.log(num.__proto__.__proto__.__proto__)  //null