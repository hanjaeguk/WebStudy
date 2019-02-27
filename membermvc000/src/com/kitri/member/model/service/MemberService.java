package com.kitri.member.model.service;

import java.util.List;

import com.kitri.member.model.*;

public interface MemberService {
	
	
	//ID중복검사 주소 회원가입
	public int idCheck(String id);
	public List<ZipCodeDto> zipSearch(String address);
	public int register(MemberDetailDto memberDetailDto);
	
	
	//회원 수정 삭제
	public MemberDetailDto getMember(String id);
	public int modify(MemberDetailDto memberDetailDto);
	public int delete(String id);
	
	
	//로그인
	public MemberDto login(String id, String pass);
	
	public List<MemberDetailDto> memberList(String key, String word);

}
