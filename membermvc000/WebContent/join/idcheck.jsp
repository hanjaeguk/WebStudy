<%@page import="com.kitri.member.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
String id = (String)request.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=root%>/css/style.css" type="text/css">
<script type="text/javascript">
 document.getElementById("id").value =opener.document.getElementById("id").value;
function idcheck(){
	if(document.getElementById("id").value == "") {
		alert("검색 아이디 입력!");
		return;
	} else {
		document.idform.action = "<%=root%>/user";
		document.idform.submit();
	}
}

function iduse(id){
	opener.document.getElementById("id").value = id;
	self.close();

}
</script>
</head>
<body>
<div class="box3" align="center">
<form name="idform" method="get" action="" onsubmit="return false;">
<input type="hidden" name="act" value="idcheck">
<h3>아이디 중복 검사</h3>
<hr>

	<div class="div1" align="left">검색할 아이디를 입력하세요
	<div class="div2">
	<input type="text" name="id" id="id" onkeypress="javascript:if(event.keyCode == 13){ idcheck(); }">
	<input type="button" value="검색" onclick="javascript:idcheck();">
	</div>
	
	
	
	
	<%
	if(id==null){//검색을 안했다면
	%>
	<div class="div3">
	검색할 아이디를 정확히 입력한 후 검색 버튼을 클릭하세요..
	</div>
	<%
	}else{//검색을 했다면
	
	int cnt = (int)request.getAttribute("cnt");	
	if(cnt == 0){	
	%>
	<div class="div3">
	<strong><%=id%></strong>는 사용 가능한 ID입니다.<br>
	<a href="javascript:iduse('<%=id%>')">사용하기</a>
	</div>
	
	<%}else{
	%>	
	<div class="div3">
	<strong><%=id%></strong>는 이미 사용중 입니다.
	</div>
	<%
	}
}
%>
	
	
	
	
	</div>

</form>
</div>
</body>
</html>