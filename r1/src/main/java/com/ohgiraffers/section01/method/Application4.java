package com.ohgiraffers.section01.method;

public class Application4 {
    public static void main(String[] args) {

        /* 여러 개의 전달인자를 이용한 메소드 호출 테스트*/
        Application4 app4 = new Application4();

        app4.textMethod("편승준", 26, '남');
//        app4.textMethod(26, "편승준", '남'); // 자료형이 달라서 오류
        String name = "편승준";
        int age =  26;
        char gender = '남';
        app4.textMethod(name, age, gender);
    }
    public void textMethod(String name, int age, final char gender) {

        /* 매개변수도 일종의 지역변수로 분류된다.
        * 매개변수 역시 final키워드를 사용할 수 있다.
        * 지역변수에 final 키워드를 붙여 상수를 만드는 것과 동일하다.
        * final 매개변수는 상수 네이밍 규칙을 선택적으로 따르는 경향이 있다.
        * */

        System.out.println("당신의 이름은 " + name + "이고, 나이는 " + age + "세 이며, 성별은 " + gender + "입니다.");
    }

}
