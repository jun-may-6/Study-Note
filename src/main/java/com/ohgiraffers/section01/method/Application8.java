package com.ohgiraffers.section01.method;

public class Application8 {
    public static void main(String[] args) {

        /*static 메소드 호출
        * static이 있는 메소드이건 non-static 메소드이건 동작 흐름은 동일하다
        *
        * static 메소드 호출 방법
        * 클래스명.메소드명();
        * */

        System.out.println("10점과 20의 합 : " + Application8.sumTwoNumbers(10, 20));
        System.out.println("20과 30의 합 : " + sumTwoNumbers(20, 30));
    }
    public static int sumTwoNumbers(int first, int second) {
        return first + second;
    }
}
