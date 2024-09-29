<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Filter & Wrapper</title>
</head>
<body>
<h1>Filter</h1>

  <h3>Filter Lifecycle</h3>
  <a href="first/filter">Filter 사용하기</a>
  <hr>
  <h3>Filter 활용</h3>
<form action="member/regist" method="post">
  <label>ID : </label>
  <input type="text" name="userId">
  <br>
  <label>P/W : </label>
  <input type="password" name="password">
  <br>
  <label>이름 : </label>
  <input type="text" name="name">
  <br>
  <button type="submit">join</button>
</form>

</body>
</html>