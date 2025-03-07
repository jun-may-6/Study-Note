package com.errorCode;

public enum EnumTest {
    A("에이", 1),
    B("비", 2),
    C("씨", 3),
    D("디", 4);

    // 문자열을 저장할 필드
    private String korean;
    private int value;

    // 생성자 (싱글톤)
    private EnumTest(String korean, int value) {
        this.korean = korean;
        this.value = value;
    }

    // Getter
    public String getInitial() {
        return korean;
    }
    public int getValue() {
        return value;
    }
}
