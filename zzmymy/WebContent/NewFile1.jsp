<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/include/link.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
<script>
$(document).ready(function(){
  $("#myLoginBtn").click(function(){
    $("#myLoginModal").modal();
  });
});
</script>
  
</head>
<body>


  <h2>로그인123</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-default btn-lg" id="myLoginBtn">Login</button>

  <!-- Modal -->
 <div class="modal fade" id="myLoginModal" role="dialog">
   <div class="modal-dialog">
   
     <!-- Modal content-->
     <div class="modal-content">
      
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
   </div>
 </div> 

 


</body>
</html>
