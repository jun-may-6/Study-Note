package com.ohgiraffers.practice.operator;

public class practice5 {
    public static void main(String[] args) {

        int month = 5;
        int day = 6;

        String coupon = (month <= 6 && day <= 15)? "배민 쿠폰" : (month >= 7 && day >= 16)? "스타벅스 커피": "사탕";

        System.out.println("편승준의 선물은 " + coupon + "입니다.");
    }
}
