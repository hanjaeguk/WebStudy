package com.kitri.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.kitri.board.model.ReboardDto;
import com.kitri.board.model.service.ReboardService;
import com.kitri.board.model.service.ReboardServiceImpl;
import com.kitri.util.DBConnection;
import com.kitri.util.DBclose;

public class ReboardDaoImpl implements ReboardDao {
	
	private static ReboardDao reboardDao;
	
	static {
		reboardDao = new ReboardDaoImpl();
	}
	
	private ReboardDaoImpl() {}

	public static ReboardDao getReboardDao() {
		return reboardDao;
	}

	

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert all \n");
			sql.append("	into board(seq,id,name,email,subject,content,hit,logtime,bcode) \n");
			sql.append("	values(?,?,?,?,?,?,?,?,? \n");
			sql.append("	into reboard(rseq,seq,ref,lev,step,pseq,reply) \n");
			sql.append("	values(reboard_rseq.nextval,?,?,0,0,0,0) \n");
			sql.append("select * from dual \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setInt(idx++,reboardDto.getSeq());
			pstmt.setString(idx++,reboardDto.getId());
			pstmt.setString(idx++,reboardDto.getName());
			pstmt.setString(idx++,reboardDto.getEmail());
			pstmt.setString(idx++,reboardDto.getSubject());
			pstmt.setString(idx++,reboardDto.getContent());
			pstmt.setInt(idx++,reboardDto.getBcode());
			pstmt.setInt(idx++,reboardDto.getSeq());
			pstmt.setInt(idx++,reboardDto.getRef());
			
			cnt = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBclose.close(conn, pstmt);
		}
		return cnt;

	}

	@Override
	public List<ReboardDto> listArticle(Map<String, String> map) {
		return null;
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		return null;
	}

	@Override
	public int replyArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public ReboardDto getArticle(int seq) {
		return null;
	}

	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public int deleteArticle(int seq) {
		return 0;
	}

}
