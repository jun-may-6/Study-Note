package com.errorCode;

import java.security.spec.RSAOtherPrimeInfo;

public class Main {
    public static void main(String[] args) {
        EnumTest enumTest = EnumTest.A;
        System.out.println(enumTest.getInitial());
        System.out.println(enumTest.getValue());
    }
}