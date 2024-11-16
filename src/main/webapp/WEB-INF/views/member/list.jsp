<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">아이디</th>
      <th scope="col">이름</th>
      <th scope="col">연락처</th>
      <th scope="col">수정일</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="dto">
    <tr>
      <th scope="row"><a href="/member/read/${dto.userId}">${dto.userId}</a></th>
      <td>${dto.name}</td>
      <td>${dto.phoneNum}</td>
      <td>${dto.createDate}</td>
    </tr>
</c:forEach>
  </tbody>
</table>
</div>

</body>
</html>