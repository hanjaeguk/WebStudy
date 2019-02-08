package com.kitri.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class ReboardWriteAction implements Action {
	
	private static Action reboardWriteAction;
	
	static {
		reboardWriteAction = new ReboardWriteAction();
	}
	
	private ReboardWriteAction() {}

	public static Action getReboardWriteAction() {
		return reboardWriteAction;
	}

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
	}

}

