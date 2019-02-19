package com.kitri.action.memo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kitri.action.Action;
import com.kitri.board.model.MemoDto;
import com.kitri.board.model.service.MemoServiceImpl;
import com.kitri.member.model.MemberDto;

public class MemoWriteAction implements Action {
	
	private static Action memoWriteAction;
	
	static {
		memoWriteAction = new MemoWriteAction();
	}
	
	private MemoWriteAction() {}
	

	public static Action getMemoWriteAction() {
		return memoWriteAction;
	}




	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			MemoDto memoDto = new MemoDto();
			int seq = Integer.parseInt(request.getParameter("seq"));
			memoDto.setSeq(Integer.parseInt(request.getParameter("seq")));
			memoDto.setMcontent(request.getParameter("mcontent"));
			memoDto.setId(memberDto.getId());
			memoDto.setName(memberDto.getName());
		
			
			
			MemoServiceImpl.getMemoService().writeMemo(memoDto);
			
			List<MemoDto> list =MemoServiceImpl.getMemoService().listMemo(seq);
			System.out.println("메모갯수:"+list.size());
		}
		
		return null;
	}

}

