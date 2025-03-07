package com.ohgiraffers.section05.typecasting;

public class Application2 {
    public static void main(String[] args) {
        /*필기
        강제형변환
        바꾸려는 자료형으로 캐스트 연산자를 이용하여 형변환한다.
         */
        /*필기
        자동형변환 규칙의 반대 상황에서 강제 형변환이 필요하다.
        1. 큰 자료형에서 작은 자료형으로 변경 시 강제 형변환이 필요하다.
        2. 실수를 정수로 변경 시 강제 형변환이 필요하다.
        3. 문자형을 int미만 크기의 변수에 저장할 때 강제 형변환이 필요하다.
        4. 논리형은 강제 형변환 규칙에서도 제외된다.
         */
        long lnum = 8;
//        int inum = lnum; 데이터 손실 가능성으로 인해 컴파일러 오류 발생
        int inum = (int)lnum;

        short snum = (short)inum;
        byte bnum = (byte)snum;

        double dnum = 8.0;
//        float fnum = dnum; 데이터 손실 가능성으로 인해 컴파일러 오류 발생
        float fnum = (float)dnum;
        System.out.println(fnum);

        float fnum2 = 4.0f;
//        long lnum2 = fnum2; 소숫점 뒤 손실 가능성으로 인해 컴파일러 오류 발생\
        long lnum2 = (long)fnum2;

        System.out.println(fnum2);
        System.out.println(lnum2);

        char ch = 'a';
//        byte bnum2 = ch;
        byte bnum2 = (byte)ch; //char 자료형보다 작으므로 강제형변환을 해야함
        short snum2 = (short)ch; //같은 2byte지만 부호기호로 인한 범위가 달라 자동형변환이 되지 않음

        boolean isTrue = true;
//        int i = isTrue;
//        char c = isTrue;
//        double d = isTrue;

    }
}
