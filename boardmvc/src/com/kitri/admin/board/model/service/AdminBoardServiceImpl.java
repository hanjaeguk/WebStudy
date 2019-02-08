package com.kitri.admin.board.model.service;

import java.util.List;

import com.kitri.admin.board.model.BoardListDto;
import com.kitri.admin.board.model.dao.AdminBoardDaoImpl;

public class AdminBoardServiceImpl implements AdminBoardService {
	
	private static AdminBoardServiceImpl adminBoardServiceImpl;
	
	static {
		adminBoardServiceImpl = new AdminBoardServiceImpl();
	}
	
	private AdminBoardServiceImpl() {}

	public static AdminBoardServiceImpl getAdminBoardServiceImpl() {
		return adminBoardServiceImpl;
	}



	@Override
	public List<BoardListDto> getBoardMenu() {
		return AdminBoardDaoImpl.getAdminBoardDaoImpl().getBoardMenu();
	}

}
