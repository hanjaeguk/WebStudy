package com.kitri.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kitri.board.model.MemoDto;
import com.kitri.util.DBConnection;
import com.kitri.util.DBclose;

public class MemoDaoImpl implements MemoDao {
	
	private static MemoDaoImpl memoDao;
	
	static {
		memoDao = new MemoDaoImpl();
	}
	
	private MemoDaoImpl() {}

	

	public static MemoDaoImpl getMemoDao() {
		return memoDao;
	}




	@Override
	public void writeMemo(MemoDto memoDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into memo(mseq, seq, id, name, mcontent, mtime) \n");
			sql.append("values (memo_mseq.nextval, ?, ?, ?, ?, sysdate)");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, memoDto.getSeq());
			pstmt.setString(2, memoDto.getId());
			pstmt.setString(3, memoDto.getName());
			pstmt.setString(4, memoDto.getMcontent());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBclose.close(conn, pstmt);
		}
	}

	@Override
	public List<MemoDto> listMemo(int seq) {
		List<MemoDto> list = new ArrayList<MemoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select mseq, seq, id, name, mcontent, mtime \n");
			sql.append("from memo \n");
			sql.append("where seq = ? \n");
			sql.append("order by mseq");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemoDto memoDto = new MemoDto();
				memoDto.setMseq(rs.getInt("mseq"));
				memoDto.setSeq(rs.getInt("seq"));
				memoDto.setId(rs.getString("id"));
				memoDto.setName(rs.getString("name"));
				memoDto.setMcontent(rs.getString("mcontent"));
				memoDto.setMtime(rs.getString("mtime"));
				
				list.add(memoDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBclose.close(conn, pstmt,rs);
		}
		
		
		return list;
	}

	@Override
	public void modifyMemo(MemoDto memoDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update memo \n");
			sql.append("set mcontent = ? \n");
			sql.append("where mseq = ? \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, memoDto.getMcontent());
			pstmt.setInt(2, memoDto.getMseq());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBclose.close(conn, pstmt);
		}
	}

	

	@Override
	public void deleteMemo(int mseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete memo \n");
			sql.append("where mseq = ? \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, mseq);		
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBclose.close(conn, pstmt);
		}

	}

}
