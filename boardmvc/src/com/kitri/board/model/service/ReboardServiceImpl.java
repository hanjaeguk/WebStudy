package com.kitri.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kitri.board.model.ReboardDto;
import com.kitri.board.model.dao.CommonDao;
import com.kitri.board.model.dao.CommonDaoImpl;
import com.kitri.board.model.dao.ReboardDaoImpl;
import com.kitri.util.BoardConstance;

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
		return ReboardDaoImpl.getReboardDao().writeArticle(reboardDto) != 0 ? seq : 0;
		
	}

	@Override
	public List<ReboardDto> listArticle(int bcode, int pg, String key, String word) {
		int end = pg * BoardConstance.LIST_SIZE;
		int start = end - BoardConstance.LIST_SIZE;
		Map<String,String> map = new HashMap<String,String>();
		map.put("bcode", bcode + "");
		map.put("start", start + "");
		map.put("end", end + "");
		map.put("key", key);
		map.put("word", word);
		return ReboardDaoImpl.getReboardDao().listArticle(map);
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		CommonDaoImpl.getCommonDao().updateHit(seq);
		ReboardDto reboardDto =  ReboardDaoImpl.getReboardDao().viewArticle(seq);
		if(reboardDto != null) {
			reboardDto.setContent(reboardDto.getContent().replace("\n", "<br>"));			
		}
		return reboardDto;
	}

	@Override
	public int replyArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public ReboardDto getArticle(int seq) { //이거!! 수정
		ReboardDto reboardDto =  ReboardDaoImpl.getReboardDao().viewArticle(seq);
	
		return reboardDto;
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
