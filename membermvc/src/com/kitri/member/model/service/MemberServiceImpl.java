package com.kitri.member.model.service;

import java.util.List;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.ZipCodeDto;
import com.kitri.member.model.dao.MemberDao;
import com.kitri.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	
	public MemberServiceImpl(){
		memberDao = new MemberDaoImpl();
	}

	@Override
	public int idCheck(String id) {
		return 0;
	}

	@Override
	public List<ZipCodeDto> zipSearch(String doro) {
		return null;
	}

	@Override
	public int register(MemberDetailDto memberDetailDto) {
		return memberDao.register(memberDetailDto);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		return null;
	}

	@Override
	public int modify(MemberDetailDto memberDetailDto) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public int login(String id, String pass) {
		return 0;
	}

}
