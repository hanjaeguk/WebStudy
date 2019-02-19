package com.kitri.factory;

import com.kitri.action.Action;
import com.kitri.action.memo.MemoDeleteAction;
import com.kitri.action.memo.MemoListAction;
import com.kitri.action.memo.MemoModifyAction;
import com.kitri.action.memo.MemoWriteAction;
import com.kitri.action.reboard.ReboardListAction;
import com.kitri.action.reboard.ReboardModifyAction;
import com.kitri.action.reboard.ReboardMoveModifyAction;
import com.kitri.action.reboard.ReboardMoveReplyAction;
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
	private static Action reboardMoveReplyAction; 
	
	//댓글
	
	private static Action memoDeleteAction;
	private static Action memoListAction;
	private static Action memoModifyAction;
	private static Action memoWriteAction;
	
	static {
		reboardWriteAction = ReboardWriteAction.getReboardWriteAction();
		reboardListAction = ReboardListAction.getReboardListAction();
		reboardViewAction = ReboardViewAction.getReboardViewAction();
		reboardReplyAction = ReboardReplyAction.getReboardReplyAction();
		reboardModifyAction = ReboardModifyAction.getReboardModifyAction();
		reboardMoveModifyAction = ReboardMoveModifyAction.getReboardMoveModifyAction();
		reboardMoveReplyAction = ReboardMoveReplyAction.getReboardMoveReply();
		
		memoDeleteAction = MemoDeleteAction.getMemoDeleteAction();
		memoListAction = MemoListAction.getMemoListAction();
		memoModifyAction = MemoModifyAction.getMemoModifyAction();
		memoWriteAction = MemoWriteAction.getMemoWriteAction();
		
	}
	
	

	public static Action getMemoDeleteAction() {
		return memoDeleteAction;
	}



	public static Action getMemoListAction() {
		return memoListAction;
	}



	public static Action getMemoModifyAction() {
		return memoModifyAction;
	}



	public static Action getMemoWriteAction() {
		return memoWriteAction;
	}



	public static Action getReboardMoveModifyAction() {
		return reboardMoveModifyAction;
	}

	
	
	public static Action getReboardMoveReplyAction() {
		return reboardMoveReplyAction;
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
