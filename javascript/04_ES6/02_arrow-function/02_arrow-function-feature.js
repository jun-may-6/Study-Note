let teather = {
    store: "건대점",
    titles: ["어벤져스", "겨울왕국", "스파이더맨", "라이온킹", "알라딘"],
    // 1. 화살표 함수는 this 를 가지지 않는다.
    showMovieList(){
        this.titles.forEach(
            title=>console.log(`${this.store} : ${title}`)  // 자신의 this 가 없으므로 store 출력
        )
        this.titles.forEach(function(title){
            console.log(`${this.store} : ${title}`);    // 화살표가 아닌 일반 함수에서 this 는 Global 이라는 전역 객체를 가르킴
        })
    }
}
teather.showMovieList()

// this가 없으므로 생성자 함수로 사용할 수 없다.
const arrowFunc = ()=>{}
// new arrowFunc() // arrowFunc is not a constructor

// 화살표 함수는 인스턴스를 생성할 수 없으므로 prototype 프로퍼티가 없다.
console.log(arrowFunc.hasOwnProperty('prototype')); //false


// 화살표 함수는 super를 가지지 않는다.
class Animal{
    constructor(name, weight){
        this.name = name
        this.weight = weight
    }

    move(lostWeight){
        if(this.weight > lostWeight){
            this.weight -= lostWeight;
        }
        console.log(`${this.name}(은)는 움직임으로 인해 ${lostWeight}kg 감량되어 ${this.weight}kg 이 되었습니다.`)
    }
}

class Tiger extends Animal{
    move(listWeight){
        setTimeout(()=>super.move(listWeight), 3000)        //setTimeout(함수, 시간)
        // setTimeout(function(){
        //     super.move(listWeight)}, 2000           // 자신의 super가 있으므로 가져오지 못함
        // )
        console.log('먹이를 찾아 산기슭을 어슬렁');
        
    }
}

let tiger = new Tiger("백두산 호랭이", 90)
tiger.move(1);

// 화살표 함수는 arguments 를 지원하지 않는다.
(function(){
    const arrowFunc = ()=>console.log(arguments);
    arrowFunc(3,4)  
}(1,2)) // [Arguments] { '0': 1, '1': 2 }