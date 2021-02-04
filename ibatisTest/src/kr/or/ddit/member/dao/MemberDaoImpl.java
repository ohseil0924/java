package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapUtil;
import kr.or.ddit.vo.MemberVO;

//싱글톤--------------------------------------------------
public class MemberDaoImpl implements IMemberDao {
	private SqlMapClient smc;

	// 1번 생성자
	private static MemberDaoImpl dao;

	// 2번 생성자
	private MemberDaoImpl() {
		smc = SqlMapUtil.getSqlMapClient();
	}

	// 3번 외부접근 public
	public static MemberDaoImpl getInstance() {
		if (dao == null)
			dao = new MemberDaoImpl();
		return dao;
	}
//싱글톤--------------------------------------------------

//---------------------------------------------------------------------------
	@Override
	public int insertMember(MemberVO memVo) {

		int cnt = 0;
		try {
			Object obj = smc.insert("mymember.insertMember", memVo);
			if (obj == null)
				cnt = 1; // insert 성공 여부 판단

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

//----------------------------------------------------------------------------
	@Override
	public int deleteMember(String memId) {

		int cnt = 0;

		try {
			cnt = smc.delete("mymember.deleteMember", memId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

//-----------------------------------------------------------------------------
	@Override
	public int updateMember(MemberVO memVo) {

		int cnt = 0;

		try {
			cnt = smc.update("mymember.updateMember", memVo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

//--------------------------------------------------------------------------
	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> memList = null;

		try {

			memList = smc.queryForList("mymember.getAllMember");

		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}
		return memList;
	}

//---------------------------------------------------------------------------
	@Override
	public int getMemberCount(String memId) {

		int count = 0;

		try {

			count = (int) smc.queryForObject("mymember.getMemberCount", memId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

//-----------------------------------------------------------------------------	
	/*
	 * @Override public int updateMember2(String updateData, String updateField,
	 * String memId) { Connection conn = null; PreparedStatement pstmt = null;
	 * 
	 * int cnt = 0;
	 * 
	 * try { conn = DBUtil3.getConnection();
	 * 
	 * int num;
	 * 
	 * String sql = "UPDATE MYMEMBER SET " + updateField + "  = ? " +
	 * " WHERE MEM_ID = ? ";
	 * 
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, updateData);
	 * pstmt.setString(2, memId);
	 * 
	 * cnt = pstmt.executeUpdate();
	 * 
	 * 
	 * } catch (SQLException e) { cnt = 0; e.printStackTrace(); }finally{ if(conn !=
	 * null) try{conn.close();} catch(SQLException e){} if(pstmt != null)
	 * try{pstmt.close();} catch(SQLException e){} }
	 * 
	 * return cnt; }
	 */
	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// key값 => 회원 ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		 try {
			 cnt = smc.update("mymember.updateMember2", paramMap);
			 
		 
		 } catch (SQLException e) { cnt = 0; e.printStackTrace(); }
		 
		return 0;
	}

}
