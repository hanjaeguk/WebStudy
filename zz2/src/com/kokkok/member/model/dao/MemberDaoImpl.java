package com.kokkok.member.model.dao;

import java.util.List;
import java.util.Map;

import com.kokkok.member.model.MemberDto;

public class MemberDaoImpl implements MemberDao {

	@Override
	public int idCheck(String id) {
		return 0;
	}

	@Override
	public int register(MemberDto memberDto) {
		return 0;
	}

	@Override
	public MemberDto getMember(String id) {
		return null;
	}

	@Override
	public int modify(MemberDto memberDto) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public MemberDto login(Map<String, String> map) {
		return null;
	}

	@Override
	public List<MemberDto> memberList(Map<String, String> map) {
		return null;
	}

}
