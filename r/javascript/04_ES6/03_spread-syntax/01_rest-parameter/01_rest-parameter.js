function merge(msg1, msg2){
    return msg1 + msg2
}
console.log(merge('안녕하세요'));
console.log(merge('안녕하세요', '반갑습니다'));
console.log(merge('안녕하세요', '반갑습니다', '제 이름은 판다입니다. '));

function mergeAll(...args){
    let message = ''
    for(let arg of args)message += arg
    return message
}

console.log(mergeAll('안녕하세요'));
console.log(mergeAll('안녕하세요', '반갑습니다'));
console.log(mergeAll('안녕하세요', '반갑습니다', '제 이름은 판다입니다. '));
/**  나머지 매개변수는 항상 마지막에 있어야 한다.
 * function func(arg1, ...args, arg2){} -> (X)
 * function func(arg1, arg2, ...args){} -> (O)
 */