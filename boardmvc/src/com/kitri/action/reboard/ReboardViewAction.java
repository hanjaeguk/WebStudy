package com.kitri.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class ReboardViewAction implements Action {
	
	private static Action reboardViewAction;
	
	static {
		reboardViewAction = new ReboardViewAction();
	}
	
	private ReboardViewAction() {}

	public static Action getReboardViewAction() {
		return reboardViewAction;
	}


	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
	}

}