<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>마이메뉴</title>
    
    <%@ include file="include/link.jsp"%>
  </head>
  <body>
  	<%@ include file="include/nav.jsp"%>    
    <div class="hero-wrap js-fullheight" style="background-image: url('images/bg_4.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-9 ftco-animate text-center" data-scrollax=" properties: { translateY: '70%' }">  
            <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">내정보 확인/수정</h1>
          </div>
        </div>
      </div>
    </div>
  <section class="ftco-section ftco-degree-bg">
	<div class="container">

		<div class="row">
	       	<div class="col-lg-2 sidebar" id="myside">
		        <ul class="list-unstyled">
	                <li><a href="#" class="py-2 d-block">내 정보관리!!</a></li>
		        	<li><a href="#" class="py-2 d-block">내가 작성한 목록</a></li>
	                <li><a href="#" class="py-2 d-block">내가 찜한 목록</a></li>
	
	            </ul>	
			</div>
          <div class="col-lg-10" align="left">
				<div class="container-login100">
					<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
						<form class="login100-form validate-form">
							<span class="login100-form-title p-b-49">
								나의 정보
							</span>
							<br><br>
							<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired" align="left">
								<span class="label-input100">아이디</span>
									<input class="input100" type="text" name="username" value="Test" readonly="readonly">
								<span class="focus-input100" data-symbol="&#xf206;"></span>
							</div>
							<div class="d-flex justify-content-center mb-3" align="right">
						    	<div class="p-2" align="right">
								   
						    	</div>			    
							</div>	
							<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired" align="left">
								<span class="label-input100">이름</span>
									<input class="input100" type="text" name="username" value="홍길동!!!" readonly="readonly">
								<span class="focus-input100" data-symbol="&#xf203;"></span>
							</div>
							<br>
							<div class="wrap-input100 validate-input" data-validate="Password is required" align="left">
								<span class="label-input100">비밀번호</span>
								<input class="input100" type="password" name="pass" placeholder="비밀번호입력">
								<span class="focus-input100" data-symbol="&#xf190;"></span>
							</div>
							<br>
							<div class="wrap-input100 validate-input" data-validate="Password is required" align="left">
								<span class="label-input100">비밀번호확인</span>
								<input class="input100" type="password" name="pass" placeholder="비밀번호 재입력">
								<span class="focus-input100" data-symbol="&#xf191;"></span>
							</div>
							<br>
							<div class="wrap-input100 validate-input" data-validate="Password is required" align="left">
								<span class="label-input100">이메일</span>
								<input class="input100" type="text" name="pass" value="test@naver.com">
								<span class="focus-input100" data-symbol="&#xf15a;"></span>
							</div>
							
							
							
							<br><br>
							<div class="d-flex justify-content-center mb-3">
						    	<div class="p-2">
						    		<input type="submit" value="수정" class="btn btn-primary py-3 px-4">
						    		<input type="submit" value="취소" class="btn btn-primary py-3 px-4">
						    	</div>			    
							</div>				
								
							</div>
						</form>
					</div>
          </div>
		</div>        	
	</div>
	
    </section> <!-- .section -->

    <footer class="ftco-footer ftco-bg-dark ftco-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">dirEngine</h2>
              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-5">
              <h2 class="ftco-heading-2">Information</h2>
              <ul class="list-unstyled">
	            <li><a href="#" class="py-2 d-block">About</a></li>
	            <li><a href="#" class="py-2 d-block">Service</a></li>
	            <li><a href="#" class="py-2 d-block">Terms and Conditions</a></li>
	            <li><a href="#" class="py-2 d-block">Become a partner</a></li>
	            <li><a href="#" class="py-2 d-block">Best Price Guarantee</a></li>
	            <li><a href="#" class="py-2 d-block">Privacy and Policy</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Customer Support</h2>
              <ul class="list-unstyled">
                <li><a href="#" class="py-2 d-block">FAQ</a></li>
                <li><a href="#" class="py-2 d-block">Payment Option</a></li>
                <li><a href="#" class="py-2 d-block">Booking Tips</a></li>
                <li><a href="#" class="py-2 d-block">How it works</a></li>
                <li><a href="#" class="py-2 d-block">Contact Us</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
      <div class="col-md-12 text-center">
          
	<%@ include file="include/footer.jsp"%>
	<%@ include file="include/loader.jsp"%>    
	<%@ include file="include/arrowup.jsp"%>
    
  </body>
</html>