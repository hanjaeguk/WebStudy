package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/multiparam")
public class multiparameter extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/*
	 * 응답화면
	 * 한재국(20대)(10대일경우만 빨간색)님이 좋아하는과일은 사과, 포도, 딸기입니다.
	 * 										 포도 입니다.
	 * 										 없습니다.
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String[] fruit = request.getParameterValues("fruit");

		String color = "blue";
		if(age.equals("10")) {
			color = "red";
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div align = \"center\">");
		out.println(name+"(<font color = '"+color+"'>"+age+"</font>)님이 좋아하는 과일은 ");
		if(fruit != null) {
			out.print(fruit[0]);
				for(int i = 1; i < fruit.length;i++) {
					out.print(", "+fruit[i]);
//					if(i != fruit.length-1) {
//						out.print(", ");
//					}
				}
				out.println("입니다.");	
		}else {
			out.println("없습니다.");	
		}
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}




}
