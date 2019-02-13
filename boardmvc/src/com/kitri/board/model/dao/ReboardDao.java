package com.kitri.board.model.dao;

import java.util.List;
import java.util.Map;

import com.kitri.board.model.ReboardDto;

public interface ReboardDao {
	int writeArticle(ReboardDto reboardDto);
	List<ReboardDto>listArticle(Map<String,String> map);
	ReboardDto viewArticle(int seq);
	int replyArticle(ReboardDto reboardDto);
	int modifyArticle(ReboardDto reboardDto);
	int deleteArticle(int seq);
}
