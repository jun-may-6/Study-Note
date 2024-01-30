package com.ohgiraffers.section01.method;

public class Application6 {
    public static void main(String[] args) {

        /* 메소드는 항상 마지막에 return 명령어가 존재한다.
        * return은 자신을 호출한 구문으로 복귀한느 것을 의미한다.
        * 복귀를 할 때 그냥 복귀하거나 값을 가지고 복귀할 수 있다.
        * 이 때 가지고 가는 값을 리턴값이라 한다.
        *
        * return값을 반환받기 위해서는 메소드 선언부에 리턴타입을 명시해 주어야 한다.
        * void는 아무 반환값도 가지지 않겠다는 리턴타입에 사용할 수 있는 키워드이다.
        * 반환값이 없는 경우 return 구문을 생략해도 되지만,
        * 반환값이 있는 경우는 return 구문을 반드시 작성해야 한다.
        * 또한 메소드 선언부에 선언한 리턴타입 반환값의 자료형은 반드시 일치해야 한다.
        */
        System.out.println("main() 시작");

        Application6 app6 = new Application6();

        app6.testMethod();

        String reutrnText = app6.testMethod();

        System.out.println(reutrnText);

        System.out.println(app6.testMethod());

        System.out.println("main() 종료");

    }
    public String testMethod() {

        /*
        * public 뒤에 바로 return으로 가지고 갈 타입을 명시한다.
        * 아무 값도 리턴하지 않는 경우 voud, 값을 반환하는 경우에응 반환값의 자료형을 작성해야 한다.
        * */

        return"hello world";
    }
}
