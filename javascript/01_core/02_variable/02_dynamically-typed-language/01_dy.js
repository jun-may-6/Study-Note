/* 동적타입언어 */
var test;
console.log(typeof test);   //undefined

test = 1;
console.log(typeof test);   //number

test = 'javascript';
console.log(typeof test);   //string

test = true;
console.log(typeof test);   //boolean

test = null;
console.log(typeof test);   //버그로 인한 object (실제로는 null)

test = Symbol();
console.log(typeof test);   //symbol

test = {};
console.log(typeof test);   //object

test = [];
console.log(typeof test);   //object

test = function(){};
console.log(typeof test);   //function