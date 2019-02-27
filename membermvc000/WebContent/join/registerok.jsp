<%@page import="com.kitri.member.model.MemberDetailDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%
String root = request.getContextPath();
%>
<%
MemberDetailDto memberDetailDto = (MemberDetailDto)request.getAttribute("memberinfo");
if(memberDetailDto!=null){
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<strong><%=memberDetailDto.getName()%></strong>님 회원 가입을 환영합니다.<br>
아이디 : <%=memberDetailDto.getId()%> 이메일 : <%=memberDetailDto.getEmailId()%>@<%=memberDetailDto.getEmailDomain()%><br>
주소 :  <%=memberDetailDto.getZipCode()%> <%=memberDetailDto.getAddress()%> <%=memberDetailDto.getAddressDetail()%><br>
전화번호 : <%=memberDetailDto.getTel1()%>-<%=memberDetailDto.getTel2()%>-<%=memberDetailDto.getTel3()%><br>
"로그인 후 서비스를 이용할 수 있습니다.<br>
<a href="<%=root%>/login/login.jsp">로그인</a>
</body>
</html>
<%
}else{
%>
<script>
alert("잘못된 URL접근입니다.");
location.href = "<%=root%>/user";
</script>
<%
}
%>