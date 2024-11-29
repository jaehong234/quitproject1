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
		<button>
			<a href="/board/list">목록</a>
		</button>
		<button>
			<a href="/board/update/${boardResponse.id}">수정</a>
		</button>
		<form action="/board/delete" method="post">
			<button type="button" id="board_delete_btn">삭제</button>
			<input type="hidden" value="${boardResponse.id}" name="id">
		</form>


		<div id="reply_tag">
			<h2>댓글</h2>
			<hr>
			<div>
				<input name="replyContent">
				<button id="reply_btn" type="button">댓글입력</button>
			</div>
			
			<div>
				<div id="reply_list_tag"></div>
			</div>


		</div>
	</div>
	
	
	
<script src="/js/test.js" type="text/javascript"></script>
<script type="text/javascript">

getReplyList();

$("#reply_list_tag").on("click", "button[class='reply_delete_btn']", function(){
	let btn = $(this).text();
	let replyId = $(this).attr("reply-id-data");
	
	$.ajax({
		
		url : "/replies/",
		type : "delete",
		dataType : "text",
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "DELETE"
		},
		data : JSON.stringify({
			id : replyId
		}),
		success : function(result){
			alert(result);
		}
		
		
		
	});
	
	
	
	
});

function getReplyList() {
	let id = $("input[type='hidden']").val();
	$.ajax({
		url: "/replies/" + id,
		type: "get",
		dataType: "text",
		headers: {
			"Content-Type": "application/json",
			"X-HTTP-Method-Override": "GET"
		},
		success: function(result) {
			let obj = JSON.parse(result);
			let tags = addReplyTag(obj);
			$("#reply_list_tag").html(tags);

		}
	});
}


$("#reply_btn").click(function() {
	
	let $content = $("input[name='replyContent']").val();
	
	let $readId = $("input[type='hidden']").val();
	
	
	$.ajax({

		url: "/replies/",
		type: "post",
		dataType: "text",
		headers: {
			"Content-Type": "application/json",
			"X-HTTP-Method-Override": "POST"
		},
		data: JSON.stringify({
			content: $content,
			readId: $readId
		}),
		success: function() {
			getReplyList();
		}

	});

});

$("#board_delete_btn").click(function() {
	let isOk = confirm("정말 삭제할꺼야?");

	if (isOk) {
		$("form").submit();
	}
});

</script>
</body>
</html>