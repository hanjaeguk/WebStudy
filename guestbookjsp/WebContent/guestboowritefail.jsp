<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	function writer(){
		if(document.getElementById("name").value.trim().length == 0) {
			alert("이름을 입력하세요")
			return;
		} else if(document.getElementById("subject").value.trim().length == 0) {
			alert("제목을 입력하세요")
			return;
		} else if(document.getElementById("content").value.trim().length == 0) {
			alert("내용을 입력하세요")
			return;
		} else {
			document.getElementById("writeform").setAttribute("action", "/guestbookservlet/write");
			document.getElementById("writeform").submit();
		}
	}
	</script>
</head>
<body>
	<form name ="writeform" id = "writeform" method="post" action="">
		<div class="container">
			<div class="col-lg-7">      
			
				<table class="table" >
					<tr>
						<td colspan="2" align="center"><h2>*글쓰기*</h2></td>
					</tr>
					
					<tr>
						<td>작성자: </td>
						<td><input type="text" size="10" name="name" id="name" placeholder="이름입력"></td>
					</tr>
					
					<tr>
						<td>제목: </td>
						<td><input type="text" size="20" name="subject" id="subject" placeholder="제목입력"></td>
					</tr>
					
					<tr>
						<td>내용:</td> 			
						<td><textarea cols="65" rows="15" name="content" id="content" placeholder="내용입력"></textarea></td>
					</tr>
					
					<tr>
						<td colspan="2" align="right">
							<input type="button" value="글쓰기" class="btn" onclick="javascript:writer();">
							<input type="reset" value="초기화" class="btn">
							<input type="button" value="뒤로" class="btn" onclick="location.href='/guestbookservlet/index.html'">
						</td>
					</tr>
					
				</table>
			</div>  
		</div>
	</form>
</body>
</html>