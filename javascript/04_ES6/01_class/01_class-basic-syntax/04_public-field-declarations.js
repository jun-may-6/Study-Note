class Book {
    /** 클래스를 정의할 때 '프로퍼티 이름 = 값' 을 사용하여 필드 생성 가능
     * Chrome 72 이상 OR Node.js 버전 12 이상 에서만 실행 가능하다.
     */
    name = "모던 javaScript"
    // this.price = 35000; //문법 오류: this. 은 constructor 내부 또는 메소드 내부에서만 작성

    introduce() {
        console.log(`${this.name}가 그렇게 재밌죠~`)
    }
}

let book = new Book()
console.log(Book.prototype.name)    //undefined
console.log(Book.prototype.introduce)    //undefined
console.log(book.name)    //undefined
book.introduce()