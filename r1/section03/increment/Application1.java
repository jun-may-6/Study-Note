package com.ohgiraffers.section03.increment;

public class Application1 {
    public static void main(String[] args) {

        /* 필기
        증감연산자
        피연산자의 앞 or 뒤에 사용이 가능하다.
        ++ : 1 증가
        -- : 1 감소
         */

        int num = 20;
        System.out.println("num : " + num);

        num++;
        System.out.println("num : " + num);

        ++num;
        System.out.println("num : " + num);

        num--;
        System.out.println("num = " + num);

        --num;
        System.out.println("num = " + num);

        /* 주의사항
        * 증감연산자는 다른 연산자와 함께 사용할 때 의미가 달라진다
        * 다른 연산자와 함께 사용할 때의 의미
        * 'var++' : 다른 연산을 먼저 진행하고 난 뒤 마지막에 피연산자의 값을 1 증가
        * '++var' : 피연산자의 값을 먼저 1 증가시킨 후 다른 연산을 진행
        * 'var-- : 다른 연산을 먼저 진행하고 난 뒤 마지막에 피연산자의 값을 1 감소
        * '--var' : 피연산자의 값을 먼저 1 감소시킨 후 다른 연산을 진행*/

        int firstNum = 20;

        int result1 = firstNum++ * 3; // 곱연산을 끝낸 후 firstNum + 1

        System.out.println(result1);

        int secondNum = 20;
        int result2 = ++secondNum * 3; // secondNum + 1 한 후 곱연산

        System.out.println("result2 : " + result2);
        System.out.println("secondNum : " + secondNum);

        int num1 = 10;
        int addNum = num1++;
        System.out.println("addNum : " + addNum);
        System.out.println("num1 : " + num1);
    }
}
