<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>FormWizard_v1</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="colorlib.com">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.css">

		<!-- STYLE CSS -->
		<link rel="stylesheet" href="css/signup.css">
	</head>
	<body>
		<div >
            <form action="" id="wizard">
                    <div class="inner">
						
						<div class="form-content" >
							<div class="form-header">
								<h3>회원가입!!</h3>
							</div>
							<div class="form-row">
								<div class="form-holder">
									<input class="input100" type="text" name="username" placeholder="Type your username">
								</div>
								<div class="form-holder">
									<input type="button" value="아이디중복검사" class="btn" width="300">
								</div>
							</div>
							
							<div class="form-row">
								<div class="form-holder">
									<input type="password" placeholder="passward" class="form-control">
								</div>
								<div class="form-holder">
									<input type="password" placeholder="passward recheck" class="form-control">
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									<input type="text" placeholder="First Name" class="form-control">
								</div>
								<div class="form-holder">
									<input type="text" placeholder="Last Name" class="form-control">
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									<input type="text" placeholder="Your Email" class="form-control">
								</div>
								<div class="form-holder">
									<input type="text" placeholder="Phone Number" class="form-control">
								</div>
							</div>
							

						
							<div class="form-row">
								<div class="form-holder" style="align-self: flex-end; transform: translateY(4px);">
									<div class="checkbox-tick">
										<label class="male">
											<input type="radio" name="gender" value="male" checked> Male<br>
											<span class="checkmark"></span>
										</label>
										<label class="female">
											<input type="radio" name="gender" value="female"> Female<br>
											<span class="checkmark"></span>
										</label>
									</div>
								</div>
								<input type="button" value="회원가입" class="btn" width="300">
							</div>
						</div>
					</div>
                

            </form>
		</div>


</body>
</html>
