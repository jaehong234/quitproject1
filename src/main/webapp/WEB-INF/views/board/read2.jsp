<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	type="text/javascript"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>
	
	<div class="container">
		<input type="hidden" name="id" value="${boardResponse.id}">
		<table class="table table-bordered">
			<tr>
				<td>제목</td>
				<td>${boardResponse.title}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${boardResponse.content}</td>
			</tr>

			<tr>
				<td>createDate</td>
				<td>${boardResponse.createDate}</td>
			</tr>
			<tr>
				<td>updateDate</td>
				<td>${boardResponse.updateDate}</td>
			</tr>

		</table>
		<a href="/board/list">목록</a>
		<a href="/board/update/${boardResponse.id}">수정</a>
		<button type="button" id="board_delete_btn">삭제</button>

		<h2>댓글</h2>
		<div id="reply_tag">
			
			<div>
				<input name="replyContent">
				<button id="reply_btn" type="button">댓글입력</button>
			</div>
			
			<div id="reply_list_tag">
				<table class="table table-bordered">
					
				</table>
			</div>
			

		</div>
	</div>
	
	
	
<script src="/js/test2.js" type="text/javascript"></script>
</body>
</html>