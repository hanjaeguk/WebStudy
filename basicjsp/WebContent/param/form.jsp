<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<h3>JSP를 이용한 파라미터 전송.</h3>
		<form name = "testform" method = "GET" action = "/basicjsp/param/param.jsp">
			<table>
				<tr>
					<td>이름</td>
					<td><input type = "text" name = "name"></td>			
				</tr>
				
				<tr>
					<td>성별</td>
					<td><input type = "radio" name = "gender" value ="남">남자</td>			
					<td><input type = "radio" name = "gender" value = "여">여자</td>			
				</tr>
				
				<tr>
					<td colspan = "2" align = "center">
						<input type = "submit" value = "전송">
					</td>			
				</tr>
				
				
			</table>
		</form>
	</div>
</body>
</html>