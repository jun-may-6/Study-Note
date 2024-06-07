/* for in 반복문 */
// 객체의 모든 키 순회

var teacher = {
    name : `판다`,
    work : function(subject){
        console.log(`${this.name} 선생님이 ${subject} 를 열심히 가르쳐요!`)
    }
};

for(var key in teacher){
    console.log(`key : ${key}`);
    console.log(`teacher[key] : ${teacher[key]}`)
}