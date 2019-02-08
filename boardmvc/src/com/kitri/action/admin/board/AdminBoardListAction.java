package com.kitri.action.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.admin.board.model.BoardListDto;
import com.kitri.admin.board.model.service.AdminBoardServiceImpl;

public class AdminBoardListAction implements Action {
	
	private static Action adminBoardListAction;
	
	static {
		adminBoardListAction = new AdminBoardListAction(); // 자기자신에서 생성자 만들어서 static!
	}

	private AdminBoardListAction() {} // 생성자를 private로 해서 외부에서 생성자 못만들게!
	
	public static Action getAdminBoardListAction() {
		return adminBoardListAction;
	}


	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardListDto> list = AdminBoardServiceImpl.getAdminBoardServiceImpl().getBoardMenu();
		ServletContext application = request.getServletContext();
		application.setAttribute("boardmenu", list);
		return "/admin/board/boardmenu.jsp";
	}

}
