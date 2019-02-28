<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="col-lg-3 sidebar">
	<div class="sidebar-wrap bg-light ftco-animate">
		<form action="#">
			<div class="categories">
				<li><a href="${root}/member?act=mvmyinfo&bcode=0&pg=1&key=&word=">내 정보관리</a></li>
				<li><a href="${root}/member?act=mvmywritelist&bcode=0&pg=1&key=&word=">내가 작성한 일정</a></li>
				<li><a href="${root}/member?act=mvmyschedulewishlist&bcode=0&pg=1&key=&word=">내가 찜한 일정</a></li>
				<li><a href="${root}/member?act=mvmyreviewwishlist&bcode=0&pg=1&key=&word=">내가 찜한 리뷰</a></li>
			</div>
		</form>
	</div>
</div>