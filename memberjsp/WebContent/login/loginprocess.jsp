
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,com.kitri.util.*,java.net.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	String name = null;
	String emailid = null;
	String emaildomain = null;
	int cnt = 0;
	
	try{
		conn = DBConnection.makeConnection();
		String sql = "select id,name,emailid,emaildomain from member where id=? and pass=?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,id);
		pstmt.setString(2,pass);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			name=rs.getString(2);
			emailid=rs.getString(3);
			emaildomain=rs.getString(4);
			cnt++;
	}
	
	}finally{
		DBclose.close(conn, pstmt, rs);
	}
	if(cnt != 0){
		response.sendRedirect("/memberjsp/login/loginok.jsp?id="+id+"&name="+URLEncoder.encode(name,"UTF-8")+"&emailid="+emailid+"&emaildomain="+emailid);
	}else{	
		response.sendRedirect("/memberjsp/login/loginfail.jsp");
	}
%>	
