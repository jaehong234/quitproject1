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

<form:form method="post">
    <legend>게시글 작성</legend>
    <hr>
    <div class="mb-3">
      <label for="disabledTextInput" class="form-label">게시글 제목</label>
      <input name="title" type="text"  class="form-control" >
    </div>
    
     <div class="mb-3">
      <label for="disabledTextInput" class="form-label">작성자</label>
      <input name="member" type="text" class="form-control">
    </div>
    
     <div class="mb-3">
      <label for="disabledTextInput" class="form-label">내용</label><br>
      <textarea rows="10" cols="10" class="form-control" name="content"></textarea>
    </div>
  
    <button type="submit" class="btn btn-primary">게시글 등록</button>
    <button id="board_insert_list_btn" type="button" class="btn btn-primary">게시글 목록</button>
 
</form:form>

<script type="text/javascript">
$("#board_insert_list_btn").click(function(){
	location.href = "/board/list";
});

</script>
</div>
</body>
</html>