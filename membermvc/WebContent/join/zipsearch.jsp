<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=root%>/css/style.css" type="text/css">
<script type="text/javascript">
function dongcheck(){
	if(document.getElementById("dong").value == "") {
		alert("검색 동 입력!");
		return;
	} else {
		document.zipform.action = "";
		document.zipform.submit();
	}
}

function selectzip(z1, z2, address){

}
</script>
</head>
<body>
<div class="box3" align="center">
<form name="zipform" method="get" action="">
<input type="hidden" name="act" value="zipsearch">
<h3>우편번호검색</h3>
<hr>
	<div align="left" >
	<div class="div1">검색할동을 입력하세요<br>(예: 역삼동, 신촌)</div>
	<div class="div2">
	<input type="text" name="dong" id="dong" onkeypress="javascript:if(event.keyCode == 13){ dongcheck(); }">
	<input type="button" value="검색" id="btnsearch" onclick="javascript:dongcheck();">
	</div>
	<div class="div3">
	검색 결과가 없습니다.<br>
	동이름을 정확히 입력하세요.
	</div>
	</div>
</form>
</div>
</body>
</html>










