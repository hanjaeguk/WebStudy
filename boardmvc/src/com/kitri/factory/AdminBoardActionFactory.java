package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.action.admin.board.AdminBoardListAction;
import com.kitri.action.admin.board.AdminBoardMakeAction;
import com.kitri.action.admin.board.AdminCategoryMakeAction;

public class AdminBoardActionFactory {
	
	private static Action adminBoardListAction;
	private static Action adminBoardMakeAction;
	private static Action adminCategorymakeAction;
	
	static {
		adminBoardListAction = AdminBoardListAction.getAdminBoardListAction();
		adminBoardMakeAction = AdminBoardMakeAction.getAdminBoardMakeAction();
		adminCategorymakeAction = AdminCategoryMakeAction.getAdminCategoryMakeAction();
	}

	public static Action getAdminBoardListAction() {
		return adminBoardListAction;
	}

	public static Action getAdminBoardMakeAction() {
		return adminBoardMakeAction;
	}

	public static Action getAdminCategorymakeAction() {
		return adminCategorymakeAction;
	}
	
}
