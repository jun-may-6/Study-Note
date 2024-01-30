package com.ohgiraffers.section03.math;

public class Application2 {
    public static void main(String[] args) {
        /*난수의 활용*/
        int random1 = (int)(Math.random() * 10); //0~9까지의 난수 발생
        System.out.println("0~9 난수 : " + random1);

        int random2 = (int)(Math.random() * 10) + 1; //1~10까지의 난수 발생
        System.out.println("1~10 난수 : " + random2);

        int random3 = (int)(Math.random() * 6 + 10);
        System.out.println("10~15 난수 : " + random3);
    }
}
