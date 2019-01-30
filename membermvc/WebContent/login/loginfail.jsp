<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<font color="red">아이디와 비밀번호를 확인해 주세요.</font><br>
		<a href="<%=root%>/login/login.jsp">로그인</a>
	</div>
</body>
</html>