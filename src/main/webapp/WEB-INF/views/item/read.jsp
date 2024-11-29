<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../part/header.jsp" %>
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