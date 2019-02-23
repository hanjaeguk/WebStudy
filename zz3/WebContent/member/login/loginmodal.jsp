<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<style>
.modal {
        text-align: center;
}
 
@media screen and (min-width: 768px) { 
        .modal:before {
                display: inline-block;
                vertical-align: middle;
                content: " ";
                height: 100%;
        }
}
 
.modal-dialog {
        display: inline-block;
        text-align: left;
        vertical-align: middle;
        width: 350px;
        
}



</style>
<link rel="stylesheet" href="${root}/resources/css/login.css">
<link rel="stylesheet"
	href="${root}/resources/fonts/iconic/css/material-design-iconic-font.min.css">
<!-- Modal -->
<div class="modal fade" id="myLoginModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div>
				<form class="login100-form validate-form">
					<div class="loginModalHead" align="center">
					<br>
						<h2>
							<span class="glyphicon glyphicon-lock">로그인</span>
						</h2>
					</div>
					<br>
					<br>
					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Username is reauired" align="left">
						<span class="label-input100">아이디</span> <input class="input100"
							type="text" name="userid" placeholder="아이디를 입력해주세요."> <span
							class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<br>
					<div class="wrap-input100 validate-input"
						data-validate="Password is required" align="left">
						<span class="label-input100">비밀번호</span> <input class="input100"
							type="password" name="password" placeholder="비밀번호를 입력해주세요.">
						<span class="focus-input100" data-symbol="&#xf190;"></span>

					</div>
					<div class="text-right p-t-8 p-b-31">
						<a href="#"> 비밀번호를 잊으셨나요?? </a>
					</div>
					<br>
					<div class="d-flex justify-content-center mb-3">
						<div class="p-2">
							<input type="submit" value="로그인"
								class="btn btn-primary py-3 px-4">&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" value="회원가입"
								class="btn btn-primary py-3 px-4">
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
</div>


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

