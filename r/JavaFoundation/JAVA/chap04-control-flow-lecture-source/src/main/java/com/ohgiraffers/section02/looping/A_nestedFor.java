package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class A_nestedFor {

    /* 중첩 for문
    * for문 안에서 for문을 이용할 수 있다.*/

    public void printGugudanFromTwoToNine() {
        for(int dan = 2; dan <= 9; dan++) {

            for(int su = 1; su <= 9; su++) {

                System.out.println(dan + " * " + su + " = " + ( dan*su ));
            }
            System.out.println();
        }
    }
    public void printStarInputRowTimes() {
        /* 키보드로 정수를 하나 입력 받아 해당 정수만큼 한 행에 "*" 을 5개씩 출력해보기 */

        Scanner sc = new Scanner(System.in);
        System.out.println("출력할 행 수를 입력 : ");
        int row = sc.nextInt();

        for(int i = 1; i <= row; i++) {
//            for(int j = 1; j < 6; j++) {
//                System.out.print("*");
//            }
            printStar(5);

            System.out.println();
        }
    }
    public void printStar(int times) {
        for(int i = 1; i <= times; i++) {
            System.out.print("*");
        }
    }
}
