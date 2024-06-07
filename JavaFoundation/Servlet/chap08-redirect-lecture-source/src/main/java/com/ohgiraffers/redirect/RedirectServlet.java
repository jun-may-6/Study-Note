package com.ohgiraffers.redirect;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("서블릿으로 redirect 성공");
        System.out.println(response);

        StringBuilder redirectText = new StringBuilder();

        redirectText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>Redirect 성공!</h1>\n")
                .append("</body>\n")
                .append("</html>");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print(redirectText.toString());
        out.flush();
        out.close();
    }
}
