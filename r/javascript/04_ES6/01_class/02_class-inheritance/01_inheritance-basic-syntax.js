class Animal{
    constructor(name, weight){
        this.name = name
        this.weight = weight
    }
    eat(foodWeight){
        this.weight += foodWeight
        console.log(`${this.name}(은)는 ${foodWeight}kg 의식사를 하고 ${this.weight}kg이 되었습니다.`)
    }

    move(lostWeight){
        if(this.weight > lostWeight){
            this.weight -= lostWeight;
        }
        console.log(`${this.name}(은)는 움직임으로 인해 ${lostWeight}kg 감량되어 ${this.weight}kg 이 되었습니다.`)
    }
}
class Human extends Animal{
    develop(language){
        console.log(`${this.name}은 ${this.develop}로 개발을 합니다.`);
        
    }
}
let human = new Human("수강생", 70)

// Animal 에 정의 된 메소드 접근 가능
human.eat(2);
human.move(1);

human.develop("JavaScript")