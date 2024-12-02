<%@page import="kr.co.mbc.entity.AttachEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="part/header.jsp" %>

<c:forEach items="${attachList}" var="dto">
	
	<div>
	
		<a href="/item/list"><img src="/item/download?fullFilename=${dto.filename}" width="300" height="300"></a>
		${dto.filename}
	
	</div>

</c:forEach>

<script type="text/javascript">


</script>
</body>
</html>