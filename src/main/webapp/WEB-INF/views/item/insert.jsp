<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
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
  
    <button type="submit" class="btn btn-primary">아이템 등록</button>
    <button id="item_insert_list_btn" type="button" class="btn btn-primary">아이템 목록</button>
 
</form:form>

<script type="text/javascript">
$("#item_insert_list_btn").click(function(){
	location.href = "/item/list";
});

</script>
</div>
</body>
</html>