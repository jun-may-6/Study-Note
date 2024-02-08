package com.ohgiraffers.section01.object.run;

import com.ohgiraffers.section01.object.book.Book;

public class Application3 {
    public static void main(String[] args) {
        /*
        * hashCode() 메소드 오버라이딩
        * Object 클래스의 명세에 작성된 일반 규약에 따르면
        * equals() 메소드를 재정의 하는 경우 hashCode() 메소드도 재정의 하도록 되어있다.
        * 만약 hashCode()를 재정의 하지 않으면 같은 값을 가지는 동등 객체는
        * 같은 해시코드값을 가져야 한다는 규약에 위반되게 한다. (강제성은 아니지만 규약대로 작성하는것이 좋다.)
        * */

        Book book1 = new Book(1, "홍길동전", "허균", 50000);
        Book book2 = new Book(1, "홍길동전", "허균", 50000);
        /*둘은 값이같지만 해쉬코드가 다르다. 이때 hashCode() 메소드를 오버라이딩 하여 값에 따라
        * 해쉬코드가 반환되도록 재정의해주면 동일한 해쉬코드를 반환하게 된다.*/
        System.out.println("book1의 hashCode : " + book1.hashCode());
        System.out.println("book1의 hashCode : " + book2.hashCode());
    }
}
