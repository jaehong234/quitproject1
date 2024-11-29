<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../part/header.jsp" %><body>
	
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