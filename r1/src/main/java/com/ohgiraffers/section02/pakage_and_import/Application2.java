package com.ohgiraffers.section02.pakage_and_import;

import com.ohgiraffers.section01.method.Calculator;
import static com.ohgiraffers.section01.method.Calculator.maxNumberOf;

public class Application2 {
    public static void main(String[] args) {
        /* 임포트란:?
        * 다른 패키지에 존재하는 클래스를 사용할 때 풀 네임을 기술하기 번거롭다.
        * 때문에 어떤 패키지 내에 있는 클래스를 사용할 것인지 미리 선언하는 임포트문을 사용한다.
        * */

        /*non-static 메소드*/
        Calculator calc = new Calculator();
        int min = calc.minNumberOf(50, 60);

        System.out.println("50과 60중 작은 수는 " + min);

        /*static 메소드*/
        int max = Calculator.maxNumberOf(50, 60);

        System.out.println("50과 60중 더 큰 수는 " + max);

        int max2 = maxNumberOf(50, 60);

        System.out.println("50과 60중 더 큰 수는 " + max2);
    }
}
