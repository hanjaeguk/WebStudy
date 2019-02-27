<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.*"%>
<%
String root = request.getContextPath();

MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
if(memberDto!=null){	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div align="center">
<strong><%=memberDto.getName()%></strong>(<a href="mailto:<%=memberDto.getEmailId()%>@<%=memberDto.getEmailDomain()%>"><%=memberDto.getId()%></a>)님 안녕하세요!<br>
<a href="<%=root%>/user?act=mail">메일보기</a><br>
<a href="<%=root%>/user?act=logout">로그아웃</a><br>
<a href="<%=root%>/user?act=mvmodify">회원정보수정</a><br>
<a href="<%=root%>/user?act=delete">회원탈퇴</a><br>
</div>

</body>
</html>

<%
}else{
	response.sendRedirect(root+"/user?act=mvlogin");
}
%>
