<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/httpRequest.js"></script>
<script type="text/javascript">

var memberlist;

function search(){
	var key = document.getElementById("key").value;
	var word = document.getElementById("word").value;
	var params = "act=memberlist&key=" + key + "&word=" + encodeURIComponent(word);
	sendRequest("<%=request.getContextPath()%>/user", params, memberList, "GET");
}

function memberList(){
	if(httpRequest.readyState == 4){//처리완료
		if(httpRequest.status == 200){
			memberlist = document.getElementById("memberlist");
			clearData();
			makeList(httpRequest.responseXML);		
		}else{
			alert("에러발생!");
		}
	}
}

function makeList(data) {
	var members = data.getElementsByTagName("member");
	var len = members.length;
	for(var i=0;i<len;i++){
		var member = members.item(i); //members[i]와 같음
		var id = member.getElementsByTagName("userid").item(0).firstChild.nodeValue;
		var name = member.getElementsByTagName("username").item(0).firstChild.nodeValue;
		var email = member.getElementsByTagName("email").item(0).firstChild.nodeValue;
		var tel = member.getElementsByTagName("phone").item(0).firstChild.nodeValue;
		var address = member.getElementsByTagName("address").item(0).firstChild.nodeValue;
		var joindate = member.getElementsByTagName("joindate").item(0).firstChild.nodeValue;
		
		var row = createRow(id, name, email, tel, address, joindate);
		memberlist.appendChild(row);
	}
}

function createRow(id, name, email, tel, address, joindate){
	var tr = document.createElement("tr");  //<tr></tr>가 만들어짐
	tr.appendChild(createCol(name));//<tr><td bgcolor="lightgray">오상재</td></tr>
	tr.appendChild(createCol(id));//<tr><td bgcolor="lightgray">sangjaeoh</td></tr>
	tr.appendChild(createCol(email));
	tr.appendChild(createCol(tel));
	tr.appendChild(createCol(address));
	tr.appendChild(createCol(joindate));
	
	return tr;
}

function createCol(data){
	var td = document.createElement("td");//<td></td>가 만들어짐
	td.setAttribute("bgcolor", "lightgray");//<td bgcolor="lightgray"></td>
	var txtNode = document.createTextNode(data);
	td.appendChild(txtNode);
	return td;
}

function clearData(){
	var len = memberlist.childNodes.length;
	for(var i=len-1;i>=0;i--){
		memberlist.removeChild(memberlist.childNodes[i]);
	}
}
</script>
</head>
<body>
<div align="center">
<h3>회원목록</h3>
<table width="900">
<tr>
	<td align="right">
	<select id="key">
		<option value="id">아이디
		<option value="name">이름
		<option value="address">주소
	</select>
	<input type="text" id="word">
	<button onclick="javascript:search();">검색</button>
	</td>
</tr>
<table width="900" border="1">
<tr>
	<th width="80">이름</th>
	<th width="80">아이디</th>
	<th width="150">이메일</th>
	<th width="100">전화번호</th>
	<th>주소</th>
	<th width="80">가입일</th>
</tr>
<tbody id="memberlist"></tbody>
</table>
</div>
</body>
</html>