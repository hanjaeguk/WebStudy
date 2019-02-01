
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,com.kitri.util.*,java.net.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	int cnt = 0;
	
	try{
		conn = DBConnection.makeConnection();
		
		
		String sql = "";
		sql += "insert into guestbook(seq,name,subject,content,logtime)\n";
		sql += "values(guestbook_seq.nextval,?,?,?,sysdate)\n";

		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, subject);
		pstmt.setString(3, content);
		
		cnt = pstmt.executeUpdate();
	
	}finally{
		DBclose.close(conn, pstmt, rs);
	}
	if(cnt != 0){
		response.sendRedirect("/guestbookjsp/guestbookwriteok.jsp?name="+URLEncoder.encode(name,"UTF-8")+"&subject="+URLEncoder.encode(subject,"UTF-8")+"&content="+URLEncoder.encode(content,"UTF-8"));
	}else{	
		response.sendRedirect("/guestbookjsp/guestbookwritefail.jsp");
	}
%>	
