<%@ page import="com.ohgiraffers.menu.controller.MenuOrderServlet" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2024-03-21
  Time: 오후 12:02
  To change this template use File | Settings | File Templates.
--%>
<!--지시자 태그-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- HTML 주석(페이지 소스에 남아있음) -->
<%-- JSP 주석(페이지 소스에선 안보임) --%>

<!-- 선언 태그 -->
<%!
    private String name;
    private int age;
%>
<!-- scriptlet 태그 -->
<%
    // 자바 주석과 동일하다
    name = "판다";
    age = 20;

    System.out.println("name : " + name);
    System.out.println("age : " + age);

    for(int i = 0 ; i < name.length() ; i++){   // 간단한 로직 작성 가능
        System.out.println(name.charAt(i));
    }
%>

<!-- expression 태그 -->
<!-- PrintWriter 를 이용하여 브라우저에 값을 내보내 브라우저에서 보여지게 한다. -->
name : <%= name%><br>
age : <%= age%><br>

</body>
</html>
