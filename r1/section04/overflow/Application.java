package com.ohgiraffers.section04.overflow;

public class Application {
    public static void main(String[] args) {

        /*필기.
        자료형 별 값의 최대치를 벗어나는 경우 발생한 carry를 버림처리 하고 sign bit를 반전시켜 최소값으로 순환
         */

        byte num1 = 127;

        System.out.println("num1 : " + num1);

        num1++; // num1 = num1 + 1;

        System.out.println("num1 overflow : " + num1);

        /*필기. 언더플로우
        오버플로우의 반대 개념으로 최소 범위보다 작은 수를 발생시키는 경우 발생하는 현상
         */

        byte num2 = -128;

        System.out.println("num2 : " + num2);

        num2--; // num2 = num2 - 1;

        System.out.println("num2 overflow : " + num2);

        int firstNum = 10000000; //100만
        int secondNum = 700000; //70만

        int multi = firstNum * secondNum; //7천억이 출력돼야 함
        System.out.println("firstNum * secondNum : " + multi); //-796692480 출력

        long longMulti = firstNum * secondNum;
        System.out.println("longMulti : " + longMulti);

        long result = (long) firstNum * secondNum; //계산 결과를 long값으로 출력하겠다는 의미(강제 형변환)
        System.out.println("result : " + result);
    }
}
