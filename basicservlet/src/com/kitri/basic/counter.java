package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/counter")
public class counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int cnt;
	int maxLength;

	public void init() {
		// 서블릿이 호출될때 최초 한번만 실행!!!
		System.out.println("init method 호출!!");
		cnt = 0;
		maxLength = 8;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet method 호출!!");
		cnt++;
		String cntStr = cnt +"";
		int cntLength = cntStr.length();
		int zeroLength = maxLength - cntLength;
		// 당신은 XXX번쨰 방문자 입니다.
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("		<div align = \"center\">");
		out.println("당신은");
		for (int i = 0; i<zeroLength; i++) {
			out.println("<img src = '/basicservlet/img/0.jpg' width = '30'>");			
		}
		
		for (int i = 0; i<cntLength; i++) {
			out.println("<img src = '/basicservlet/img/"+cntStr.charAt(i)+".jpg' width = '30'>");			
		}
		
		out.println("번째 방문자입니다.");
		out.println("		</div>");
		out.println("	</body>");
		out.println("</html>");
		
	}

}
