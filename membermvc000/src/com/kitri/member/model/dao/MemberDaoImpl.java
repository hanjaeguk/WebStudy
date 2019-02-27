package com.kitri.member.model.dao;

import java.sql.*;
import java.util.*;

import com.kitri.member.model.*;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class MemberDaoImpl implements MemberDao{

	@Override
	public int idCheck(String id) {
		int cnt=1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql= new StringBuffer();
			sql.append("select count(id) \n");
			sql.append("from member \n");
			sql.append("where id = ?");		
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery();
			
			rs.next();
			cnt=rs.getInt(1);			
			
		}catch(Exception e) {
			cnt = 1;
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<ZipCodeDto> zipSearch(String address) {
		List<ZipCodeDto> list = new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn = DBConnection.makeConnection();
			String sql="";
			sql+="select 	new_post_code zipcode, sido_kor sido, gugun_kor gugun, \r\n" + 
					"		nvl(upmyon_kor, ' ') upmyon, doro_kor doro, \r\n" + 
					"		case when building_refer_number != '0'\r\n" + 
					"			then building_origin_number||'-'||building_refer_number \r\n" + 
					"			else trim(to_char(building_origin_number, '99999'))\r\n" + 
					"		end building_number, nvl(SIGUGUN_BUILDING_NAME,' ') sigugun_building_name\r\n" + 
					"from 	postcode\r\n" + 
					"where 	doro_kor like '%'||?||'%'\r\n" + 
					"or 		SIGUGUN_BUILDING_NAME like '%'||?||'%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, address);
			pstmt.setString(2, address);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			
				ZipCodeDto zipCodeDto = new ZipCodeDto();
				zipCodeDto.setZipcode(rs.getString("zipcode"));
				zipCodeDto.setSido(rs.getString("sido"));
				zipCodeDto.setGugun(rs.getString("gugun"));
				zipCodeDto.setUpmyon(rs.getString("upmyon"));
				zipCodeDto.setDoro(rs.getString("doro"));
				zipCodeDto.setBuilding_number(rs.getString("building_number"));
				zipCodeDto.setSigugun_building_name(rs.getString("sigugun_building_name"));
				
				list.add(zipCodeDto);
				
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		
		return list;
	}

	@Override
	public int register(MemberDetailDto memberDetailDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		int cnt=0;
		try{
			String insert="";
			insert+="Insert all \n";
			insert+=" into member(id,name,pass,emailid,emaildomain,joindate)\n";
			insert+=" values(?,?,?,?,?,sysdate)\n";
			insert+=" into member_detail(id,tel1,tel2,tel3,zipcode,address,address_detail)\n";
			insert+=" values(?,?,?,?,?,?,?)\n";
			insert+="select * from dual";

			conn = DBConnection.makeConnection();
			pstmt = conn.prepareStatement(insert);

			int idx=1;
			pstmt.setString(idx++,memberDetailDto.getId());
			pstmt.setString(idx++,memberDetailDto.getName());
			pstmt.setString(idx++,memberDetailDto.getPass());
			pstmt.setString(idx++,memberDetailDto.getEmailId());
			pstmt.setString(idx++,memberDetailDto.getEmailDomain());
			pstmt.setString(idx++,memberDetailDto.getId());
			pstmt.setString(idx++,memberDetailDto.getTel1());
			pstmt.setString(idx++,memberDetailDto.getTel2());
			pstmt.setString(idx++,memberDetailDto.getTel3());
			pstmt.setString(idx++,memberDetailDto.getZipCode());
			pstmt.setString(idx++,memberDetailDto.getAddress());
			pstmt.setString(idx++,memberDetailDto.getAddressDetail());

			cnt = pstmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBClose.close(conn, pstmt);
			}				
		return cnt;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		MemberDetailDto memberDetailDto = null;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt=0;
		
		
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select m.id, m.name, m.pass, m.emailid, m.emaildomain, \n");
			sql.append(" md.tel1, md.tel2, md.tel3, md.zipcode, md.address, md.address_detail \n");
			sql.append(" from member m, member_detail md \n");
			sql.append("where m.id = md.id \n");
			sql.append("and m.id = ?");
			
			DBConnection.getInstance();
			conn = DBConnection.makeConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,id);		
			rs=pstmt.executeQuery();
			
		
			if(rs.next()) {		
				memberDetailDto = new MemberDetailDto();
				memberDetailDto.setId(rs.getString("id"));
				memberDetailDto.setName(rs.getString("name"));
				memberDetailDto.setPass(rs.getString("pass"));
				memberDetailDto.setEmailId(rs.getString("emailid"));
				memberDetailDto.setEmailDomain(rs.getString("emaildomain"));
				memberDetailDto.setTel1(rs.getString("tel1"));
				memberDetailDto.setTel2(rs.getString("tel2"));
				memberDetailDto.setTel3(rs.getString("tel3"));
				memberDetailDto.setZipCode(rs.getString("zipcode"));
				memberDetailDto.setAddress(rs.getString("address"));
				memberDetailDto.setAddressDetail(rs.getString("address_detail"));
				
				cnt++;
				System.out.println(cnt);
			}			
			
		}catch(Exception e) {				
			
		}finally {
			DBClose.close(conn, pstmt, rs);
			
		}
			
		
		return memberDetailDto;
	}

	@Override
	public int modify(MemberDetailDto memberDetailDto) {
		
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;		
	
		
		try {
			conn.setAutoCommit(false);
			StringBuffer sql = new StringBuffer();
			sql.append("update ( \n");
			sql.append(" select m.id, m.name, m.pass, m.emailid, m.emaildomain,\n");
			sql.append(" md.tel1, md.tel2, md.tel3, md.zipcode, md.address, md.address_detail \n");
			sql.append(" from member m, member_detail md \n");
			sql.append(" where m.id = md.id \n");
			sql.append(" and m.id = ?) \n");
			sql.append(" set pass = ?,");
			sql.append(" emailid = ?,");
			sql.append(" emaildomain = ?,");
			sql.append(" tel1 = ?,");
			sql.append(" tel2 = ?,");
			sql.append(" tel3 = ?,");
			sql.append(" zipcode = ?,");
			sql.append(" address = ?,");
			sql.append(" address_detail = ?");			
			
			DBConnection.getInstance();
			conn = DBConnection.makeConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			int idx=1;
			pstmt.setString(idx++, memberDetailDto.getId());
			pstmt.setString(idx++, memberDetailDto.getPass());
			pstmt.setString(idx++, memberDetailDto.getEmailId());
			pstmt.setString(idx++, memberDetailDto.getEmailDomain());
			pstmt.setString(idx++, memberDetailDto.getTel1());
			pstmt.setString(idx++, memberDetailDto.getTel2());
			pstmt.setString(idx++, memberDetailDto.getTel3());
			pstmt.setString(idx++, memberDetailDto.getZipCode());
			pstmt.setString(idx++, memberDetailDto.getAddress());
			pstmt.setString(idx++, memberDetailDto.getAddressDetail());
			
			cnt = pstmt.executeUpdate();
			conn.commit();
		
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			
		}finally {
			DBClose.close(conn, pstmt);
		}	
		
		return cnt;
	}

	@Override
	public int delete(String id) {
		
		return 0;
	}

	@Override
	public MemberDto login(Map<String, String> map) {
		MemberDto memberDto = null;
			

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql= new StringBuffer();
			sql.append("select id, name, emailid, emaildomain \n");
			sql.append("from member \n");
			sql.append("where id = ? and pass = ?");		
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, map.get("userid"));		
			pstmt.setString(2, map.get("userpass"));		
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
				memberDto.setEmailId(rs.getString("emailid"));
				memberDto.setEmailDomain(rs.getString("emaildomain"));
			}			
		}catch(Exception e) {
			memberDto = null;
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}		
		
		return memberDto;
	}

	@Override
	public List<MemberDetailDto> memberList(Map<String,String> map) {
		List<MemberDetailDto> list = new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql= new StringBuffer();
			sql.append("select m.id, m.name, m.emailid, m.emaildomain, m.joindate, \n");
			sql.append("	d.tel1, d.tel2, d.tel3, d.zipcode, d.address, d.address_detail \n");
			sql.append("from member m, member_detail d \n");
			sql.append("where m.id = d.id \n");
			String key = map.get("key");
			String word = map.get("word");
			if(key != null && !key.isEmpty() && word != null & !word.isEmpty()) {
				if(key.equals("address")) {
					sql.append("and d.address like '%'||?||'%' \n");
				}else {
					sql.append("and m." + key + "= ? \n");
				}
				
			}
			pstmt = conn.prepareStatement(sql.toString());	
			if(key != null && !key.isEmpty() && word != null & !word.isEmpty()) {
				pstmt.setString(1, word);
			}				
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDetailDto memberDto = new MemberDetailDto();				
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
				memberDto.setEmailId(rs.getString("emailid"));
				memberDto.setEmailDomain(rs.getString("emaildomain"));
				memberDto.setJoinDate(rs.getString("joindate"));
				memberDto.setTel1(rs.getString("tel1"));
				memberDto.setTel2(rs.getString("tel2"));
				memberDto.setTel3(rs.getString("tel3"));
				memberDto.setZipCode(rs.getString("zipcode"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setAddressDetail(rs.getString("address_detail"));
				list.add(memberDto);
			}			
		}catch(Exception e) {			
			e.printStackTrace();
		}finally {
			DBClose.close(conn, pstmt, rs);
		}		
		
	
		
		
		return list;
	}
	

}
