package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ggd")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("	<body>");
		out.println("		<div align = \"center\">");
		out.println("			<h3>***구구단***</h3>");
		out.println("		<table border = \"1\" width = \"800\" height = \"700\">");
		for(int i=2; i<=9; i++){ 
			String color = i%2 ==0 ? "pink" : "cyan";
			out.println("		<tr>");
			for(int k=1; k<10; k++){
				out.println("<td bgcolor = \""+color+"\"align = \"center\">"+i + "*" + k + "=" + i*k+ "</td>");
			}
		}
		out.println("		</tr>");
		out.println("		<table");
		out.println("		</div>");
		out.println("	</body>");
		out.println("</html>");

	}

}
