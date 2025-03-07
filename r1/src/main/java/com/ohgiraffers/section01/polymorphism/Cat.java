package com.ohgiraffers.section01.polymorphism;

public class Cat extends Animal{

    @Override
    public void eat(){
        System.out.println("고양이가 생선을 먹습니다.");
    }
    @Override
    public void run(){
        System.out.println("고양이가 달리고 있습니다.");
    }
    @Override
    public void cry(){
        System.out.println("고양이가 울고있습니다.");
    }
    public void jump(){
        System.out.println("고양이가 점프합니다.");
    }
}
