<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2024-03-21
  Time: 오후 12:47
  To change this template use File | Settings | File Templates.
--%>
<%--지시자 태그에 isErrorPage true로 설정(기본적으로 false)--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String exceptionType = exception.getClass().getName();
        String exceptionMessage = exception.getMessage();
    %>
    <h1><%=exceptionType%></h1>
    <h3><%=exceptionMessage%></h3>
</body>
</html>
