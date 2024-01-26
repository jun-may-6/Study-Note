package com.ohgiraffers.section01.literal;

public class Application3 {

    public static void main(String[] args) {

        System.out.println("==== 두 개의 문자열 합치기 ====");
        System.out.println(9 + 9);     //num 18
        System.out.println("9" + 9);   //str 99
        System.out.println(9 + "9");   //str 99
        System.out.println("9" +"9");  //str 99
        System.out.println("");
        System.out.println("==== 세개의 문자열 합치기 ====");
        System.out.println(9 + 9 + "9");   //189
        System.out.println(9 + "9" + 9);   //999
        System.out.println("9" + 9 + 9);   //999
        System.out.println("9" + (9 + 9));  //918
        System.out.println("");
        System.out.println("==== 10과 20의 사칙연산 결과 ====");
        System.out.println(10 + 20); // 30
        System.out.println(10 - 20); // -10
        System.out.println(10 * 20); // 200
        System.out.println(10 / 20); // 0.5
        System.out.println(10 % 20); // 10
        System.out.println(("==== 10과 20의 사칙연산 결과 보기 좋게 출력 ===="));
        System.out.println("10과 20의 합 : " + (10 + 20));    //괄호 넣어 순서 맞추기
        System.out.println("10과 20의 차 : " + (10 - 20));
        System.out.println("10과 20의 곱 : " + (10 * 20));
        System.out.println("10과 20을 나누기 한 몫 : " + (10 / 20));
        System.out.println("10과 20을 나누기 한 나머지 : " + (10 % 20));
        System.out.println("");
        System.out.println("기차");
        System.out.println("기차" + "칙칙폭폭");
        System.out.println("기차" + 123 + 45 + "출발");
        System.out.println(123 + 45 + "기차" + "출발");


    }
}


