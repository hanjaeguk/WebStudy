package com.kitri.member.model.dao;

import java.util.List;
import java.util.Map;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipCodeDto;

public interface MemberDao {
	
	int idCheck(String id);
	List<ZipCodeDto> zipSearch(String doro);
	int register(MemberDetailDto memberDetailDto);
	
	MemberDetailDto getMember(String id);
	int modify(MemberDetailDto memberDetailDto); // 회원정보 수정
	int delete(String id); // 회원탈퇴
	
	
	// MemberDto login(String id,String pass); 
	MemberDto login(Map<String,String> map); //나중에 마이바티스는 인자를 하나밖에 못받아서 이렇게 해줌!
}
