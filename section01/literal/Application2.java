package com.ohgiraffers.section01.literal;

public class Application2 {

    public  static void main(String[] args) {

        System.out.println("int operation");
        System.out.println(123 + 456);
        System.out.println(123 -23);
        System.out.println(123 * 10);
        System.out.println(123/ 10);
        System.out.println(123 % 10);
        /* 주석 */
        System.out.println("");
        System.out.println("float operation");
        System.out.println(1.23 + 1.23);
        System.out.println(1.23 - 0.23);
        System.out.println(1.23 * 10.0);
        System.out.println(1.23 % 1.0); //some error
        System.out.println("");
        System.out.println("int float operation");
        System.out.println(123 + 0.5);
        System.out.println(123 - 0.5);
        System.out.println(123 / 0.5);
        System.out.println(123 % 0.5);
        System.out.println("");
        System.out.println("char operation(ascii)");
        System.out.println('a' + 'b');
        System.out.println('a' - 'b');
        System.out.println('a' * 'b');
        System.out.println('a' / 'b');
        System.out.println('a' % 'b');
        System.out.println("");
        System.out.println("char int operation(ascii)");
        System.out.println('a' + 1);
        System.out.println('a' - 1);
        System.out.println('a' * 2);
        System.out.println('a' / 2);
        System.out.println('a' % 2);
        System.out.println("");
        System.out.println("char float operation(ascii)");
        System.out.println('a' + 1.0);
        System.out.println('a' - 1.0);
        System.out.println('a' * 2.0);
        System.out.println('a' / 2.0);
        System.out.println('a' % 2.0);
        System.out.println("");
        System.out.println("str operation = + only");
        System.out.println("hello" + "world");
//        System.out.println("hello" - "world"); (error)
//        System.out.println("hello" * "world"); (error)
//        System.out.println("hello" / "world"); (error)
//        System.out.println("hello" % "world"); (error)
        System.out.println("");
        System.out.println("str + other = str + str");
        System.out.println("helloworld" + 123);     //str num
        System.out.println("helloworld" + 123.456); //str int
        System.out.println("helloworld" + 'a');     //str char
        System.out.println("helloworld" + true);    //str boolean
        System.out.println("");
        System.out.println("boolean operation = can't");
//        System.out.println(true + false);
//        System.out.println(true - false);
//        System.out.println(true * false);System.out.println(true + false);
//        System.out.println(true / false);
//        System.out.println(true % false);
        System.out.println("");
        System.out.println("boolean int operation = can't");
//        System.out.println(true + 1);
//        System.out.println(true - 1);
//        System.out.println(true * 2);
//        System.out.println(true / 2);
//        System.out.println(true % 2);
        System.out.println("논리값과 정수의 연산"); /*논리값과 실수의 연산도 모든 연산이 불가능하다*/
//        System.out.println(true + 1.0);
//        System.out.println(true - 1.0);
//        System.out.println(true * 2.0);
//        System.out.println(true / 2.0);
//        System.out.println(true % 2.0);
        System.out.println("논리값과 문자의 연산"); /*논리값과 숫자의 계산과 같이 안됨*/
//        System.out.println(true + 'a');
//        System.out.println(true -'a');
//        System.out.println(true * 'a');
//        System.out.println(true * 'a');
//        System.out.println(true /'a');
//        System.out.println(true % 'a');
        System.out.println("");
        System.out.println("논리값과 문자열의 연산"); /*합만 가능(문자열과 문자열 합으로 취급)*/
        System.out.println(true + "a");
//        System.out.println(true - "a");
//        System.out.println(true * "a");
//        System.out.println(true / "a");
//        System.out.println(true % "a");
        System.out.println("");
        System.out.println("str form num operation");
        System.out.println("123" + "456");
        System.out.println("");
    }
}
