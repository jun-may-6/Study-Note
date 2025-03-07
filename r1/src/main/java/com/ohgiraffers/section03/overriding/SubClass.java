package com.ohgiraffers.section03.overriding;

public class SubClass extends SuperClass{
//    @Override
//    public void Method2(int num){}    //메소드 이름이 변경됨

//    @Override
//    public int method(int Num){return 0;} //메소드의 리턴타입이 다르다(void -> int)
//    @Override
//    public void method(String num){}      //매개변수의 자료형이 다르다.

//    @Override
//    public void method(int num, String num) {}    //매개변수의 갯수가 다르다.
    @Override
    public void method(int num){}   //정상작동

//    @Override
//    private void privateMethod() {}   //private 로 보호되어 있는 메소드

//    @Override
//    public final void finalMethod(){}     //final 키워드를 사용하는 메소드

//    @Override
//    void protectedMethod(){}
//    /*default = 같은 패키지 내에서 사용 가능
//    protected = 상속받은 클래스에서도 사용 가능
//    즉, default < protected 이므로 사용 불가능*/

//    @Override
//    protected void protectedMethod(){}  //동일한 범위(사용 가능) 메소드 시그니쳐가 같아 일단 주석
    @Override
    public void protectedMethod(){}     //더 넓은 범위(사용 가능)
}
