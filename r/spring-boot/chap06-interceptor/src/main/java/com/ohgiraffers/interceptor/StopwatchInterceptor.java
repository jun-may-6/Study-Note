package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class StopwatchInterceptor implements HandlerInterceptor {
    private final MenuService menuService;
    /* @Autowired 생략되고 있음 */
    public StopwatchInterceptor(MenuService menuService) {
        this.menuService = menuService;
    }

    /* 전처리 메소드 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler 호출됨");

        long startTime = System.currentTimeMillis();

        request.setAttribute("startTime", startTime);

        return true;
    }

    /* 후처리 메소드 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler 호출됨");

        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();

        modelAndView.addObject("interval", endTime-startTime);

    }

    /* 렌더링 이후 동작하는 메소드 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 호출됨");
        menuService.method();
    }
}
