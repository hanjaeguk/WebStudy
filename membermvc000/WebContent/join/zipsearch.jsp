<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.ZipCodeDto,
    java.util.List"%> 
<%
String root = request.getContextPath();
String doro = (String)request.getAttribute("doro");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=root%>/css/style.css" type="text/css">
<script type="text/javascript">
function dorocheck(){
	if(document.getElementById("doro").value == "") {
		alert("검색 도로명 입력!");
		return;
	} else {
		document.zipform.action = "<%=root%>/user";
		document.zipform.submit();
	}
}

function selectzip(zipcode, address){
	opener.document.getElementById("zipcode").value = zipcode;
	opener.document.getElementById("address").value = address;
	self.close();
}
</script>
</head>
<body>
<div class="box3" align="center">
<form name="zipform" method="get" action="" onsubmit="retrun false">
<input type="hidden" name="act" value="zipsearch">
<h3>우편번호검색</h3>
<hr>
	<div align="left" >
	<div class="div1">검색할 도로명을 입력하세요<br>(예: 역삼, 개포)</div>
	<div class="div2">												<!-- 13번 엔터 만약 엔터를 쳣다면이란 뜻 -->
	<input type="text" name="doro" id="doro" onkeypress="javascript:if(event.keyCode == 13){ dorocheck(); }">
	<input type="button" value="검색" id="btnsearch" onclick="javascript:dorocheck();">
	</div>
	
	
	
<%
if(doro == null) {//검색을 안했다면
%>

	<div class="div3">
	동이름을 정확히 입력하세요.
	</div>

<%
}else{//검색 했다면
	List<ZipCodeDto> list = (List<ZipCodeDto>)request.getAttribute("ziplist");
	int len = list.size();
	if(len != 0){
		for(ZipCodeDto zipCodeDto : list){
%>	
	<div class="div3">
	<a href="javascript:selectzip('<%=zipCodeDto.getZipcode()%>','<%=zipCodeDto.getSido()%> <%=zipCodeDto.getGugun()%> <%=zipCodeDto.getUpmyon()%> <%=zipCodeDto.getDoro()%> <%=zipCodeDto.getBuilding_number()%> <%=zipCodeDto.getSigugun_building_name()%>')">
	<%=zipCodeDto.getZipcode()%> <%=zipCodeDto.getSido()%> <%=zipCodeDto.getGugun()%> <%=zipCodeDto.getUpmyon()%> <%=zipCodeDto.getDoro()%> <%=zipCodeDto.getBuilding_number()%> <%=zipCodeDto.getSigugun_building_name()%>
	</a>
	</div>
<%
		}
	}else{
%>	
	
	<div class="div3">
	<strong>'<%=doro%>'</strong>에 대한 검색 결과가 없습니다.<br>
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










