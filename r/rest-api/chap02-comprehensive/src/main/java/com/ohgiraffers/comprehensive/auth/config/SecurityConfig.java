package com.ohgiraffers.comprehensive.auth.config;

import com.ohgiraffers.comprehensive.auth.filter.CustomAuthenticationFilter;
import com.ohgiraffers.comprehensive.auth.filter.JwtAuthenticationFilter;
import com.ohgiraffers.comprehensive.auth.handler.JwtAccessDeniedHandler;
import com.ohgiraffers.comprehensive.auth.handler.JwtAuthenticationEntryPoint;
import com.ohgiraffers.comprehensive.auth.handler.LoginFailureHandler;
import com.ohgiraffers.comprehensive.auth.handler.LoginSuccessHandler;
import com.ohgiraffers.comprehensive.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@RequiredArgsConstructor
/* 메소드 레벨의 제어를 활성화 하는 어노테이션
* 메소드 매개변수나 반환 값이 권한 부여를 결정 지을 때 활용
* */
@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.
                /* CSRF 공격 방지는 기본적으로 활성화 되어 있는데 비활성화 처리 */
                csrf(AbstractHttpConfigurer::disable)
                /* rest api에서는 세션으로 로그인 상태 관리를 하지 않을 예정이므로 STATELESS 설정 */
                .sessionManagement(sessionManage -> sessionManage.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                /* formLogin 비활성화 처리 */
                .formLogin(AbstractHttpConfigurer::disable)
                /* 요청에 대한 권한 체크 */
                .authorizeHttpRequests(auth -> {
                    /* 클라이언트가 외부 도메인을 요청하는 경우 웹 브라우저에서 자체적으로 사전 요청(preflight)이 일어난다.
                    * 이 때 OPTIONS 메소드로 서버에 사전 요청을 보내 확인한다. */
                    auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/productimgs/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/api/v1/products/**").permitAll();
                    auth.requestMatchers(HttpMethod.POST, "/api/v1/members/signup", "/api/v1/members/login").permitAll();
                    auth.requestMatchers("/api/v1/products/*/reviews/**").authenticated();
                    auth.requestMatchers("/api/v1/products-management/**", "/api/v1/products/**").hasRole("ADMIN");
                    auth.anyRequest().authenticated();
                })
                /* 기본적으로 동작하는 로그인 필터 이전에 커스텀 로그인 필터를 설정한다. */
                .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                /* 모든 요청에 대해서 토큰을 확인하는 필터 설정 */
                .addFilterBefore(jwtAuthenticationFilter(), BasicAuthenticationFilter.class)
                .exceptionHandling(exceptionHandling -> {
                    exceptionHandling.accessDeniedHandler(jwtAccessDeniedHandler());
                    exceptionHandling.authenticationEntryPoint(jwtAuthenticationEntryPoint());
                })
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .build();
    }

    /* CORS (Cross Origin Resource Sharing) : 교차 출처 자원 공유
    * 보안 상 웹 브라우저는 다른 도메인에서 서버의 자원을 요청하는 것을 막아 놓았음.
    * 기본적으로 서버에서 클라이언트를 대상으로 리소스 허용 여부를 결정함. */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE"));
        corsConfiguration.setAllowedHeaders(Arrays.asList(
                "Access-Control-Allow-Origin", "Access-Control-Allow-Headers",
                "Content-Type", "Authorization", "X-Requested-With", "Access-Token", "Refresh-Token"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Access-Token", "Refresh-Token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(authService);
        return new ProviderManager(provider);
    }

    /* 로그인 실패 핸들러 빈 등록 */
    @Bean
    LoginFailureHandler loginFailureHandler() {
        return new LoginFailureHandler();
    }

    /* 로그인 성공 핸들러 빈 등록 */
    @Bean
    LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler(authService);
    }

    /* 로그인 시 동작할 CustomFilter Bean 등록 */
    @Bean
     CustomAuthenticationFilter customAuthenticationFilter() {

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter();
        /* AuthenticationManager 설정 */
        customAuthenticationFilter.setAuthenticationManager(authenticationManager());
        /* Login Fail Handler 설정 */
        customAuthenticationFilter.setAuthenticationFailureHandler(loginFailureHandler());
        /* Login Success Handler 설정 */
        customAuthenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler());

        return customAuthenticationFilter;
    }

    /* JWT Token 인증 필터 */
    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(authService);
    }

    /* 인증 실패 시 동작 핸들러 */
    @Bean
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint() {
        return new JwtAuthenticationEntryPoint();
    }

    /* 인가 실패 시 동작 핸들러 */
    @Bean
    JwtAccessDeniedHandler jwtAccessDeniedHandler() {
        return new JwtAccessDeniedHandler();
    }







}
