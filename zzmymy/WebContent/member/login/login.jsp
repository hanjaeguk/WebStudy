<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${root}/resources/css/login.css">
<link rel="stylesheet" href="${root}/resources/fonts/iconic/css/material-design-iconic-font.min.css">
<%@ include file="/include/link.jsp"%>

<script>
$(document).ready(function(){
  $("#myBtn").click(function(){
    $("#myModal").modal();
  });
});
</script>
</head>
<body>

<div class="container">
	<h2>Modal Login Example123</h2>
	<!-- Trigger the modal with a button -->
	<button type="button" class="btn btn-default btn-lg" id="myBtn">Login</button>

	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">

				<div>
					<form class="login100-form validate-form">
						<div class="new-modal-login">
							<span class="login100-form-title p-b-49">
								Login
							</span>
							<br><br>
							<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired" align="left">
								<span class="label-input100">ID</span>
								<input class="input100" type="text" name="username" placeholder="Type your username">
								<span class="focus-input100" data-symbol="&#xf206;"></span>
							</div>
							<br>
							<div class="wrap-input100 validate-input" data-validate="Password is required" align="left">
								<span class="label-input100">Password</span>
								<input class="input100" type="password" name="pass" placeholder="Type your password">
								<span class="focus-input100" data-symbol="&#xf190;"></span>
							</div>
							<div class="text-right p-t-8 p-b-31">
								<a href="#">
								Forgot password?!!!!
								</a>
							</div>
						</div>

						<div class="d-flex justify-content-center mb-3">
							<div class="p-2">
								<input type="submit" value="로그인" class="btn btn-primary py-3 px-4">
								<input type="submit" value="회원가입" class="btn btn-primary py-3 px-4">
							</div>			    
						</div>				
					</form>
				</div>
			</div>
		</div>
	</div> 
</div>

    <section class="ftco-section bg-light">
    

         
    </section>


<%@ include file="/include/footer.jsp"%>
<%@ include file="/include/loader.jsp"%>    
<%@ include file="/include/arrowup.jsp"%>
</body>
</html>