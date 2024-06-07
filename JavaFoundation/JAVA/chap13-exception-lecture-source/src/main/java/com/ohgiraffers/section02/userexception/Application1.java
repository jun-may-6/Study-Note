package com.ohgiraffers.section02.userexception;

public class Application1 {
    public static void main(String[] args) {

        ExceptionTest et = new ExceptionTest();

        try {
//            et.checkEnoughMoney(50000, 30000);
//            et.checkEnoughMoney(-50000,50000);
//            et.checkEnoughMoney(50000,-60000);

            et.checkEnoughMoney(30000,5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
