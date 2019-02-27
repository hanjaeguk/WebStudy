<%@page import="com.kitri.member.model.MemberDetailDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String root = request.getContextPath();
MemberDetailDto memberDetailDto = (MemberDetailDto)session.getAttribute("memberDetailDto");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
정보 수정 완료
</body>
</html>