package com.kitri.member.model.service;

import java.util.List;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipCodeDto;

public interface MemberService {
	int idCheck(String id);
	List<ZipCodeDto> zipSearch(String doro);
	int register(MemberDetailDto memberDetailDto);
	
	MemberDetailDto getMember(String id);
	int modify(MemberDetailDto memberDetailDto); // 회원정보 수정
	int delete(String id); // 회원탈퇴
	
	MemberDto login(String id,String pass);
	
	List<MemberDetailDto> memberList(String key, String word);
}
