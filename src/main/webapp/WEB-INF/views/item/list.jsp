<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../part/header.jsp" %>

	<div class="container">

		<h2>상품 목록</h2>
		<hr>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">아이템 이름</th>
					<th scope="col">아이템 가격</th>
					<th scope="col">수정일</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<th scope="row"><a href="/item/read/${dto.itemId}">${dto.itemName}</a></th>
						<td>${dto.itemPrice}</td>
						<td>${dto.updateDate}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		
		<button class="btn btn-primary" type="button">상품등록</button>

	</div>
	
	
<script type="text/javascript">
$("button").click(function(){
	location.href="/item/insert"
});

</script>
</body>
</html>