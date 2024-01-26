package com.ohgiraffers.section05.logical;

public class Application3 {
    public static void main(String[] args) {
        /* AND연산과 OR 연산의 특징
        * 논리식 && 논리식 : 앞의 결과가 false면 뒤를 실행 안함
        *   조건식 두개가 모두 만족해야 true를 반호나하기에 앞의 결과가 false면 false 반환
        * 논리식 || 논리식 : 앞의 결과가 true이면 뒤를 실행 안함
        *   조건식 하나만 만족해도 true를 반환하기 때문에 앞의 결과가 true이면 바로 frue 반환
        * */

        int num1 = 10;

        int result1 = (false && ++num1 > 0)? num1: num1;
        System.out.println("&&실행 결과 : " + result1);

        int num2 = 10;
        int result2 = (true || ++num2 > 0)? num2 :num2;
        System.out.println("||실행 결과 : " + result2);

    }
}
