package com.ohgiraffers.jwtsecurity.auth.config;

import com.ohgiraffers.jwtsecurity.auth.filter.HeaderFilter;
import com.ohgiraffers.jwtsecurity.auth.interceptor.JwtTokenInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* Web configuration 을 위한 클래스
* */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {


    /* 상수 필드 */
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/static/", "classpath:/public/", "classpath:/", "classpath:/resources/",
            "classpath:/META-INF/resources/", "classpath:/META-INF/resources/webjars/"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* 정적 자원에 대한 접근 허용 */
        registry.addResourceHandler("**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    @Bean
    public FilterRegistrationBean<HeaderFilter> getFilterRegistrationBean() {
        /* HeaderFilter =  */
        FilterRegistrationBean<HeaderFilter> registrationsBean = new FilterRegistrationBean<>(createHeaderFilter());
        registrationsBean.setOrder(Integer.MIN_VALUE);  /* 해당 필터의 순서를 가장 처음으로 */
        registrationsBean.addUrlPatterns("/*");         /* 모든 요청에 대해 필터를 거치게 함 */
        return registrationsBean;
    }

    @Bean
    public HeaderFilter createHeaderFilter() {
        return new HeaderFilter();
    }

    @Bean
    public  JwtTokenInterceptor jwtTokenInterceptor() {
        return new JwtTokenInterceptor();
    }
}
