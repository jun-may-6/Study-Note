package com.ohgiraffers.sectiond03.interfaceimplements;

public class Application {
    public static void main(String[] args) {
        /*
        * 인터페이스
        * 자바의 클래스와 유사한 형태이지만
        * 추상메소드와 상수 필드만 가질 수 있는 클래스의 변형체를 말한다.
        *
        * 인터페이스의 목적
        * 1. 추상클래스와 비슷하게 필요한 기능을 공통화 해서 강제성을 부여할 목적으로 사용(표준화)
        * 2. 자바의 단일상속의 단점을 극복(다중 상속)
        * */

//        InterProduct interProduct = new InterProduct() {};        //인스턴스를 생성하지 못하고, 생성자 자체가 존재하지 않는다.
        /*레퍼런스 타입으로만 사용이 가능하다.*/
        InterProduct interProduct = new Product();

        /*인터페이스의 추상메소드 오버라이딩한 메소드로 동적바인딩에 의해 호출됨*/
        interProduct.nonStaticMethod();
        interProduct.abstMethod();

        /*오버라이딩을 하지 않으면 인터페이스의 default 메소드로 호출됨 (new Product 의 객체 interProduct 의 메소드를 호출하지만,
        * Product 에 오버라이딩이 되어있지 않더라도 interProduct 의 메소드가 실행된다)*/
        interProduct.defaultMethod();

        /*static 메소드는 인터페이스명.메소드명(); 으로 호출함*/
        InterProduct.staticMethod();

        /*상수 필드 접근도 인터페이스명.필드명으로 접근함*/
        System.out.println(InterProduct.MAX_NUM);
        System.out.println(InterProduct.MIN_NUM);

    }

}

