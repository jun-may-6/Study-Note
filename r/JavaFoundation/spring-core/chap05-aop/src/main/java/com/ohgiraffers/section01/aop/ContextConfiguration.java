package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
/* aspectj 의 autoProxy 사용에 관한 설정을 해 주어야 advice 가 동작한다. */
@EnableAspectJAutoProxy(proxyTargetClass = true)     // 오토 프록시
public class ContextConfiguration {

}
