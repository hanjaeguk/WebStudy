package com.kokkok.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.kokkok.member.model.MemberDto;
import com.kokkok.util.DBConnection;
import com.kokkok.util.DBClose;

public class MemberDaoImpl implements MemberDao {

	@Override
	public int idCheck(String id) {
		return 0;
	}

	@Override
	public int register(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int cnt = 0;

		try {

			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "insert into member(id,name,pass,email,joindate,admincode) \n";
			sql += "values(?,?,?,?,sysdate,0) \n";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getName());
			pstmt.setString(3, memberDto.getPass());
			pstmt.setString(4, memberDto.getEmail());

	
			cnt = pstmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
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
