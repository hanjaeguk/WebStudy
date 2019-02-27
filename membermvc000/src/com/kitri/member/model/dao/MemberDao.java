package com.kitri.member.model.dao;

import java.util.List;
import java.util.Map;

import com.kitri.member.model.*;

public interface MemberDao {
	
	//ID중복검사 주소 회원가입
		public int idCheck(String id);
		public List<ZipCodeDto> zipSearch(String address);
		public int register(MemberDetailDto memberDetailDto);
		
		
		//회원 수정 삭제
		public MemberDetailDto getMember(String id);
		public int modify(MemberDetailDto memberDetailDto);
		public int delete(String id);
		
		
		//로그인 //인자값으로 MemberDto 가능  
		public MemberDto login(Map<String,String> map);
		
		
		public List<MemberDetailDto> memberList(Map<String, String> map);

}
