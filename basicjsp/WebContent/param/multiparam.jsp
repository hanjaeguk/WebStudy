<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("name");
String age = request.getParameter("age");
String[] fruit = request.getParameterValues("fruit");
String color = "blue";
	if(age.equals("10대")) {
	color = "red";
	}
%>
	<div>
	<%=name%>(<font color = <%=color%>><%=age%></font>)님이 좋아하는 과일은
	<%
		if(fruit != null) {
			out.print(fruit[0]);
				for(int i = 1; i < fruit.length;i++) {
					out.print(", "+fruit[i]);
				}
				out.println("입니다.");	
		}else {
			out.println("없습니다.");	

		}
	%>
	</div>
</body>
</html>