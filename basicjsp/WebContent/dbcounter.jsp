<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,com.kitri.util.*"%>
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
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
%>

<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
	conn = DBConnection.makeConnection();
	String sql = "select cnt from counter";
	pstmt = conn.prepareStatement(sql);
	
	rs = pstmt.executeQuery();
	while(rs.next()){
	cnt = rs.getInt(1);		
	}
	
	pstmt.close();
	
	String update = "update counter set cnt = cnt+1";
	pstmt = conn.prepareStatement(update);
	pstmt.executeUpdate();
	
//} catch (SQLException e) { //특별하게 SQLException 일때 할게 뭐 없으면 안써도됌!
//	e.printStackTrace();	 //jsp에서 자동으로 catch(모든 예외처리로)를 잡아주기때문에 안해도된다!
} finally {
	DBclose.close(conn, pstmt, rs);
	
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