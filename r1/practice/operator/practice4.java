package com.ohgiraffers.practice.operator;

public class practice4 {
    public static void main(String[] args) {

        double doublePoint = 84.5;

        int intPoint = (int)doublePoint;

        String rank = (intPoint >= 90)? "A":(intPoint >= 80)? "B":(intPoint >= 70)? "C":(intPoint >= 60)? "D": "F";

        System.out.println("홍길동의 이번 점수 등급은 " + rank + "입니다.");
    }
}
