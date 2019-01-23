package com.kitri.member;

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

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {

//		1.Driver Loading
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
//		1.data get(이름,아이디,비번,전화번호,이메일,주소..get.)
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

//		2.data를 db 넣어야함
//			2-1.db 드라이버 로딩 (init)
//			2-2.db 접속(Connection)
//			2-3.SQL 실행준비
//				insert into member(id,name,pass,emailid,emaildomain,join date)
//				values(?,?,?,?,?,sysdate)
//				insert into member_detail(id,tel1,tel2,tel2,zipcode,address,address_detail)
//				values(?,?,?,?,?,?,?)
//			** insert 두개 한꺼번에 실행
//			>>> insert all
//					into member(id,name,pass,emailid,emaildomain,joindate)
//					values(?,?,?,?,?,sysdate)
//					into member_detail(id,tel1,tel2,tel2,zipcode,address,address_detail)
//					values(?,?,?,?,?,?,?)
//				select * from dual
		
		
//				PreparedStatement
//			2-4.SQL 실행 : pstmt.executeUpdate();
//			2-5.DB 접속 종료:close
			int cnt = 0;
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.33:1521:xe","kitri","kitri");
				String sql = "";
				sql += "insert all \n";
				sql += "into member(id,name,pass,emailid,emaildomain,joindate)\n";
				sql += "values(?,?,?,?,?,sysdate)\n";
				sql += "into member_detail(id,tel1,tel2,tel2,zipcode,address,address_detail)\n";
				sql += "values(?,?,?,?,?,?,?)\n";
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
				
				cnt = pstmt.executeUpdate(); // cnt는 몇개가 조작됐다!!
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
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
		
//		3. response page :2의 결과를 이용하여 응답페이지
//			3-1. insert 성공
//				***님 회원 가입을 축하합니다
//				가입이이디는 XXX이고 이메일은 xxx@xxx.xxx입니다.
//				로그인후 서비스를 이용할 수 있습니다.
//				로그인
//			3-2.insert 실행
//				죄송합니다. 서버문제로 서비스가 원할하지 않습니다.
//				다음에 다시 이용해 주세요.
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<div align = \"center\">");
			if(cnt != 0) { // 성공
				out.print("<strong>"+name+"</strong>님 회원 가입을 축하합니다");				
				out.print("가입이이디는"+id+"이고 이메일은"+emailid+"@"+emaildomain+"입니다.");				
				out.print("로그인후 서비스를 이용할 수 있습니다.<br>");				
				out.print("<a href = '/memberservlet/login/login.html'>로그인</a>");				
			
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
