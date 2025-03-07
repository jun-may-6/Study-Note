package com.ohgiraffers.practice.literal;

public class practice4 {
    public static void main(String[] args) {

        double languagePoint = 80.5;
        double mathPoint = 50.6;
        double englishPoint = 70.8;
        double allPoint = languagePoint + mathPoint + englishPoint;
        double averagePoint = (languagePoint + mathPoint + englishPoint) / 3;


        System.out.println("총점 : " + (int)allPoint);
        System.out.println("평균 : " + (int)(allPoint / 3));
        System.out.println("평균 : " + (int)averagePoint);
        System.out.println("평균 : " + (int)((languagePoint + mathPoint + englishPoint) / 3));
    }
}
