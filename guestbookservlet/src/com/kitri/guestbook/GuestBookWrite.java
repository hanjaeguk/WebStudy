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


@WebServlet("/write")
public class GuestBookWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		int cnt = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user3","han3");
			String sql = "";
			sql += "insert into guestbook(seq,name,subject,content,logtime)\n";
			sql += "values(guestbook_seq.nextval,?,?,?,sysdate)\n";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		out.println("<html>");
		out.println("<body>");
		out.println("<div align = \"center\">");
		if(cnt != 0) { // 성공
			out.println("방명록이 등록되었습니다.<br>");
			out.print("<input type=\"button\" value=\"초기화면\" class=\"button\" onclick=\"location.href='/guestbookservlet/index.html'\">");
		} else { // 실패
			out.print("<font color = 'red'>");
			out.print("죄송합니다. 서버문제로 서비스가 원할하지 않습니다.");
			out.print("다음에 다시 이용해 주세요.");
			out.print("</font>");
		}
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
