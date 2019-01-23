package com.kitri.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		
		int cnt = 0;
		String name = null;
		String emailid = null;
		String emaildomain = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.33:1521:xe","kitri","kitri");
			String sql = "select id,name,emailid,emaildomain from member where id = ? and pass = ?";
		
			pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setString(idx++, id);
			pstmt.setString(idx++, pass);
			
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				name = rs.getString(2);
				emailid = rs.getString(3);
				emaildomain = rs.getString(4);
				cnt++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div align = \"center\">");
		if(cnt != 0) { // 성공
			out.print("<strong>"+name+"</strong>("+id+")님 어서오세요.");						
			out.print("이메일은<a href = 'mailto:"+emailid+"@"+emaildomain+"'>"+emailid+"@"+emaildomain+"</a>입니다.");
		} else { // 실패
			out.print("<font color = 'red'>");
			out.print("아이디와 비밀번호를 확인해 주세요.<br>");
//			out.print("<a href='/memberservlet/login/login.html'>로그인</a>");	
			out.print("3초후 로그인 페이지로 이동합니다.");	
			out.print("<meta http-equiv='refresh' content='3;url=/memberservlet/login/login.html'");	
			out.print("</font>");
		}
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
		
		
		
		
	}

}
