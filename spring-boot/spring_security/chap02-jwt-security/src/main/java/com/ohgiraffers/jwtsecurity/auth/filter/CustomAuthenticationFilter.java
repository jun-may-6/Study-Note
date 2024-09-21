package com.ohgiraffers.jwtsecurity.auth.filter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.jwtsecurity.auth.model.dto.LoginDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager){
        super.setAuthenticationManager(authenticationManager);

    }



    /**
     * description. 지정된 url 요청 시 해당 요청을 가로채서 검증 로직을 수행하는 메소드
     *
     * @param request  : HttpServletRequest
     * @param response : HttpServletResponse
     * @return Authentication
     * @throws AuthenticationException
     */
    /* 로그인 요청시 첫번째로 이곳으로 전달 */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        UsernamePasswordAuthenticationToken authRequest;

        try {
            /* id 비밀번호 추출*/
            authRequest = getAuthRequest(request);
            /* id, 비밀번호 외에 ip, 세션 id 등의 정보를 디테일에 저장하는 메소드 */
            setDetails(request, authRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /* getAuthenticationManager = 상속받은 메소드. 현재 필터에 설정된 AuthenticationManager 반환
        * 기본적으로 인증을 수행하는 인터페이스.
        * 등록되어있는 여러 AuthenticationProvider 를 순차적으로 인증 시도
        * 인증에 성공한다면 권한이 담긴 Authentication 객체를 반환한다. */
        return this.getAuthenticationManager().authenticate(authRequest);
    }


    /**
     * description. 사용자의 로그인 요청 시 요청 정보를 임시 토큰에 저장하는 메소드
     *
     * @param request : HttpServletRequest
     * @return UsernamePasswordAuthenticationToken
     * @throws IOException
     */
    private UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        LoginDTO user = objectMapper.readValue(request.getInputStream(), LoginDTO.class);
        return new UsernamePasswordAuthenticationToken(user.getId(), user.getPass());
    }

}
