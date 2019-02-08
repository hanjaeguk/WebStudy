package com.kitri.action.admin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class AdminBoardMakeAction implements Action {
	
	//싱글톤 패턴
	//1.외부에서 생성자접근 못하게 private로 막아라
	//2.private static으로 자기자신을 리턴
	//3.하나만 만들어되니깐 static으로 객체 생성
	//4.외부에서 접근하게 public의 getter
	
	//2.
	private static Action adminBoardMakeAction;
	
	
	//3.
	static {
		adminBoardMakeAction = new AdminBoardMakeAction();
	}
	
	//1.
	private AdminBoardMakeAction() {}

	//4.
	public static Action getAdminBoardMakeAction() {
		return adminBoardMakeAction;
	}

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
	}

}

