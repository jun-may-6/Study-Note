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

class Tiger extends Animal{
    attack(target){
        console.log(`${this.name}(은)는 ${target}을 공격합니다.`)
    }
    move(target){
        super.move(0.1);    // super 를 통해 부모 클래스의 메서드 참조
        this.attack(target);
    }
}

let tiger = new Tiger("백두산 호랭이", 90)
tiger.move('슬픈 눈망울의 사슴')