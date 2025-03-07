package com.ohgiraffers.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
/* @Primary 어노테이션을 사용하면 여러 타입의 빈을 찾게 되는 경우 자동으로 우선 순위를 가지게 된다.
* 동일한 타입의 클래스 중 하나만 @Primary 어노테이션을 사용할 수 있다.*/
public class Charmander implements Pokemon {
    @Override
    public void attack() {
        System.out.println("파이리 불꽃공격");
    }
}
