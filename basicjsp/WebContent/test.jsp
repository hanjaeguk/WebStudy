<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="간단 테스트입니다."
    import="java.util.Random"
    import="java.io.*,java.sql.*"
%>
<!-- 이 페이지는jsp의 기본 script 연습용 파일입니다.(html주석이 보임!)  -->
<%-- 이 페이지는jsp의 기본 script 연습용 파일입니다.(jsp주석은 안보임!) --%>
<%-- 자바는 /**/이걸로 사용할수 있다. --%>
<%!
String name;
Random ra;
InputStream in;
Connection conn;

public void init(){
	name = "Kitri";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	당신의 이름은<% out.println(name);%>입니다.<br>
	당신의 이름은<%= name%>입니다.<br>
	
<%
ServletContext sc = config.getServletContext();
System.out.println("1"+sc.getRealPath("/"));
System.out.println("1"+application.getRealPath("/"));
%>
</body>
</html>