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
function idcheck(){
	if(document.getElementById("id").value == "") {
		alert("검색 아이디 입력!");
		return;
	} else {
		document.idform.action = "";
		document.idform.submit();
	}
}

function iduse(id){

}
</script>
</head>
<body>
<div class="box3" align="center">
<form name="idform" method="get" action="" onsubmit="return false;">
<input type="hidden" name="act" value="idsearch">
<h3>아이디 중복 검사</h3>
<hr>

	<div class="div1" align="left">검색할 아이디를 입력하세요
	<div class="div2">
	<input type="text" name="id" id="id" onkeypress="javascript:if(event.keyCode == 13){ idcheck(); }">
	<input type="button" value="검색" onclick="javascript:idcheck();">
	</div>
	<div class="div3">
	검색할 아이디를 정확히 입력한 후 검색 버튼을 클릭하세요..
	</div>
	</div>

</form>
</div>
</body>
</html>