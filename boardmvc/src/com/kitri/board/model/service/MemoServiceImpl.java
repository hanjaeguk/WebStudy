package com.kitri.board.model.service;

import java.util.List;

import com.kitri.board.model.MemoDto;
import com.kitri.board.model.dao.MemoDao;
import com.kitri.board.model.dao.MemoDaoImpl;

public class MemoServiceImpl implements MemoService {
	
	private static MemoServiceImpl memoService;
	
	static {
		memoService = new MemoServiceImpl();
	}
	
	private MemoServiceImpl() {}
	
	

	
	@Override
	public void writeMemo(MemoDto memoDto) {
		MemoDaoImpl.getMemoDao().writeMemo(memoDto);
	}
	
	

	public static MemoServiceImpl getMemoService() {
		return memoService;
	}


	@Override
	public List<MemoDto> listMemo(int seq) {
		// TODO Auto-generated method stub
		return MemoDaoImpl.getMemoDao().listMemo(seq);
	}

	@Override
	public void modifyMemo(MemoDto memoDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMemo(int mseq) {
		// TODO Auto-generated method stub

	}

}
