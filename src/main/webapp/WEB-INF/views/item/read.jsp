<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

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

		<h2>아이템 상세 페이지</h2>
		<hr>
		<div class="card">
			<div class="card-body">아이템 이름 : ${itemResponse.itemName}</div>
		</div>

		<div class="card">
			<div class="card-body">아이템 가격 : ${itemResponse.itemPrice}</div>
		</div>

		<div class="card">
			<div class="card-body">아이템 설명 : ${itemResponse.itemInfo}</div>
		</div>

		<div class="card">
			<div class="card-body">아이템 생성일 : ${itemResponse.createDate}</div>
		</div>

		<div class="card">
			<div class="card-body">아이템 수정일 : ${itemResponse.updateDate}</div>
		</div>
		
		<button class="btn btn-primary" id="item_list_btn">목록</button>
		<button class="btn btn-primary" id="item_update_btn">수정</button>
		
		<form id="hidden_form" method="post" action="/item/delete">
		<button type="button" class="btn btn-primary" id="item_delete_btn">삭제</button>
		<input type="hidden" name="itemId" value="${itemResponse.itemId}">
		</form>

	</div>
	
<script type="text/javascript">

$("#item_delete_btn").click(function(){
	let isOk = confirm("정말 삭제하시겠습니까?");
	if(isOk) {
		$("#hidden_form").submit();
	}
});

$("#item_update_btn").click(function(){
	location.href = "/item/update/${itemResponse.itemId}";
});

$("#item_list_btn").click(function(){
	location.href = "/item/list";
});

</script>
</body>
</html>