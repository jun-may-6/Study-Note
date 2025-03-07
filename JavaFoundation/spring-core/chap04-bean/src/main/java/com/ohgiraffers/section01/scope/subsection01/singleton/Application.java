package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String []beanNames = context.getBeanDefinitionNames();
        for(String name:beanNames){
            System.out.println(name);
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);

        cart1.addItem(carpBread);
        cart1.addItem(milk);
        cart1.addItem(water);

        System.out.println("cart1 에 담긴 아이템 : " + cart1.getItems());

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2 에 담긴 아이템 : " + cart2.getItems());

        System.out.println(cart1.hashCode());
        System.out.println(cart2.hashCode());

        /* Spring Framework 에서 Bean 의 기본 스코프는 singleton 이다.
        * singleton 스코프를 갖는 Bean 은 어플리케이션 내에서 유일한 인스턴스를 갖는다.
        * 컨테이너는 cart 라는 Bean 을 하나만 가지고 있기 때문에 cart1 과 cart2 는 같은 주소값을 가지고 있다.
        * */
    }
}
