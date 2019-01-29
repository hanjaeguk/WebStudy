<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="/memberservlet/css/style.css" type="text/css"> <!--"../css/style.css"-->
		<script type="text/javascript">
		function login() {
			var iderrorview = document.getElementById("idblack");
			var passerrorview = document.getElementById("passblack");
			//if(document.joinform.name.value == "") {
			if(document.getElementById("id").value.trim().length == 0) {
				iderrorview.innerHTML = "<font color='red'>아이디를 입력하세요</font>";
				iderrorview.style = "display:";
				passerrorview.style = "display:none";
				return;
			} else if(document.getElementById("pass").value.trim().length == 0) {
				passerrorview.innerHTML = "<font color='red'>비밀번호를 입력하세요</font>";
				passerrorview.style = "display:";
				iderrorview.style = "display:none";
				return;
			} else {
				document.getElementById("loginform").setAttribute("action", "/memberjsp/login/loginprocess.jsp");
				document.getElementById("loginform").submit();
			}
		}
			
		function mvjoin(){
			location.href = "/memberjsp/join/member.jsp"
		}

		</script>
	</head>

	<body>
	<div class="testbox box2">
		<h1>로그인</h1>
		<form name="loginform" id="loginform" method="post" action="">
		<hr>	
		<div class="accounttype" align="left">
		로그인<br>
		<input type="text" name="id" id="id" value="" size="12" placeholder="ID"  required/>
		<div id = "idblack" style = "display: none"></div>
		<input type="password" name="pass" id="pass" size="12" maxlength="12" placeholder="Password"  required/>
		<div id = "passblack" style = "display: none"></div>
	    <br>
	    <input type="button" value="로그인" class="button" onclick="javascript:login();"/>&nbsp;&nbsp;
	    <input type="button" value="회원가입" class="button" onclick = "javascript:mvjoin();"/>
	    </div>
		</form>  
	</div>
	</body>
</html>