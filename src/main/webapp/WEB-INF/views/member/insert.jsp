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

<form:form method="post" enctype="multipart/form-data" modelAttribute="memberDTO">

<div>
	<h2>회원가입</h2>
	<hr>
</div>

<div class="mb-3">
	<label class="form-label"> 아이디</label> <br>
	<input class="form-label" name="userId"><button type="button" id="insert_checkId_btn">중복검사</button>
	<div id="checkId_message"></div>
	<form:errors path="userId"></form:errors>
</div>

<div class="mb-3">
	<label class="form-label"> 비밀번호</label><br>
	<input class="form-label" type="password" name="pass">
	<form:errors path="pass"></form:errors>
</div>

<div class="mb-3">
	<label class="form-label"> 비밀번호확인</label><br>
	<input class="form-label" type="password" name="pass2">
	<form:errors path="pass2"></form:errors>
</div>

<div class="mb-3">
	<label class="form-label"> 이름</label><br>
	<input class="form-label" name="name">
	<form:errors path="name"></form:errors>
</div>

<div class="mb-3">
	<label class="form-label"> 연락처</label><br>
	<input class="form-label" name="phoneNum">
	<form:errors path="phoneNum"></form:errors>
</div>

<div class="mb-3">
	<label class="form-label"> 이메일</label><br>
	<input class="form-label" type="email" name="email">
</div>

<div class="mb-3">
	<label class="form-label"> 주소</label><br>
	<input class="form-label" name="address">
</div>

<div class="mb-3">
	<label class="form-label"> 성별</label><br>
	<input class="form-label" name="gender">
</div>

<button>회원가입</button>

</form:form>
<button id="insert_list_btn">목록</button>

</div>


<script type="text/javascript">

$("#insert_checkId_btn").click(function(){
	$.ajax({
		
		url : "/member/checkId",
		type : "post",
		dataType : "text",
		data : {
			userId : $("input[name='userId']").val()
		},
		success : function(result){
			if(result=="ok") {
				$("#checkId_message").html("<div>사용가능합니다.</div>");
			}else{
			$("#checkId_message").html("<div>사용불가합니다.</div>");
			}
		}
		
	});
});

$("#insert_list_btn").click(function(){
	location.href= "/member/list";
});

</script>
</body>
</html>