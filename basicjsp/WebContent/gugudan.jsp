<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div align="center">
		<h3>***구구단***</h3>
		<table border = 1>
			<%
				for(int dan=2; dan<10; dan++){
					String color = dan%2 == 0 ? "pink" : "cyan";
			%>
				<tr>
			<%
					for(int i=1; i<10; i++){
			%>
					<td bgcolor=<%out.print(color);%>> 
						<% out.print(dan+"*"+i+"="+dan*i); %>
					</td>
			<%
					}
				}
			%>
				</tr>
		</table>
	</div>
	
	<div align="center">
	<h3>***구구단***</h3>
		<table border = 1>
			<%
				for(int dan=2; dan<10; dan++){
				String color = dan%2 == 0 ? "pink" : "cyan";
				out.println("<tr>");
					for(int i=1; i<10; i++){
						out.println("<td bgcolor="+color+">"+dan+"*"+i+"="+dan*i+"</td>");
					}
				out.println("</tr>");
				}
			%>
				</tr>
		</table>
	</div>

	<div align="center">
		<h3>***구구단***</h3>
		<table border = 1>
			<%
				for(int dan=2; dan<10; dan++){
					String color = dan%2 == 0 ? "pink" : "cyan";
			%>
				<tr>
			<%
					for(int i=1; i<10; i++){
			%>
					<td bgcolor=<%=color%>> 
						<%=dan%>*<%=i%>=<%=dan*i%>
					</td>
			<%
					}
				}
			%>
				</tr>
		</table>

</body>
</html>