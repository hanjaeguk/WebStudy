package com.kitri.basic;




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



@WebServlet("/dbCounter")
public class DBCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int cnt;
	int maxLength;

	public void init() {
		// 서블릿이 호출될때 최초 한번만 실행!!!
		System.out.println("init method 호출!!");
		cnt = 0;
		maxLength = 8;
//		1.Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracelDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet method 호출!!");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

			try {
//				2.DB접속(Connection) 생성
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.33:1521:xe", "kitri", "kitri");
				
//				3.SQL 실행준비(PreparedStatement 생성)
				String select = "select cnt from counter";
				pstmt = conn.prepareStatement(select);

//				4.SQL 실행(select : ResultSet 생성)
				rs = pstmt.executeQuery();
				rs.next();
				cnt = rs.getInt("cnt");
				
				pstmt.close(); // 다음쿼리를 위해 닫아줌
				String update = "update counter set cnt = cnt + 1";
				pstmt = conn.prepareStatement(update);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
//		5.DB접속 종료 : 연결역순 ,finally,exception
				try {
					if(rs != null) {
						rs.close();						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(pstmt != null) {
						pstmt.close();						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(conn != null) {
						conn.close();						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
			
			
			

		
		
		
		
		cnt++;
		String cntStr = cnt +"";
		int cntLength = cntStr.length();
		int zeroLength = maxLength - cntLength;
		// 당신은 XXX번쨰 방문자 입니다.
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div align = \"center\">");
		out.println("당신은");
		for (int i = 0; i<zeroLength; i++) {
			out.println("<img src = '/basicservlet/img/0.jpg' width = '30'>");			
		}
		
		for (int i = 0; i<cntLength; i++) {
			out.println("<img src = '/basicservlet/img/"+cntStr.charAt(i)+".jpg' width = '30'>");			
		}
		
		out.println("번째 방문자입니다.");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
