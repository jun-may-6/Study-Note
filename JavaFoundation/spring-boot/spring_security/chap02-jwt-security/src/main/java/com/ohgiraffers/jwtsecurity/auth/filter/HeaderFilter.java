package com.ohgiraffers.jwtsecurity.auth.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 * CORS 설정을 위한 filter 설정 클래스 (리소스 탈취)
 * */
public class HeaderFilter implements Filter {
    /* 필터 상속 */

    @Override /* 필터는 doFilter 강제 오버라이딩 */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        res.setHeader("Access-Control-Allow-Origin", "*");                          /* 다른 외부 요청의 응답 허용 여부*/
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");    /* 외부 요청에 허용할 메소드 */
        res.setHeader("Access-Control-Max-Age", "3600");                            /* 캐싱을 허용할 시간(초 단위) */
        res.setHeader("Access-Control-Allow-Headers",                                   /* 요청 시 허용할 헤더 타입 */
                "X-Requested-With, Content-Type, Authorization, X-XSRF-token");
        res.setHeader("Access-Control-Allow-Credentials", "false");                 /* 자격 증명 허용 여부 */

        filterChain.doFilter(servletRequest, res);
    }
}
