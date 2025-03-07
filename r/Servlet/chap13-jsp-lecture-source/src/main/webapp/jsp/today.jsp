<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2024-03-21
  Time: 오후 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy 년 MM 월 dd 일 E 요일 a hh 시 mm 분ss 초");        //
        String output = sdf.format(today);
    %>
    <h3><%=output%></h3>
</body>
</html>
