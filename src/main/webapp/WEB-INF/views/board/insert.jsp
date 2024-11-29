<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../part/header.jsp" %>
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