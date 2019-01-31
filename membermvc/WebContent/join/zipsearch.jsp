<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.kitri.member.model.*"%>

<%
String root = request.getContextPath();

String doro = (String)request.getAttribute("doro");

//List<ZipCodeDto> list = (List<ZipCodeDto>)request.getAttribute("ziplist");

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
		alert("검색할 도로명을 입력하세요.");
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
<form name="zipform" method="get" onsubmit="return false;" action="" >
<input type="hidden" name="act" value="zipsearch">
<h3>우편번호검색</h3>
<hr>
	<div align="left" >
		<div class="div1">검색할 도로명을 입력하세요<br>(예: 역삼동, 개포)</div>
		<div class="div2">
			<input type="text" name="doro" id="doro" onkeypress="javascript:if(event.keyCode == 13){ dorocheck(); }">
			<input type="button" value="검색" id="btnsearch" onclick="javascript:dorocheck();">
		</div>
		<%
		if(doro == null){ // 검색한적이 없다면..			
		%>

		<%
		}else{ // 검색 했다면
			List<ZipCodeDto> list = (List<ZipCodeDto>)request.getAttribute("ziplist");
			int len = list.size();
			System.out.println(len);
			if(len != 0){
				for(ZipCodeDto zipCodeDto : list){
		%>
		<div class="div3">
			<a href="javascript:selectzip('<%=zipCodeDto.getZipcode()%>','<%=zipCodeDto.getSido()%> <%=zipCodeDto.getGugun()%> <%=zipCodeDto.getUpmyon()%> <%=zipCodeDto.getDoro()%> <%=zipCodeDto.getBuilding_number()%> <%=zipCodeDto.getSigugun_building_name() %>')">
			<%=zipCodeDto.getZipcode()%> <%=zipCodeDto.getSido()%> <%=zipCodeDto.getGugun()%> <%=zipCodeDto.getUpmyon()%> <%=zipCodeDto.getDoro()%> <%=zipCodeDto.getBuilding_number()%> <%=zipCodeDto.getSigugun_building_name() %>
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










