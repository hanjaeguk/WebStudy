package com.kitri.action.memo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.kitri.action.Action;
import com.kitri.board.model.MemoDto;
import com.kitri.board.model.service.MemoServiceImpl;

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
		int seq = Integer.parseInt(request.getParameter("seq"));
		List<MemoDto> list =MemoServiceImpl.getMemoService().listMemo(seq);
//		System.out.println("메모갯수:"+list.size());
		JSONObject mlist = new JSONObject();
		JSONArray jarray = new JSONArray();
		for(MemoDto mDto : list) {
			JSONObject memo = new JSONObject();
			memo.put("mseq",mDto.getMseq());
			memo.put("seq",mDto.getSeq());
			memo.put("id",mDto.getId());
			memo.put("name",mDto.getName());
			memo.put("mcontent",mDto.getMcontent());
			memo.put("mtime",mDto.getMtime());
			
			jarray.put(memo);
		}
		mlist.put("memolist", jarray);
//		System.out.println(mlist.toString());
		return mlist.toString();
	}

}

