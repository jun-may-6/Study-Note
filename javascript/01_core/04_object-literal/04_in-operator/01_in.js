/* in 연산자 */
// 프로퍼티 존재 여부 확인

var actor = {
    name : `마동석`,
    age : 53,
    gender : `M`,
    company : undefined
};

console.log(actor.name === undefined);          // false
console.log(actor.age === undefined);           // false
console.log(actor.gender === undefined);        // false
console.log(actor.drama === undefined);         // true
console.log(actor.company === undefined);       // true

// in 연산자 사용
console.log("name" in actor)                //true
console.log("age" in actor)                 //true
console.log("drame" in actor)               //false
console.log("company" in actor)             //true
