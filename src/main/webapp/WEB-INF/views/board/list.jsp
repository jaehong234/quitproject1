<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../part/header.jsp" %>
<div class="container">
<a href="/board/insert">입력</a>
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">작성자</th>
      <th scope="col">제목</th>
      <th scope="col">생성일</th>
      <th scope="col">수정일</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${responseList}" var="dto">
    <tr>
      <th><a href="/board/read/${dto.id}">${dto.writer}</a></th>
      <td>${dto.title}</td>
      <td>${dto.createDate}</td>
      <td>${dto.updateDate}</td>
    </tr>
</c:forEach>
  </tbody>
</table>
</div>

</body>
</html>