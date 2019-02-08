<%@page import="com.kitri.member.model.MemberDetailDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.*"%>
<%

String root = request.getContextPath();

MemberDetailDto memberDetailDto = (MemberDetailDto) request.getAttribute("registerInfo");
if(memberDetailDto != null){

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<strong><%=memberDetailDto.getName() %></strong>님 회원가입을 환영합니다.
		가입 아이디는 <%=memberDetailDto.getId() %>이고 이메일은 <%=memberDetailDto.getEmailId()%>@<%=memberDetailDto.getEmailDomain()%>입니다<br>
		전화번호: <%=memberDetailDto.getTel1()%>-<%=memberDetailDto.getTel2()%>-<%=memberDetailDto.getTel3()%><br>
		로그인해주세요~<br>
		<a href="<%=root%>/login/login.jsp">로그인</a>
	</div>
</body>
</html>
<%
}else{
%>
<script>
alert("잘못된 URL접근입니다.")
location.href = "<%=root%>/user"
</script>
<%
}
%>	