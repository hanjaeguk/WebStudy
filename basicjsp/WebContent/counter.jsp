<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
int cnt;
int maxLength;
public void init(){
	cnt=0;
	maxLength=8;
}
%>

<div align="center">
당신은
<%
cnt++;
String cntStr = Integer.toString(cnt);
int cntLength = cntStr.length();
int zeroLength = maxLength - cntLength;
System.out.println(cntStr);
for(int i=0;i<zeroLength;i++){
%><img src = "/basicjsp/img/0.jpg" width = "30"><%
}
for (int i = 0; i<cntLength; i++) {
%><img src = "/basicjsp/img/<%=cntStr.charAt(i)%>.jpg" width = "30"><%
}
%>번째 방문자 입니다.
</div>
</body>
</html>