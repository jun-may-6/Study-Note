package com.ohgiraffers.practice.literal;

public class practice5 {
    public static void main(String[] args) {
        int regularPrice = 45000;
        int salePrice = 50000;
        int internetPrice = 43000;

        System.out.println("Sale price is " + ((regularPrice < salePrice)? "expensive": "cheap"));
        System.out.println("Internet price is " + ((regularPrice < internetPrice)? "expensive": "cheap"));
    }
}
