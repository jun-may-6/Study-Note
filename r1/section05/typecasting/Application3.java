package com.ohgiraffers.section05.typecasting;

public class Application3 {
    public static void main(String[] args) {

        /* 필기
        자동 형변환과 강제 형변환을 이용한 다른 자료형끼리의 연산
        다른 자료형끼리 연산은 근 잘형으로 자동 형변환 후 연산처리 된다.
         */
        int inum = 10;
        long lnum = 100;
//        int isum = inum + lnum; 연산 결과가 long값으로 나오므로 오류가 난다.
        int isum = inum + (int)lnum;  //long형을 int형으로 강제형변환
        System.out.println("isum : " + isum);

        int isum2 = (int)(inum + lnum); //연산 결과를 int로 강제형변환

        long isum3 = inum + lnum; // 결과값을 long형으로 받기(자동형변환)
        System.out.println("isum3 : " + isum3);

        /* 주의사항. int 미만의 연산 처리 결과는 int형이다. */

        byte byteNum1 = 1;
        byte byteNum2 = 2;
        short shortNum1 = 3;
        short shortNum2 = 4;

        int result1 = byteNum1 + byteNum2;
        int result2 = byteNum1 + shortNum1;
        int result3 = shortNum1 + byteNum1;
        int result4 = shortNum1 + shortNum2;

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);
        System.out.println("result4 : " + result4);




    }
}
