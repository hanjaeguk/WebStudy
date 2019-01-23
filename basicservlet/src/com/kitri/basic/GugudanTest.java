package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gt")
public class GugudanTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int dan = Integer.parseInt(request.getParameter("dan"));
		
		
		out.println("<html>");
		out.println("	<body>");
		out.println("		<div align = \"center\">");
		out.println("			"+dan+"단<br>");
		for(int k=1; k<10; k++){
			out.println(dan+"*"+k+"="+dan*k+"<br>");
		}
		out.println("		</div>");
		out.println("	</body>");
		out.println("</html>");

		


	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

}
