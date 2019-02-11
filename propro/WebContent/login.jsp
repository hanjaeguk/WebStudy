<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V4</title>
	<meta charset="UTF-8">
	<%@ include file="include/link.jsp"%>

</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: ;">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-49">
						Login
					</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100">Username</span>
						<input class="input100" type="text" name="username" placeholder="Type your username">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Password</span>
						<input class="input100" type="password" name="pass" placeholder="Type your password">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<div class="text-right p-t-8 p-b-31">
						<a href="#">
							Forgot password?!!!!!
						</a>
					</div>
					
			
				<div class="d-flex justify-content-center mb-3">
			    <div class="p-2"><input type="submit" value="Login" class="btn btn-primary py-3 px-4"></div>			    
				</div>				
					

					<div class="txt1 text-center p-t-54 p-b-20">
						<span>
							Or Sign Up Using!
						</span>
					</div>

					

					<div class="flex-col-c p-t-155">
						<span class="txt1 p-b-17">
							Or Sign Up Using
						</span>

						<a href="/myproject/signup.jsp" class="txt2">
							Sign Up
						</a>
						
						<a href="/myproject/index.jsp" class="txt2">
							Home
						</a>
						
					</div>
				</form>
			</div>
		</div>
	</div>



</body>
</html>