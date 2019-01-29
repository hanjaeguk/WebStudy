<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
String id = request.getParameter("id");
String emailid = request.getParameter("emailid");
String emaildomain = request.getParameter("emaildomain");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<strong><%=name %></strong>님 회원가입을 환영합니다.
		가입 아이디는 <%=id %>이고 이메일은 <%=emailid%>@<%=emaildomain%>입니다<br>
		로그인해주세요~<br>
		<a href="/memberjsp/login/login.jsp">로그인</a>
	</div>
</body>
</html>