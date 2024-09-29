package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;


@WebFilter("/first/*")
/* jakarta.servlet */
public class FirstFilter implements Filter {
    public FirstFilter(){
        System.out.println("FirstFilter 기본 생성자 호출");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter init() 호출");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /* Servlet 으로 request 가 전달되게 전에 요청을 가로채는 역할을 하는 메소드 */
        System.out.println("FirstFilter doFilter() 호출");

        /* ==== 필터에서 처리할 코드 ==== */

        /* 필터 처리 이후 다음 필터 또는 Servlet 의 doGet/doPost 를 호출 */
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("doFilter() 이후 Servlet 요청 수행 완료");
    }


    @Override
    public void destroy() {
        System.out.println("FirstFilter destroy() 호출");
    }

}
