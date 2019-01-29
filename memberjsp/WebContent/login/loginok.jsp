<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
String name = request.getParameter("name");
String id = request.getParameter("id");
String emailid = request.getParameter("emailid");
String emaildomain = request.getParameter("emaildomain");
%>
<body>
	<div align="center">
		안녕하세요 <%=name%>님!!<br>
		<%=name%>님의 아이디는 <%=id%>이고<br>
		이메일은 <%=emailid%>@<%=emaildomain%>입니다.
	</div>
</body>
</html>