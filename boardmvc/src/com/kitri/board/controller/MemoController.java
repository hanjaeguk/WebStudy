package com.kitri.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.factory.BoardActionFactory;
import com.kitri.util.BoardConstance;

@WebServlet("/memo")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		response.setContentType("application/x-json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String path = "/index.jsp";
		
		String list = "";
		if("writememo".equals(act)) {
			list = BoardActionFactory.getMemoWriteAction().excute(request, response);
		} else if("listmemo".equals(act)) {
			list = BoardActionFactory.getMemoListAction().excute(request, response);
		} else if("modifymemo".equals(act)) {
			list = BoardActionFactory.getMemoModifyAction().excute(request, response);
		} else if("deletememo".equals(act)) {
			list = BoardActionFactory.getMemoDeleteAction().excute(request, response);
		}
		out.println(list);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.ENCODER);
		doGet(request, response);
	}

}
