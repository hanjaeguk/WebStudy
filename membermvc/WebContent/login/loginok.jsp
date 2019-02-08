<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto"%>
<%
String root = request.getContextPath();

// MemberDto memberDto = (MemberDto)request.getAttribute("userInfo"); // rqeuset에 안하고 session에 했으니깐
 MemberDto memberDto = (MemberDto)session.getAttribute("userInfo");		// session으로 받아야함
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
		안녕하세요 <%=memberDto.getName()%>님!!<br>
		<%=memberDto.getName()%>님의 아이디는 <%=memberDto.getId()%>이고<br>
		이메일은 <%=memberDto.getEmailId()%>@<%=memberDto.getEmailDomain()%>입니다.<br>
		<a href="<%=root%>/user?act=mail">메일보기</a>
		<a href="<%=root%>/user?act=logout">로그아웃</a><br>
		<a href="<%=root%>/user?act=mvmodify">회원정보수정</a>
		<a href="<%=root%>/user?act=delete">회원탈퇴</a><br>
	</div>
</body>
</html>
<%
} else{
	response.sendRedirect(root + "/user?act=mvlogin");
}
%>