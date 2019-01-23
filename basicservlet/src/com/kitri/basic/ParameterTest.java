package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/param")
public class ParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	http://localhost/basicservlet/param?name=Hanjaeguk&gender=on
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET방식!!"); // GET은 주소로 넘어옴!
//		1.data GET(이름,성별)
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
//		2.logic(남:파란색, 여:주황색)
		String color = "cyan";
		if(gender.equals("여")) {
			color = "orange";
		}
		
//		3.response page(html)
//			xxx님 안녕하세요.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("		<div align = \"center\">");
		out.println("			<font color = '"+color+"'>"+name+"</font>님 안녕하세요.");
		out.println("		</div>");
		out.println("	</body>");
		out.println("</html>");

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST방식!!");
//		1.data GET(이름,성별)
//		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8"); //GET 방식 한글처리방법!!!
		request.setCharacterEncoding("UTF-8"); // POST방식 한글처리방법!!
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
//		2.logic(남:파란색, 여:주황색)
		String color = "cyan";
		if(gender.equals("여")) {
			color = "orange";
		}
		
//		3.response page(html)
//			xxx님 안녕하세요.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("		<div align = \"center\">");
		out.println("			<font color = '"+color+"'>"+name+"</font>님 안녕하세요.");
		out.println("		</div>");
		out.println("	</body>");
		out.println("</html>");
	}

}



//Tomcat 7이하 한글처리!!(get 방식!!!!)
//
//String name = request.getParameter("name");
//byte b[] = name.getBytes("ISO-8859-1"); //바이트 배열로 이상한 글자를 다시 쪼개라!!
//name = new Sting(b,"UTF-8"); // 다시 ISO가 바이트로 쪼개논 한글을 UTF-8로 합쳐서 제대로 만들어라!! 
//
//public static String isoToUtf(String tmp) {
//	String utf = "";
//	if(tmp != null) {
//		utf = new String(tmp.getBytes("ISO-8859-1"),"UTF-8");
//	}
//	return utf;		
//}














