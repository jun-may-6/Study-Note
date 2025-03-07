package com.ohgiraffers.section03.annotconfig.sub01.java;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();      // 컨테이너의 bean 이름 배열로 반환
        for(String beanName :beanNames){
            System.out.println(beanName);
        }

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);    // memberDAO 의 필드와 메소드를 가져온다

        System.out.println(memberDAO.selectMember(1));
        System.out.println(memberDAO.insertMember(new MemberDTO(3, "user03", "pass03", "코알라")));
        System.out.println(memberDAO.selectMember(3));
    }
}
