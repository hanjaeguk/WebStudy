package com.kokkok.member.model.service;

import java.util.List;

import com.kokkok.member.model.dao.MemberDaoImpl;
import com.kokkok.member.model.MemberDto;
import com.kokkok.member.model.dao.MemberDao;

public class MemberServiceImpl implements MemberService{
	
	private MemberDao memberDao;
	
	public MemberServiceImpl(){
		memberDao = new MemberDaoImpl();
	}

	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int register(MemberDto memberDto) {
		
		return memberDao.register(memberDto);
	}

	@Override
	public MemberDto getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDto login(String id, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDto> memberList(String key, String word) {
		// TODO Auto-generated method stub
		return null;
	}

}
