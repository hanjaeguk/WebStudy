package com.kitri.action.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class MemoDeleteAction implements Action {
	
	private static Action memoDeleteAction;
	
	static {
		memoDeleteAction = new MemoDeleteAction();
	}
	
	private MemoDeleteAction() {}
	
	

	public static Action getMemoDeleteAction() {
		return memoDeleteAction;
	}



	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
	}

}
