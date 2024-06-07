package com.ohgiraffers.section02.template;

import java.util.Scanner;

public class clacu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int tan = sc.nextInt();
            int dan = sc.nextInt();
            int ji = sc.nextInt();
            System.out.println(tan * 4 + dan * 4 + ji * 9);
        }
    }
}
