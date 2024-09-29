package com.ohgiraffers.cookie;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        response.sendRedirect("redirect");
        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        /*
        * 쿠키 사용법
        * 1. 쿠키 생성
        * 2. 생성한 쿠키의 만료 시간 설정
        * 3. 응답 헤더에 쿠키 할당
        * 4. 응답 보내기
        *
        * 쿠키 제약 사항
        * 이름은 아스키 문자만을 사용해야 하며 한 번 설정한 이름은 변경할 수 없다.
        * 이름에 공백 문자와 일부 특수 문자([] () , " \ ? @ : ;) 사용 불가
        * */

        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        firstNameCookie.setMaxAge(60 * 60 * 24);        // 초 단위로 만료 시간 설정
        lastNameCookie.setMaxAge(60 * 60 * 24);

        response.addCookie(firstNameCookie);        // response 에 쿠키 할당
        response.addCookie(lastNameCookie);
    }
}
