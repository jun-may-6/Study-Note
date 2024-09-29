package com.ohgiraffers.section01.contextListener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("context listener 확인용 서블릿");
        ServletContext context = request.getServletContext();

        /* context 에 attr 을 추가하면 attributeAdded() 메소드 동작 */
        context.setAttribute("test", "value");
        /* 동일한 key 로 context 에 attr 을 추가하면(수정하면) attributeReplaced() 메소드 동작*/
        context.setAttribute("test", "value2");
        /* context 에서 attr ㄹ르 제거하면 attributeRemoved() 메소드 동작*/
        context.removeAttribute("test");
    }
}
