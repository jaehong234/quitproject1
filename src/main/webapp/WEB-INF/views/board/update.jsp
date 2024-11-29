<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../part/header.jsp" %>

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