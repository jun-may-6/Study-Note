package com.ohgiraffers.session02.delete;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        /* 세션에 담긴 모든 Attribute 키 목록 반환 */
        Enumeration<String> sessionNames = session.getAttributeNames();
        /* 출력 */
        while (sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }

        /* [세션 데이터를 지우는 방법]
        * 1. 설정한 만료 시간이 지나면 자동 만료
        * 2. removeAttribute() 로 세션의 attribute 를 지운다
        * 3. invalidate() 를 호출하면 ㅅ션의 모든 데이터가 제거된다.
        * */

        System.out.println("=============================================");
        /* remove */
        session.removeAttribute("firstName");
        /* remove 이후 출력 */
        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }

        System.out.println("=============================================");

        session.invalidate();       // 세션 자체 무효화 (종료)

        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }
    }
}
