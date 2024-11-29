<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../part/header.jsp" %>

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