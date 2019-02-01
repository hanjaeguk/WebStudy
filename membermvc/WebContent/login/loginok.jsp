<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto"%>
<%
String root = request.getContextPath();

MemberDto memberDto = (MemberDto)request.getAttribute("userInfo");
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
		이메일은 <%=memberDto.getEmailId()%>@<%=memberDto.getEmailDomain()%>입니다.
	</div>
</body>
</html>
<%
} else{
	response.sendRedirect(root + "/user?act=mvlogin");
}
%>