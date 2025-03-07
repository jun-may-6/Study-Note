package com.ohgiraffers.section01.method;

public class Application3 {
    public static void main(String[] args) {
        /* 전달인자(arguments)와 매개변수(*parameter)를 이용한 메소드 호출 */

        /* 변수의 종류
        * 1. 지역변수
        * 2. 매개변수
        * 3. 전역변수(필드)
        * 4. 클래스(static) 변수
        * */

        /* 지역변수는 선언한 메소드 블럭 내부에서만 사용 가능하다. 이것을 지역변수의 스코프라고 한다.
        * 다른 메소드간 서로 공유해야 하는 값이 존재하는 경우 메소드 호출 시 사용하는 괄호를 이용해서 값을 전달할 수 있다.
        * 이 때 전달하는 값을 전달인자(argument)라고 부르고,
        * \메소드 선언부 괄호 안에 전달인자를 받기 위하여 선언하는 변수를 매개변수(parameter)라고 부른다.*/

        Application3 app3 = new Application3();
        /* 전달인자와 매개변수를 이용한 메소드 호출 테스트 */
        app3.testMethod(26);
//        app3.testMethod("40"); // 매개변수와 전달인자의 자료형이 다르다.
//        app3.testMethod(20, 30, 40); // 매개변수와 전달인자의 수가 같지 않다.
//        app3.testMethod(); //매개변수가 선언되었지만 인자가 없다.
        int age2 = 20;
        app3.testMethod(age2);

        byte byteAge = 10;
        app3.testMethod(byteAge);

        long longAge = 60;
//        app3.testMethod(longAge); //큰 자료형-> 작은 자료형이기 때문에 자동 형변환이 되지 않는다.
        app3.testMethod((int)longAge); //강제 형변환

        app3.testMethod(age2 * 4);
    }
    public void testMethod(int age) {
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }
}
