package com.ohgiraffers.thymeleaf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/* 스캔 달아주기 */
@Configuration
@ComponentScan(basePackages = "com.ohgiraffers.thymeleaf")
public class ContextConfiguration {
}
