package com.ohgiraffers.section02.abstractclass;

public class SmartPhone extends Product{

    /*extends 키워드로 클래스를 상속받을 때 두 개 이상의 클래스는 상속하지 못한다.
    * 추상클래스가 가지는 추상 메소드를 반드시 오버라이딩 해야 한다. (강제성 부여)*/
    @Override
    public void abstMethod() {
        System.out.println("product 클래스의 abstMethod 를 오버라이딩 한 메소드 호출");
    }
    public void printSmartPhone(){
        System.out.println("SmartPhone 클래스의 printSmartPhone 메소드 호출");
    }
}
