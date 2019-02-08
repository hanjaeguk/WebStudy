package com.kitri.admin.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.factory.AdminBoardActionFactory;
import com.kitri.util.BoardConstance;
import com.kitri.util.PageMove;

@WebServlet("/adminboard")
public class AdminBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
	
		String path = "/index.jsp";
		
		if("boardmenu".equals(act)) {
			path = AdminBoardActionFactory.getAdminBoardListAction().excute(request, response);
			PageMove.forward(request, response, path);
		} else if("".equals(act)) {
			
		} else if("categortmake".equals(act)) {
			path = AdminBoardActionFactory.getAdminCategorymakeAction().excute(request, response);
			PageMove.forward(request, response, path);
		} else if("".equals(act)) {
			
		} else if("boardmake".equals(act)) {
			path = AdminBoardActionFactory.getAdminBoardMakeAction().excute(request, response);
			PageMove.forward(request, response, path);
		} else if("".equals(act)) {
			
		}
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.ENCODER);
		doGet(request, response);
	}

}
