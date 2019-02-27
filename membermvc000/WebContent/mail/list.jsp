<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.*"%>
<%
String root = request.getContextPath();

MemberDto memberDto = (MemberDto)session.getAttribute("userInfo");
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
<strong><%=memberDto.getName()%></strong>님 메일목록<br>
10. 안녕하세요..홍길동<br>
10. 반가워요~..홍길동<br>
10. 잘있어요~..홍길동<br>
10. 다시만나요~..홍길동<br>
</div>

</body>
</html>

<%
}else{
	response.sendRedirect(root+"/user?act=mvlogin");
}
%>








