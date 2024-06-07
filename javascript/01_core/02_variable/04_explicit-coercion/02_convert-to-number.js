/* explicit coercion(명시적 타입 변환) */

/* 2. 숫자 타입으로 변환 */

// 1. Number 생성자 함수를 new 연산자 없이 호출
console.log(Number('10'))
console.log(Number('10.01'))
console.log(Number(true))       //1
console.log(Number(false))      //0

// 2. parseInt, parseFloat 함수 이용 (문자열 -> 숫자만 가능)
console.log(parseInt('10'))
console.log(parseFloat('10'))
console.log(parseInt('3.12'))
console.log(parseFloat('3.12'))

// 3. + 단항 산술 연산자 이용 - 암묵적 변환

// 4. * 산술 연산자 이용
console.log('10' *1)
console.log(true *1)