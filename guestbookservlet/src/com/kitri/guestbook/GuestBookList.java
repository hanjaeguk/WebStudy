package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list")
public class GuestBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//		String getName
//		String getlogtime
//		String getSeq
//		String getSubject
//		String getContent
//		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user3","han3");
			String sql = "select name,logtime,seq,subject,content from guestbook order by seq desc";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<div align = \"center\">");
			out.println("<h3>글목록</h3>");
			while(rs.next()) {
				String getName = rs.getString(1);
				String getlogtime = rs.getString(2);
				String getSeq = rs.getString(3);
				String getSubject = rs.getString(4);
				String getContent = rs.getString(5);
				getContent = getContent.replace("\r\n", "<br>");
				
				
				out.println("<table border='1'>");
				out.println("<tr>");
				out.println("<td>작성자: "+getName);
				out.println("</td>");
				out.println("<td>작성일: "+getlogtime);
				out.println("</td>");
				out.println("</tr>");
				

				out.println("<tr>");
				out.println("<td colspan='2'>"+getSeq+". "+ getSubject);
				out.println("</td>");
				out.println("</tr>");
				
				
				out.println("<tr>");
				out.println("<td colspan='2'>"+getContent);
				out.println("</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<br>");

			}
			
			out.print("<input type=\"button\" value=\"초기화면\" class=\"button\" onclick=\"location.href='/guestbookservlet/index.html'\">");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			try {
				if(pstmt != null)
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			try {
				if(conn != null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		

		

		
		

	}

}
