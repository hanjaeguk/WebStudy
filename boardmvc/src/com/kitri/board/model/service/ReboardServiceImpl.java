package com.kitri.board.model.service;

import java.util.List;

import com.kitri.board.model.ReboardDto;
import com.kitri.board.model.dao.CommonDaoImpl;
import com.kitri.board.model.dao.ReboardDaoImpl;

public class ReboardServiceImpl implements ReboardService {
	
	private static ReboardService reboardService;
	
	static {
		reboardService = new ReboardServiceImpl();
	}
	
	private ReboardServiceImpl() {}

	public static ReboardService getReboardService() {
		return reboardService;
	}

	

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		int seq = CommonDaoImpl.getCommonDao().getNextSeq();
		reboardDto.setSeq(seq);
		reboardDto.setRef(seq);
		return ReboardDaoImpl.getReboardDao().writeArticle(reboardDto);
		
	}

	@Override
	public List<ReboardDto> listArticle(int bcode, int pg, String key, String word) {
		return null;
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		return null;
	}

	@Override
	public int replyArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public ReboardDto getArticle(int seq) {
		return null;
	}

	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public int deleteArticle(int seq) {
		return 0;
	}

}
