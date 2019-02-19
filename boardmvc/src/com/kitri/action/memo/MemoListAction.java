package com.kitri.action.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class MemoListAction implements Action {
	
	
	private static Action memoListAction;
	
	static {
		memoListAction = new MemoListAction();
	}
	
	private MemoListAction() {}
	


	public static Action getMemoListAction() {
		return memoListAction;
	}




	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
	}

}

