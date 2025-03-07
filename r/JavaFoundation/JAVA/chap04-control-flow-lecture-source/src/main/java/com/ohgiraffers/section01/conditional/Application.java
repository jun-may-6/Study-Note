package com.ohgiraffers.section01.conditional;

public class Application {
    public static void main(String[] args) {

        A_if a = new A_if();
//        a.simpleIfStatment();

//        a.nestedIfStatment();

        B_ifElse b = new B_ifElse();
//        b.simpleIfElseStatement();
//        b.nestedIfElseStatement();

        C_ifElseif c = new C_ifElseif();
//        c.simpleIfElseIfStatement();
//        c.nestedIfElseIfStatement();

        D_switch d = new D_switch();
//        d.simpleSwitchStatement();
        d.switchVendingMachine();
    }
}
