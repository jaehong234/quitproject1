<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../part/header.jsp" %>
<div class="container">

<form:form method="post" enctype="multipart/form-data" modelAttribute="itemDto">
    <legend>아이템을 입력해주세요.</legend>
    <hr>
    <div class="mb-3">
      <label for="disabledTextInput" class="form-label">아이템 이름</label>
      <input name="itemName" type="text"  class="form-control" >
      <form:errors path="itemName"></form:errors>
    </div>
    
     <div class="mb-3">
      <label for="disabledTextInput" class="form-label">아이템 가격</label>
      <input name="itemPrice" type="text" class="form-control">
      <form:errors path="itemPrice"></form:errors>
    </div>
    
     <div class="mb-3">
      <label for="disabledTextInput" class="form-label">아이템 설명</label>
      <input name="itemInfo" type="text" class="form-control">
      <form:errors path="itemInfo"></form:errors>
    </div>

	<div id="filelist">
	
	</div>
  	
  	<input type="file" name="quitfile"><br>
  	<hr>
  	
    <button type="submit" class="btn btn-primary">아이템 등록</button>
    <button id="item_insert_list_btn" type="button" class="btn btn-primary">아이템 목록</button>
 
</form:form>

<script src="/js/itemjs.js" type="text/javascript"></script>
<script type="text/javascript">
</script>
</div>
</body>
</html>