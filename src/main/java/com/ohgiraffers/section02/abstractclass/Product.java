package com.ohgiraffers.section02.abstractclass;

public abstract class Product {
    private int nonStaticField;         //필드를 가질 수 있다
    private static int staticField;

    public Product(){}          //생성자를 가질 수 있다.
    public void NonStaticField(){                   //메소드를 가질 수 있다.
        System.out.println("Product 클래스의 nonStaticMethod 호출");
    }
    public void staticField(){
        System.out.println("Product 클래스의 staticMethod 호출");
    }
    public abstract void abstMethod();      //추상 메소드
}
