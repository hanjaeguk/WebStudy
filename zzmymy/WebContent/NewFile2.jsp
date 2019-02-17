<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <link rel="stylesheet" href="${root}/resources/css/login.css">
	<link rel="stylesheet" href="${root}/resources/fonts/iconic/css/material-design-iconic-font.min.css">
<style>
.white_content {
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background: rgba(0, 0, 0, 0.8);
    opacity:0;
    -webkit-transition: opacity 400ms ease-in;
    -moz-transition: opacity 400ms ease-in;
    transition: opacity 400ms ease-in;
    pointer-events: none;
}
.white_content:target {
    opacity:1;
    pointer-events: auto;
}
.white_content > div {
	position: absolute;
	top: 25%;
	left: 25%;
	width: 50%;
	height: 50%;
	padding: 16px;
	border: 16px solid orange;
	background-color: white;
	overflow: auto;	
}
</style>
<body>
 <p>메인 콘텐츠입니다. Lightbox를 표시하려면<a href="#open">여기</a>를 클릭하십시오.</p>
    <div class="white_content" id="open">
        	<div>
		<form class="login100-form validate-form">
			<div class="new-modal-login">
			<h4><span class="glyphicon glyphicon-lock" style="align-text:center;"></span>로그인</h4>
			<br><br>
				<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired" align="left">
					<span class="label-input100">아이디</span>
					<input class="input100" type="text" name="userid" placeholder="아이디를 입력해주세요.">
					<span class="focus-input100" data-symbol="&#xf206;"></span>
				</div>
				<br>
				<div class="wrap-input100 validate-input" data-validate="Password is required" align="left">
					<span class="label-input100">비밀번호</span>
					<input class="input100" type="password" name="password" placeholder="비밀번호를 입력해주세요.">
					<span class="focus-input100" data-symbol="&#xf190;"></span>
				
			</div>
			<div class="text-right p-t-8 p-b-31">
				<a href="#">
					비밀번호를 잊으셨나요??
				</a>
				</div>
			</div>
			
			 <div class="d-flex justify-content-center mb-3">
		    	<div class="p-2">
		    		<input type="submit" value="로그인" class="btn btn-primary py-3 px-4">&nbsp;&nbsp;&nbsp;&nbsp;
		    		<input type="submit" value="회원가입" class="btn btn-primary py-3 px-4">
		    	</div>			    
			 </div>				
			</form>
		</div>
    </div>
</body>
</html>