<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<table class="table table-bordered">
			<tr>
				<td>userId</td>
				<td>${memberResponse.userId}</td>
			</tr>
			<tr>
				<td>name</td>
				<td>${memberResponse.name}</td>
			</tr>
		
			<tr>
				<td>phoneNum</td>
				<td>${memberResponse.phoneNum}</td>
			</tr>
			<tr>
				<td>address</td>
				<td>${memberResponse.address}</td>
			</tr>
			<tr>
				<td>gender</td>
				<td>${memberResponse.gender}</td>
			</tr>
			<tr>
				<td>createDate</td>
				<td>${memberResponse.createDate}</td>
			</tr>
			<tr>
				<td>updateDate</td>
				<td>${memberResponse.updateDate}</td>
			</tr>

		</table>
		<button><a href="/member/list">목록</a></button>
		<button><a href="/member/update/${memberResponse.userId}">수정</a></button>
		<form action="/member/delete" method="post">
		<button type="button" id="member_delete_btn">삭제</button>
		<input type="hidden" value="${memberResponse.userId}" name="userId">
		</form>
	</div>







<script type="text/javascript">
$("#member_delete_btn").click(function(){
	let isOk = confirm("정말 삭제할꺼야?");
	
	if(isOk){
		$("form").submit();
	}
});
</script>
</body>
</html>