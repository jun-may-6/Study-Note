package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");           // xml 설정을 사용할 때 쓰는 형태

//        bean 가져오기
//        1. id 를 이용하여 가져오기
//        MemberDTO member = (MemberDTO) context.getBean("member");       // 실행 전까지는 MemberDTO 를 판별할 수 없기 때문에 Object 처리됨
//
//        2. 클래스 메타 정보를 전달하여 가져오기
//        MemberDTO member = context.getBean(MemberDTO.class);

//        3. 둘 다 명시하기
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println(member);

    }
}
