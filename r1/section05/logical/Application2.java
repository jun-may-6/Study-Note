package com.ohgiraffers.section05.logical;

public class Application2 {
    public static void main(String[] args) {

        /* 논리 연산자의 우선순위
        * && : 11순위
        * // : 12순위
        * */

        int num1 = 55;
        System.out.println("1부터 100 사이인지 ?? : " + (1 <= num1 && num1 <= 100));

        int num2 = 175;
        System.out.println("1부터 100 사이인지?? : " + (num2 >= 1 && num2 <= 100));

        /* 영어 대문자인지 확인
        * 문자변수 >= 'A' && 문자면수 <= 'Z'*/
        char ch = 'T';
        System.out.println("영어 대문자인지? : " + (ch >= 'A' && ch <= 'Z'));

        char ch2 = 'w';
        System.out.println("영어 대문자인지? : " + (ch2 >= 'A' && ch2 <= 'Z'));

        /* 대소문자 상관없이 영문자 'y'인지 확인 */
        char ch3 = 'Y';
        System.out.println("영문자 y인지? : " + (ch3 == 'y' || ch3 == 'Y'))

        /* 영문자인지 확인 */;
        char ch4 = 'f';
        System.out.println("영문자인지 확인 : " + ((ch4 >= 'A' && ch4 <= 'Z') || (ch4 >= 'a' && ch4 <= 'b')));
        System.out.println("영문자인지 확인 : " + ((ch4 >= 65 && ch4 <= 90) || (ch4 >= 97 && ch4 <= 120)));
    }
}
