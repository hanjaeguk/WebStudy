<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@ include file="/include/link.jsp"%>
<%@ include file="/include/loader.jsp"%> 
</head>
<body>
<%@ include file="/include/nav.jsp"%>

    <div class="hero-wrap js-fullheight" style="background-image: url('${root}/resources/images/bg_4.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-9 ftco-animate text-center" data-scrollax=" properties: { translateY: '70%' }">  
            <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">내가 찜한 일정</h1>
          </div>
        </div>
      </div>
    </div>

  <!-- 내용시작 -->
	<section class="ftco-section ftco-degree-bg">
	<div class="container">
	<div class="row">
	
<!-- 왼쪽 검색창 -->	
<%@ include file="/member/myMenu/sidebar.jsp"%>
<!-- 왼쪽 검색창 END -->

<!-- 오른쪽 목록 -->
		<div class="col-lg-9">
<!-- 목록들 -->
   
        	<div class="row">
        		<c:forEach var="i" begin="1" end="3">
					<div class="col-md-4 ftco-animate destination">
			    		<a href="${root}/schedule/view.jsp" class="img img-2 d-flex justify-content-center align-items-center" style="background-image: url('${root}/resources/images/destination-${i}.jpg');">
				    		<div class="icon d-flex justify-content-center align-items-center">
		    					<span class="icon-search2"></span>
		    				</div>
			    		</a>
			    		<div class="text p-3">
			    			<div class="d-flex">
					    		<h3><a href="#">여행 제목이 들어갑니다!!! </a></h3>
			    			</div>
			    			<p>#전라남도 #여수 #순천 #광양 #저기 <br>#나혼자.</p>
			    			<br>
			    			<p class="days"><span>18.08.18 - 18.09.18 (30일)</span></p>
			    			<hr>
			    			<p class="bottom-area d-flex">
			    				<span><i class="icon-person"></i> 작성자id</span> <!-- icon변경 -->
			    				<span class="ml-auto">후기</span>
			    			</p>
			    		</div>
					</div>
        		</c:forEach>
          	</div>
  
          	
<!-- 목록들 END -->

      	
		</div> 
<!-- 오른쪽 목록  END-->
	</div> <!-- 큰 row END -->
	</div> <!-- 큰 container END -->
	</section>
<!-- 내용끝 -->


<%@ include file="/include/footer.jsp"%>   
<%@ include file="/include/arrowup.jsp"%>
</body>
</html>