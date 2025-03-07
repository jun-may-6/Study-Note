package com.ohgiraffers.section02.variable;

public class Application3 {
    public static void main(String[] args) {
        /* 필기. 변수의 명명 규칙
        변수의 이름을 지을 때 아무렇게나 짓는 것이 아닌 정해진 규칙이 있다.
        실무적으로 중요하기 때문에 숙지
        오류가 생길 수 있는 규칙
        1. 동일한 범위 내에서 동일한 변수명을 가질 수 없다.
        2. 변수의 이름에는 자바에서 사용중이 키워드를 사용할 수 없다. ex) int, float, while, continue 등
        3. 변수의 이름은 영문자 대소문자를 구분한다
            ex) age ≠ Age
        4. 변수의 이름은 숫자로 시작할 수 없다.
        5. 특수기호는 _와 $만 사용 가능하다.
        오류가 생기진 않지만 암묵적 규칙
        1. 변수명이 합성어일 경우 첫 단어는 소문자, 두 번째 단어는 대문자로 시작한다 ex)memverAddress
        2. 단어와 단어 사이의 연결을 언더스코어(_)로 하지 않는다.
        3. 한글로 변수명을 지을 수 있지만 권장하지 않는다.
        4. 변수 안에 저장된 값이 어떤 의미를 가지는지 명확히 표현하도록 한다.
        5. 전형적인 변수 이름이 있다면 가급적 사용한다.
        6. 명사형으로 작성한다.
            1. 변수의 길이는 심하게 길지 않게 한다.
        7. 불린형은 의문문으로, 가급적 긍정 형태로 네이밍한다.
         */

        int age = 20;
//        int age = 20; 동일한 변수명을 가지므로 오류 발생

//        int true = 1; 예약어 사용 불가
//        int for = 20; 예약어 사용 불가
        int Age = 20; //대소문자 구분하여 다른 변수취급
        int True = 10; //대소문자 구분하여 예약어가 아니므로 사용 가능

//        int 1age = 20; 숫자로 시작하는 변수 사용 불가
        int age1 = 20;

        int _age = 20;
        int $harp = 20;
//        int sh^rp = 20; 사용 불가능한 특수기호

        int asdgsadfsdfcdxgcvhxfghgvfbjmcvcbhjcfgvhcfhgfgh;
        int maxAge = 20; //camelCase
        int minAge = 10;

        String user_name;
        String userName; //camelCase

        int 나이 = 20; //한글 쓰지 않는것 권장

        String s; //의도 파악이 어려움
        String name; //의도 파악 가능한 단어 사용

        int sum = 0;  //전형적인 변수 이름들
        int max = 10;
        int min = 0;
        int count = 1;

        String  goHone; //가능하면 동사가 아닌 명사형
        String  home;

        boolean isAlive = true; //가능한 의문, 긍정형으로 작성
        boolean isDead = false; //부정형 작성 가급적 자제


    }
}
