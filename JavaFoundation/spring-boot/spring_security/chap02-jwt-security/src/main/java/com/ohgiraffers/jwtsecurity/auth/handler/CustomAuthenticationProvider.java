package com.ohgiraffers.jwtsecurity.auth.handler;

import com.ohgiraffers.jwtsecurity.auth.model.DetailsUser;
import com.ohgiraffers.jwtsecurity.auth.model.service.DetailsService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomAuthenticationProvider  implements AuthenticationProvider{

    @Autowired
    private DetailsService detailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        /* 임시 토큰과 유저 정보 비교 */
        UsernamePasswordAuthenticationToken loginToken = (UsernamePasswordAuthenticationToken) authentication;
        String id = loginToken.getName();
        String pass = (String) loginToken.getCredentials(); //Object 를 String 으로 다운캐스팅
        DetailsUser detailsUser = (DetailsUser) detailsService.loadUserByUsername(id);

        if(!passwordEncoder.matches(pass, detailsUser.getPassword())){
            throw new BadCredentialsException(pass+"는 틀린 비밀번호입니다.");
        }
        return new UsernamePasswordAuthenticationToken(detailsUser, pass, detailsUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication){
        /* 토큰 타입에 따른 Provider 사용 조건 지정 */
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
