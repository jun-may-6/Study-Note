package com.ohgiraffers.section04.camparsion;

public class Application1 {
    public static void main(String[] args) {

        /* 비교 연산자
        * 비교연산자는 피연산자 사이에서 상대적인 크기를 판단하여 참 혹은 거짓을 판단하는 연산자이다.
        * 연산자 중 참 혹은 거짓을 반환하는 연산자는 삼항연산자의 조건식이나 조건문의 조건절에 많이 사용한다*/

        /* 필기
        비교연산자의 종류
        == : 왼쪽의 피연산자와 오른쪽의 피연산자가 같은지
        != : 왼쪽의 피연산자와 오른쪽의 피연산자가 다른지
        >= : 왼쪽의 피연산자가 오른쪽의 피연산자보다 크거나 같은지
        <= : 왼쪽의 피연산자가 오른쪽의 피연산자보다 작거나 같은지
        >  : 왼쪽의 피연산자가 오른쪽의 피연산자보다 작은지
        <  : 왼쪽의 피연산자가 오른쪽의 피연산자보다 큰지
         */

        int inum1 = 10;
        int inum2 = 20;
        System.out.println("=== 정수값 비교 ===");
        System.out.println("inum1과 inum2가 같은지 비교 : " + (inum1 == inum2));
        System.out.println("inum1과 inum2가 다른지 비교 : " + (inum1 != inum2));
        System.out.println("inum1이 inum2보다 크거나 같은지 비교 : " + (inum1 >= inum2));
        System.out.println("inum1이 inum2보다 작거나 같은지 비교 : " + (inum1 <= inum2));
        System.out.println("inum1이 inum2보다 큰지 비교 : " + (inum1 > inum2));
        System.out.println("inum1이 inum2보다 작은지 비교 : " + (inum1 < inum2));
        /* 문자값 비교 */
        char ch1 = 'a'; // = 97
        char ch2 = 'A'; // = 65

        System.out.println("=== 문자값 비교 ===");
        System.out.println("ch1과 ch2가 같은지 비교 : " + (ch1 == ch2));
        System.out.println("ch1과 ch2가 다른지 비교 : " + (ch1 != ch2));
        System.out.println("ch1이 ch2보다 크거나 같은지 비교 : " + (ch1 >= ch2));
        System.out.println("ch1이 ch2보다 작거나 같은지 비교 : " + (ch1 <= ch2));
        System.out.println("ch1이 ch2보다 큰지 비교 : " + (ch1 > ch2));
        System.out.println("ch1이 ch2보다 작은지 비교 : " + (ch1 < ch2));
    }
}
