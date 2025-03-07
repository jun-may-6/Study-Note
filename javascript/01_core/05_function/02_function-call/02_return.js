/* 2. 반환문(return) */
function hello(name) {
    console.log(name);

    return`${name}님 안녕하세요 :)`
    // 반환문 이후 실행구문 무시
    console.log(`return 이후`)
}

console.log(hello('판다'));

function func() {
    console.log(`함수 호출`)

    return;     // return 값 없으므로 undefined 리턴
                // js 에서는 반환 값을 명시하지 않거나 생략 가능
}

console.log(func());