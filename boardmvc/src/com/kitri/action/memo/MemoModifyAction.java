package com.kitri.action.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class MemoModifyAction implements Action {
	
	
	private static Action memoModifyAction;
	
	static {
		memoModifyAction = new MemoModifyAction();
	}
	
	private MemoModifyAction() {}
	
	

	public static Action getMemoModifyAction() {
		return memoModifyAction;
	}



	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
	}

}
