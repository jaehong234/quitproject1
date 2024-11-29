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

<form:form method="post" action="/board/update">

<div>
	<h2>수정화면</h2>
	<hr>
</div>

<div class="mb-3">
	<label class="form-label"> 작성자</label> <br>
	<input class="form-label" readonly="readonly" name="writer" value="${boardResponse.writer}">
</div>

<div class="mb-3">
	<label class="form-label"> 제목</label><br>
	<input class="form-label" name="title" value="${boardResponse.title}">
</div>

<div class="mb-3">
	<label class="form-label"> 내용</label><br>
	<input class="form-label" name="content" value="${boardResponse.content}">
</div>

<input name="id" value="${boardResponse.id}" type="hidden">
<button>수정완료</button>

</form:form>

</div>
</body>
</html>