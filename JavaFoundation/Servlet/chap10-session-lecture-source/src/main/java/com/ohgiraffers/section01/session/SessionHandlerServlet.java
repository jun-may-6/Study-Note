package com.ohgiraffers.section01.session;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        /* HttpSession 은 직접 생성할 수 없고  request 에 있는 getSession 메소드를 이용해 리턴 받는다. */
        HttpSession session = request.getSession();         // 세션 생성 (인터페이스기에 명시 필수, 브라우저당 하나씩 ID 가짐)

        /* 세션은 기본적으로 시간이 할당되어있으며 따로 설정도 할 수 있다. (30분) */
        System.out.println("session id : " + session.getId());
        System.out.println("session default interval : " + session.getMaxInactiveInterval());   // 기본 시간 (30분)

        session.setMaxInactiveInterval(60 * 10);            // 따로 설정도 가능
        System.out.println("session set interval : " + session.getMaxInactiveInterval());

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        response.sendRedirect("redirect");
    }
}
