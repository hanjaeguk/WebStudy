<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,com.kitri.util.*,java.net.*" %> 
<%
request.setCharacterEncoding("UTF-8");
Connection conn = null;
PreparedStatement pstmt = null;

String name = request.getParameter("name");
String id = request.getParameter("id");
String pass = request.getParameter("pass");
String emailid = request.getParameter("emailid");
String emaildomain = request.getParameter("emaildomain");
String tel1 = request.getParameter("tel1");
String tel2 = request.getParameter("tel2");
String tel3 = request.getParameter("tel3");
String zipcode = request.getParameter("zipcode");
String address = request.getParameter("address");
String address_detail = request.getParameter("address_detail");

int cnt = 0;

try {

	conn = DBConnection.makeConnection();
	String sql = "";
	sql += "insert all \n";
	sql += "into member(id,name,pass,emailid,emaildomain,joindate) \n";
	sql += "values(?,?,?,?,?,sysdate) \n";
	sql += "into member_detail(id,tel1,tel2,tel3,zipcode,address,address_detail) \n";
	sql += "values(?,?,?,?,?,?,?) \n";
	sql += "select * from dual";
	pstmt = conn.prepareStatement(sql);
	
	int idx = 1;
	pstmt.setString(idx++, id);
	pstmt.setString(idx++, name);
	pstmt.setString(idx++, pass);
	pstmt.setString(idx++, emailid);
	pstmt.setString(idx++, emaildomain);
	pstmt.setString(idx++, id);
	pstmt.setString(idx++, tel1);
	pstmt.setString(idx++, tel2);
	pstmt.setString(idx++, tel3);
	pstmt.setString(idx++, zipcode);
	pstmt.setString(idx++, address);
	pstmt.setString(idx++, address_detail);

	cnt = pstmt.executeUpdate();
	
//} catch (SQLException e) { //특별하게 SQLException 일때 할게 뭐 없으면 안써도됌!
//	e.printStackTrace();	 //jsp에서 자동으로 catch(모든 예외처리로)를 잡아주기때문에 안해도된다!
} finally {
	DBclose.close(conn, pstmt);
}
if(cnt != 0){
	response.sendRedirect("/memberjsp/join/registerok.jsp?name="+URLEncoder.encode(name,"UTF-8")+"&id="+id+"&emailid="+emailid+"&emaildomain="+emaildomain);
}else{
	response.sendRedirect("/memberjsp/join/registerfail.jsp");
}
%>	
