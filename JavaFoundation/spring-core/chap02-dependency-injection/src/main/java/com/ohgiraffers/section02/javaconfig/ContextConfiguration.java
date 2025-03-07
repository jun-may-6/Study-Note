package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {
    @Bean
    public Account accountGenerator(){
        return new PersonalAccount(20, "110-234-567890");
    }
    @Bean
    public MemberDTO memberGenerator(){
        /* MemberDTO 생성자를 통해 Account 를 생성하는 메소드를 호출한 리턴 값을 전달하여 bean 을 조립할 수 있다.*/
        MemberDTO memberConstructor = new MemberDTO(1, "판다", "panda@gmail.com", accountGenerator());
        /* setter 주입
        * setter 를 통해 Account 를 생성하는 메소드를 호출한 리턴값을 전달하여 bean 조립*/
        MemberDTO memberSetter = new MemberDTO();
        memberSetter.setSequence(1);
        memberSetter.setName("판다");
        memberSetter.setEmail("panda@gmail.com");
        memberSetter.setPersonalAccount(accountGenerator());

        return memberConstructor;
    }
}
