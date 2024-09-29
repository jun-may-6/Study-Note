package com.ohgiraffers.section02.annotation;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/* loadOnStartUp 속성으로 우선순위를 지정할 수 있으며 (숫자가 낮을수록 우선순위 높음)
* 서버가 start 될 때 인스턴스를 생성하고 init()을 호출하기도 한다. */
@WebServlet(value = "/annotation-lifecycle", loadOnStartup = 1)        // index 와 같게 작성
public class LifeCycleTestServlet extends HttpServlet {


    /* 각 메소드 호출 횟수 카운트 필드 */
    int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    public LifeCycleTestServlet() {
    }

    @Override
    public void init() throws ServletException {
        /* 서블릿 컨테이너에 의해 호출되며 최초 요청시에만 실행하고 두 번째 요청부터는 호출하지 않는다. */
        System.out.println("annotation 매핑 init() 메소드 호출 : " + initCount++);
    }

    /* 최초 요청 시에는 init() 이후에 동작하고,
     * 두 번째 요청부터는 init() 호출 없이 바로 service() 를 호출한다. */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("annotation 매핑 service() 메소드 호출 : " + serviceCount++);
    }

    /* 컨테이너가 종료될 때 호출되는 메소드이며 주로 자원을 반납하는 용도로 사용한다. */
    @Override
    public void destroy() {
        System.out.println("annotation 매핑 destroy() 메소드 호출 : " + destroyCount++);
    }
}
