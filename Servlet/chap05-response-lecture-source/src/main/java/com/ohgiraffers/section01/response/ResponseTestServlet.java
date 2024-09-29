package com.ohgiraffers.section01.response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 서블릿이 하는 역할 3가지
        * 1. 요청 받기 - HTTP method GET/POST 요청에 따라 parameter 로 전달 받은 데이터를 꺼내올 수 있다.
        * 2. 비지니스 로직 처리 - DB 접속과 CRUD 에 대한 로직 처리
        * 3. 응답 하기 - 문자열로 동적인 웹(HTML 태그) 페이지를 만들고 스트림을 이용해 내보낸다.
        * */


        PrintWriter out = response.getWriter();         // 스트림

        /* 문자열을 이용해 사용자에게 내보낼 페이지 작성 */
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>안녕 servlet response</h1>\n")
                .append("</body>\n")
                .append("</html>");
        /* content-type 헤더의 값은 null 이 기본 값이며 명시하지 않으면 text/plain 으로 설정한다. */
        System.out.println("default response type : " + response.getContentType());     // null

//        response.setContentType("text/plain");
//        System.out.println("setContentType : " + response.getContentType());        // text/plain;charset=UTF-8

        response.setContentType("text/html");       // 버전이 올라가며 html 만 명시해줘도 인코딩이 된다.

        /* 스트림을 이용해 내보내기 */
        out.print(responseBuilder.toString());
        /* 버퍼에 잔류한 데이터 내보내기 */
        out.flush();
        /* 스트림 닫기 */
        out.close();

    }
}
