package com.kitri.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class ReboardReplyAction implements Action {
	
	private static Action reboardReplyAction;
	
	static {
		reboardReplyAction = new ReboardReplyAction();
	}
	
	private ReboardReplyAction() {}

	public static Action getReboardReplyAction() {
		return reboardReplyAction;
	}



	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
	}

}

