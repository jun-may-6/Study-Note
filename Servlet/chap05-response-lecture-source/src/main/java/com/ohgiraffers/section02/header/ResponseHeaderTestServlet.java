package com.ohgiraffers.section02.header;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

@WebServlet("/headers")
public class ResponseHeaderTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
//        response.setHeader("Refresh", "1");     // 1초마다 갱신

        PrintWriter out = response.getWriter();

        long currentTime = System.currentTimeMillis();     // 현재 시간을 초로 알려주는 메소드

        out.print("<h1>" + currentTime + "</h1>");

        out.close();

        Collection<String> responseHeader = response.getHeaderNames();
        Iterator<String> iter = responseHeader.iterator();
        while (iter.hasNext()){
            String headerName = iter.next();
            System.out.println(headerName + " : " + response.getHeader(headerName));
        }
    }

}
