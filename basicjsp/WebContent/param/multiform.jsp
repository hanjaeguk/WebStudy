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
		<h3>Servlet를 이용한 파라미터 전송.</h3>
		<form name = "testform" method = "GET" action = "/basicjsp/param/multiparam.jsp">
			<table>
				<tr>
					<td>이름</td>
					<td><input type = "text" name = "name"></td>			
				</tr>
				
				<tr>
					<td>연령</td>
					<td>
						<select name = "age">
							<option value = "10대">10대</option>
							<option value = "20대">20대</option>
							<option value = "30대">30대</option>
							<option value = "40대">40대</option>
							<option value = "50대">50대</option>
							<option value = "60대 이상">60대 이상</option>
						</select>
					</td>			
							
				</tr>
				
				<tr>
					<td colspan = "2" align = "center">
						좋아하는 과일
					</td>			
				</tr>
				
				<tr>
					<td colspan = "2" align = "center">
						<input type = "checkbox" name = "fruit" value = "사과">사과
						<input type = "checkbox" name = "fruit" value = "바나나">바나나
						<input type = "checkbox" name = "fruit" value = "딸기">딸기
						<input type = "checkbox" name = "fruit" value = "포도">포도
					</td>			
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