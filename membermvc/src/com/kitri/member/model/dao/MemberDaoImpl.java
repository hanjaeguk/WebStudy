package com.kitri.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipCodeDto;
import com.kitri.util.DBConnection;
import com.kitri.util.DBclose;

public class MemberDaoImpl implements MemberDao {

	@Override
	public int idCheck(String id) {
		int cnt = 1; // 존재X 사용가능
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();
//			String sql = "select id \r\n" + 
//						"from member\r\n" + 
//						"where id=?";
			// sql 문장이 길때 버퍼를 쓴다.
			StringBuffer sql = new StringBuffer();
//			sql.append("select id \r\n");
//			sql.append("from member\r\n");
//			sql.append("where id=?");

			sql.append("select count(id) \r\n");
			sql.append("from member\r\n");
			sql.append("where id=?");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			rs.next();
//			if(rs.next()) {
//				cnt = 1; //존재!
//			}
			cnt = rs.getInt(1); // sql 문장을 카운트로해서 int를 받아내야함
		} catch (SQLException e) {
			cnt = 1; // 오류 발생시 아이디를 사용못하게!!
			e.printStackTrace();
		} finally {
			DBclose.close(conn, pstmt, rs);
		}

		return cnt;
	}

	@Override
	public List<ZipCodeDto> zipSearch(String doro) {
		List<ZipCodeDto> list = new ArrayList<ZipCodeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();
			String sql = "select 	new_post_code zipcode, sido_kor sido, gugun_kor gugun, \r\n"
					+ "		nvl(upmyon_kor, ' ') upmyon, doro_kor doro, \r\n"
					+ "		case when building_refer_number != '0'\r\n"
					+ "			then building_origin_number||'-'||building_refer_number \r\n"
					+ "			else trim(to_char(building_origin_number, '99999'))\r\n"
					+ "		end building_number, nvl(sigugun_building_name,' ') sigugun_building_name\r\n"
					+ "from 	postcode\r\n" + "where 	doro_kor like '%'||?||'%'\r\n"
					+ "or 		sigugun_building_name like '%'||?||'%'\r\n";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, doro);
			pstmt.setString(2, doro);

			rs = pstmt.executeQuery();
//			ZipCodeDto zipCodeDto = new ZipCodeDto(); <- 이렇게하면 마지막검색값만 여러개 검색된다.
			while (rs.next()) {
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
		} finally {
			DBclose.close(conn, pstmt, rs);
		}

		return list;
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

			// } catch (SQLException e) { //특별하게 SQLException 일때 할게 뭐 없으면 안써도됌!
//			e.printStackTrace();	 //jsp에서 자동으로 catch(모든 예외처리로)를 잡아주기때문에 안해도된다!
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBclose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		MemberDetailDto memberDetailDto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			StringBuffer sql = new StringBuffer();

			sql.append("select id, name, emailid, emaildomain,tel1,tel2,tel3,zipcode,address,address_detail \r\n");
			sql.append("from member_detail\r\n");
			sql.append("where id = ?");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDetailDto.setId(rs.getString("id"));
				memberDetailDto.setName(rs.getString("name"));
				memberDetailDto.setEmailId(rs.getString("emailid"));
				memberDetailDto.setEmailDomain(rs.getString("emaildomain"));
			}

		} catch (SQLException e) {
			memberDetailDto = null; // set에서 하나라도 예외가 나면!! 객체 안만들고 null해줘야함
			e.printStackTrace();
		} finally {
			DBclose.close(conn, pstmt, rs);
		}

		return memberDetailDto;
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
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			StringBuffer sql = new StringBuffer();

			sql.append("select id, name, emailid, emaildomain \r\n");
			sql.append("from member\r\n");
			sql.append("where id = ? and pass = ?");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, map.get("userid"));
			pstmt.setString(2, map.get("userpass"));

			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
				memberDto.setEmailId(rs.getString("emailid"));
				memberDto.setEmailDomain(rs.getString("emaildomain"));
			}

		} catch (SQLException e) {
			memberDto = null; // set에서 하나라도 예외가 나면!! 객체 안만들고 null해줘야함
			e.printStackTrace();
		} finally {
			DBclose.close(conn, pstmt, rs);
		}
		return memberDto;
	}

	@Override
	public List<MemberDetailDto> memberList(Map<String, String> map) {
		List<MemberDetailDto> list = new ArrayList<MemberDetailDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();

			StringBuffer sql = new StringBuffer();

			sql.append("select m.id, m.name, m.emailid, m.emaildomain, m.joindate, \n");
			sql.append("		d.tel1, d.tel2, d.tel3, d.zipcode, d.address, d.address_detail \n");
			sql.append("from member m, member_detail d \n");
			sql.append("where m.id = d.id ");


			String key = map.get("key");
			String word = map.get("word");


			if (key != null && !key.isEmpty() && word != null && !word.isEmpty()) {
				if (key.equals("address")) {
					sql.append("and address like '%'||?||'%'");
				} else {
					sql.append("and m." + key + " = ?");
				}
			}
			pstmt = conn.prepareStatement(sql.toString());
			if (key != null && !key.isEmpty() && word != null && !word.isEmpty()) {
				pstmt.setString(1, word);
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
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

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBclose.close(conn, pstmt, rs);
		}

		return list;
	}

}
