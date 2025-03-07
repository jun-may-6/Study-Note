package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class B_ifElse {

    public void simpleIfElseStatement() {

    /* [if-else문 표현식]
    *  if(조건식) {
    *        조건식이 true일 때 실행할 명령문
    *  } else {
    *        조건식이 false일 때 실행할 명령문
    *  }
    * */

    Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력하세요 : ");
        int num = sc.nextInt();

        if(num % 2 == 0) {
            System.out.println("입력한 숫자는 짝수~~");
        } else {
            System.out.println("입력한 숫자는 홀수~~");
        }
        System.out.println("끝~");

    }

    public void nestedIfElseStatement() {

        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요 : ");
        int num = sc.nextInt();

        if(num != 0) {

            if(num > 0) {
                System.out.println("양수입니다~~");
            } else {
                System.out.println("음수입니다~~");
            }
        } else {
            System.out.println("0 입니다!~~~");
        }
        System.out.println("프로그램을 종료합니다.");
    }


}
