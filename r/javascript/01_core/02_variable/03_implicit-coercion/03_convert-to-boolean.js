/* impicit-coercion(암묵적 타입 변환) */

/* 3. boolean 타입으로 변환 */

// 자바스크립트 엔진은 boolean 타입이 아닌 값을
// Truthy 값(참으로 평가되는 값) 또는 Falsy 값(거짓으로 평가되는 값) 으로 구분
// Truthy -> true, Falsy -> false 로 암묵적 타입 변환

if(true) console.log("if(true");                    // O
if(false) console.log("if(false")                   // X
if(undefined) console.log("if(undefined)");         // X
if(null) console.log("if(null)");                   // X
if(0) console.log("if(0)");                         // X
if(NaN) console.log("if(NaN)");                     // X
if('') console.log("if('')")                        // X
if('javaScript') console.log("if('javaScript')");   // O

// false, undefined, null, 0, NaN, '' 은 Falsy
// 그 외의 값은 Truthy
