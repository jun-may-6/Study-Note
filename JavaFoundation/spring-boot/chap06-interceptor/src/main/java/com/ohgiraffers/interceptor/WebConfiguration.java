package com.ohgiraffers.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebInputException;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final StopwatchInterceptor stopwatchInterceptor;

    public WebConfiguration(StopwatchInterceptor stopwatchInterceptor) {
        this.stopwatchInterceptor = stopwatchInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /* 여러 인터셉터를 저장하는 장치 */
        registry.addInterceptor(stopwatchInterceptor)   // 인터셉터 적용
                .addPathPatterns("/stopwatch");         // 적용 범위
    }
}
