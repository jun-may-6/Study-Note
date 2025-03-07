package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EncodingFilter implements Filter {

    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        filterConfig xml 파일의 정보
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse hresponsse = (HttpServletResponse) servletResponse;
        hresponsse.setContentType(encodingType);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
