<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../part/header.jsp" %>
<div class="container">

<form method="post" action="/item/update">
    <legend>아이템을 수정해주세요.</legend>
    <hr>
    <div class="mb-3">
      <label for="disabledTextInput" class="form-label">아이템 이름</label>
      <input name="itemName" type="text"  class="form-control" readonly="readonly" value="${itemResponse.itemName}">
    </div>
    
     <div class="mb-3">
      <label for="disabledTextInput" class="form-label">아이템 가격</label>
      <input name="itemPrice" type="text" class="form-control" value="${itemResponse.itemPrice}">
    </div>
    
     <div class="mb-3">
      <label for="disabledTextInput" class="form-label">아이템 설명</label>
      <input name="itemInfo" type="text" class="form-control" value="${itemResponse.itemInfo}">
    </div>
  
    <button type="submit" class="btn btn-primary">아이템 수정</button>
    <button id="item_update_out_btn" type="button" class="btn btn-primary">나가기</button>
    <input type="hidden" value="${itemResponse.itemId}" name="itemId">
 
</form>
</div>
<script src="/js/itemjs.js" type="text/javascript"></script>
</body>
</html>