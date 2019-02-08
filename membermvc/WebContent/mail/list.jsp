<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto"%>
<%
String root = request.getContextPath();

MemberDto memberDto = (MemberDto)session.getAttribute("userInfo");
if(memberDto != null){
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		안녕하세요 <%=memberDto.getName()%>님 메일함!!<br>
		10.안녕하세요..홍길동<br>
		9.문의..철수<br>
		8.새해복..영희<br>
		<a href="<%=root%>/user?act=index">초기화면</a>
		<a href="<%=root%>/user?act=logout">로그아웃</a>
	</div>
</body>
</html>
<%
} else{
	response.sendRedirect(root + "/user?act=mvlogin");
}
%>