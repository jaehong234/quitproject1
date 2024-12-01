<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../part/header.jsp" %>

	<div class="container">
		<h2>아이템 상세 페이지</h2>
		<hr>
	</div>
	
	<div class="container" style="display: flex; align-items: center;">
		<hr>
		<div style="flex: 0 0 auto; margin-right: 20px;">
			<img src="/upload/${filename}">
		</div>
		
		<div style="flex: 1;">
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
				<input id="hidden_itemId" type="hidden" name="itemId" value="${itemResponse.itemId}">
			</form>
		</div>
	</div>

<script src="/js/itemjs.js" type="text/javascript"></script>
<script type="text/javascript">
</script>
</body>
</html>