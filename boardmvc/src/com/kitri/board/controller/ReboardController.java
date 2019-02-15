package com.kitri.board.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.factory.BoardActionFactory;
import com.kitri.util.BoardConstance;
import com.kitri.util.PageMove;
import com.kitri.util.Validator;


@WebServlet("/reboard")
public class ReboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		int bcode = Validator.notNumberToZero(request.getParameter("bcode"));
		int pg =  Validator.notNumberToOne(request.getParameter("pg"));
		
		String key = Validator.nullToBlank(request.getParameter("key"));
		String word = Validator.nullToBlank(request.getParameter("word"));
		
		String path = "/index.jsp";
		
		String queryString = "?bcode="+bcode+"&pg="+pg+"&key="+key+"&word="+URLEncoder.encode(word, BoardConstance.ENCODER);
		
		if("mvwrite".equals(act)) {
			path = "/reboard/write.jsp"+queryString;
			PageMove.redirect(request, response, path);
			
		} else if("writearticle".equals(act)) {
			path = BoardActionFactory.getReboardWriteAction().excute(request, response);
			path += queryString;
			PageMove.forward(request, response, path);
		} else if("viewarticle".equals(act)) {
			path = BoardActionFactory.getReboardViewAction().excute(request, response);
			path += queryString;
			PageMove.forward(request, response, path);
		} else if("listarticle".equals(act)) {
			path = BoardActionFactory.getReboardListAction().excute(request, response);
			path += queryString;
			PageMove.forward(request, response, path);
			
		} else if("mvmodify".equals(act)) {
			path = BoardActionFactory.getReboardMoveModifyAction().excute(request, response);
			path += queryString;
			PageMove.forward(request, response, path);
			
		} else if("deletearticle".equals(act)) {

			
		} else if("modifyarticle".equals(act)) {
			path = BoardActionFactory.getReboardMoveModifyAction().excute(request, response);
			path += queryString;
			PageMove.forward(request, response, path);
			
		} else if("mvreply".equals(act)) {
			path = BoardActionFactory.getReboardMoveReplyAction().excute(request, response);
			path += queryString;
			PageMove.forward(request, response, path);

		} else if("modifyarticle".equals(act)) {


		} else if("modifyarticle".equals(act)) {

		} else {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.ENCODER);
		doGet(request, response);
	}

}
