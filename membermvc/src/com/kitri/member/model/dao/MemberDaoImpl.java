package com.kitri.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipCodeDto;
import com.kitri.util.DBConnection;
import com.kitri.util.DBclose;

public class MemberDaoImpl implements MemberDao {

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
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt = 0;

		try {

			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "insert all \n";
			sql += "into member(id,name,pass,emailid,emaildomain,joindate) \n";
			sql += "values(?,?,?,?,?,sysdate) \n";
			sql += "into member_detail(id,tel1,tel2,tel3,zipcode,address,address_detail) \n";
			sql += "values(?,?,?,?,?,?,?) \n";
			sql += "select * from dual";
			pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setString(idx++, memberDetailDto.getId());
			pstmt.setString(idx++, memberDetailDto.getName());
			pstmt.setString(idx++, memberDetailDto.getPass());
			pstmt.setString(idx++, memberDetailDto.getEmailId());
			pstmt.setString(idx++, memberDetailDto.getEmailDomain());
			pstmt.setString(idx++, memberDetailDto.getId());
			pstmt.setString(idx++, memberDetailDto.getTel1());
			pstmt.setString(idx++, memberDetailDto.getTel2());
			pstmt.setString(idx++, memberDetailDto.getTel3());
			pstmt.setString(idx++, memberDetailDto.getZipCode());
			pstmt.setString(idx++, memberDetailDto.getAddress());
			pstmt.setString(idx++, memberDetailDto.getAddressDetail());

			cnt = pstmt.executeUpdate();
			
		//} catch (SQLException e) { //특별하게 SQLException 일때 할게 뭐 없으면 안써도됌!
//			e.printStackTrace();	 //jsp에서 자동으로 catch(모든 예외처리로)를 잡아주기때문에 안해도된다!
		} catch(SQLException e){
			e.printStackTrace();
		}
			finally {
			DBclose.close(conn, pstmt);
		}
		return cnt;
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
	public MemberDto login(Map<String, String> map) {
		return null;
	}

}
