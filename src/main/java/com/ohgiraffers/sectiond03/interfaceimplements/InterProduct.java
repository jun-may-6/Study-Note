package com.ohgiraffers.sectiond03.interfaceimplements;

public interface InterProduct {

    /*인터페이스는 상수 필드만 작성 가능하다.
    * public static final 제어자 <- 형태를 상수 필드라고 한다.
    * 반드시 선언과 동시에 초기화 해줘야 한다.
    * */

    public static final int MAX_NUM = 100;
    int MIN_NUM = 10;           //static final 이 묵시적으로 표기되어있음

//    public InterProduct() {}      //생성자를 가질 수 없음
//    public void nonStaticMethod(){}   //구현부가 있는 non-static 메소드를 가질 수 없다.

    public abstract void nonStaticMethod();     //추상 메소드만 작성 가능
    /*인터페이스의 메소드는 묵시적으로 public 이므로 인터페이스의 메소드를 오버라이딩 하는 경우
    * 반드시 접근제한자를 public 으로 해야한다.
    * */

    void abstMethod();      //구현부 생략하고 작성 가능


    /*JDK 1.8에 추가된 기능*/
    public static void staticMethod(){          //스태틱 메소드 사용 가능
        System.out.println("interProduct 클래스의 staticMethod 호출");
    }
    public default void defaultMethod(){        //구현부가 default 이면 non-static 메소드 사용 가능
        System.out.println("interProduct 클래스의 defaultMethod 호출");
    }



}
