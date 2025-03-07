package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.ohgiraffers.section02.initdestroy.subsection02.annotation")
public class ContextConfiguration {
    @Bean
    public Product carpBread(){
        return new Bread("붕어빵", 1000, new java.util.Date());
    }
    @Bean
    public Product milk(){
        return new Beverage("바나나우유", 1500, 500);
    }
    @Bean
    public Product water(){
        return new Beverage("지리산암반수", 3000, 500);
    }
    @Bean
    @Scope("prototype")     //스코프 명시
    public ShoppingCart cart(){
        return new ShoppingCart();
    }
    /* xml 파일에서 스코프를 명시할 경우
    * <bean id = "경로" scope="prototype">*/
}
