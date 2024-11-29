<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../part/header.jsp" %>

<div class="container">
<a href="/member/insert">입력</a>
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">아이디</th>
      <th scope="col">이름</th>
      <th scope="col">연락처</th>
      <th scope="col">수정일</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${responseList}" var="dto">
    <tr>
      <th scope="row"><a href="/member/read/${dto.userId}">${dto.userId}</a></th>
      <td>${dto.name}</td>
      <td>${dto.phoneNum}</td>
      <td>${dto.createDate}</td>
    </tr>
</c:forEach>
  </tbody>
</table>
</div>

</body>
</html>