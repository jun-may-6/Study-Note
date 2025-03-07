package com.ohgiraffers.section01.polymorphism;

public class Tiger extends Animal{

    @Override
    public void eat(){
        System.out.println("호랑이가 고기를 먹고 있습니다.");
    }
    @Override
    public void run(){
        System.out.println("호랑이가 어슬렁거립니다.");
    }
    @Override
    public void cry(){
        System.out.println("호랑이가 울부짖고 있습니다.");
    }
    public void bite(){
        System.out.println("호랑이가 물어 뜯습니다.");
    }
}
