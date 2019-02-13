package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.action.reboard.ReboardListAction;
import com.kitri.action.reboard.ReboardModifyAction;
import com.kitri.action.reboard.ReboardMoveModifyAction;
import com.kitri.action.reboard.ReboardReplyAction;
import com.kitri.action.reboard.ReboardViewAction;
import com.kitri.action.reboard.ReboardWriteAction;

public class BoardActionFactory {

	private static Action reboardWriteAction; 
	private static Action reboardListAction; 
	private static Action reboardViewAction; 
	private static Action reboardReplyAction; 
	private static Action reboardModifyAction; 
	private static Action reboardMoveModifyAction; 
	private static Action reboardDeleteAction; 
	
	static {
		reboardWriteAction = ReboardWriteAction.getReboardWriteAction();
		reboardListAction = ReboardListAction.getReboardListAction();
		reboardViewAction = ReboardViewAction.getReboardViewAction();
		reboardReplyAction = ReboardReplyAction.getReboardReplyAction();
		reboardModifyAction = ReboardModifyAction.getReboardModifyAction();
		reboardMoveModifyAction = ReboardMoveModifyAction.getReboardMoveModifyAction();
	}

	public static Action getReboardMoveModifyAction() {
		return reboardMoveModifyAction;
	}


	public static Action getReboardWriteAction() {
		return reboardWriteAction;
	}


	public static Action getReboardListAction() {
		return reboardListAction;
	}


	public static Action getReboardViewAction() {
		return reboardViewAction;
	}

	
	public static Action getReboardReplyAction() {
		return reboardReplyAction;
	}

	
	public static Action getReboardModifyAction() {
		return reboardModifyAction;
	}

	
	public static Action getReboardDeleteAction() {
		return reboardDeleteAction;
	}

		 
	
}
