package com.kitri.member.model.service;

import java.util.*;

import com.kitri.member.model.*;
import com.kitri.member.model.dao.MemberDao;
import com.kitri.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;

	
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	
	}
	
	@Override
	public int idCheck(String id) {
		
		return memberDao.idCheck(id);
	}

	@Override
	public List<ZipCodeDto> zipSearch(String address) {

		return memberDao.zipSearch(address);
	}

	@Override
	public int register(MemberDetailDto memberDetailDto) {
		
		return memberDao.register(memberDetailDto);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		
		return memberDao.getMember(id);
	}

	@Override
	public int modify(MemberDetailDto memberDetailDto) {

		return memberDao.modify(memberDetailDto);
	}

	@Override
	public int delete(String id) {

		return 0;
	}

	@Override
	public MemberDto login(String id, String pass) {
		Map<String, String> map = new HashMap<>();
		map.put("userid", id);
		map.put("userpass", pass);
		
		return memberDao.login(map);
	}

	@Override
	public List<MemberDetailDto> memberList(String key, String word) {
		
		Map<String, String> map = new HashMap<>();
		map.put("key", key);
		map.put("word", word);		
		return memberDao.memberList(map);
	}

}
