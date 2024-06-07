package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class C_doWhile {

    /*
    * [do-while문 표현식]
    * 초기식;
    * do {
    *       1회차에는 무조건 실행하고, 이후에는 조건식을 확인하여 만족하는 경우 수행할 구문
    *       증감식;
    * } while(조건식);
    * */

    public  void simpleDoWhileStatement() {

        do {
            System.out.println("최초 한번 동작함");
        } while(false);

        System.out.println("반복문 종료 확인");
    }

    public void testDoWhileExample1() {
        /* 스캐너로 문자열 입력 받아 반복적 출력
        * 단, exit가 입력되면 반복문을 종료한다.
        * */
        Scanner sc = new Scanner(System.in);
        String str = "";
        do {
            System.out.println("문자열을 입력해주세요 : ");
            str = sc.nextLine();
            System.out.println(str);
            /* equals() : 문자열을 비교하는 기능 제공 */
        } while(!str.equals("exit"));

        System.out.println("프로그램을 종료합니다.");
    }
}
