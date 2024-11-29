<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../part/header.jsp" %>

<div class="container">

<form:form method="post" action="/member/update">

<div>
	<h2>수정화면</h2>
	<hr>
</div>

<div class="mb-3">
	<label class="form-label"> 아이디</label> <br>
	<input class="form-label" readonly="readonly" name="userId" value="${mres.userId}">
</div>

<div class="mb-3">
	<label class="form-label"> 이름</label><br>
	<input class="form-label" name="name" value="${mres.name}">
</div>

<div class="mb-3">
	<label class="form-label"> 연락처</label><br>
	<input class="form-label" name="phoneNum" value="${mres.phoneNum}">
</div>

<div class="mb-3">
	<label class="form-label"> 이메일</label><br>
	<input class="form-label" type="email" name="email" value="${mres.email}">
</div>

<div class="mb-3">
	<label class="form-label"> 주소</label><br>
	<input class="form-label" name="address" value="${mres.address}">
</div>

<button>수정완료</button>

</form:form>

</div>
</body>
</html>