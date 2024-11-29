<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../part/header.jsp" %>

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