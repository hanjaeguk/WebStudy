package com.kitri.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kitri.action.Action;
import com.kitri.board.model.ReboardDto;
import com.kitri.board.model.service.ReboardServiceImpl;
import com.kitri.member.model.MemberDto;

public class ReboardMoveModifyAction implements Action{
	private static Action reboardMoveModifyAction;
	
	static {
		reboardMoveModifyAction = new ReboardMoveModifyAction();
	}
	
	private ReboardMoveModifyAction() {}

	public static Action getReboardMoveModifyAction() {
		return reboardMoveModifyAction;
	}

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
			int seq = Integer.parseInt(request.getParameter("seq"));
			ReboardDto reboardDto =	ReboardServiceImpl.getReboardService().getArticle(seq);
			request.setAttribute("article", reboardDto);
			return "/reboard/modify.jsp";
	
		

	}
}
