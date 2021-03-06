package seil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import seil.util.Util;
import seil.vo.VO;


public class DaoImpl implements IDao {

	@Override
	public int insertBoard(VO boardVo) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
		conn = Util.getConnection();
		String sql ="insert into jdbc_board(board_no, board_title, board_witer, board_datem board_content)"
					+ "values(board_seq.nextval, ?, ?, sysdate, ?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardVo.getBoard_title());
		pstmt.setString(2, boardVo.getBoard_writer());
		pstmt.setString(3, boardVo.getBoard_content());
		cnt = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}finally{
			if(pstmt != null) try{ pstmt.close(); } catch(SQLException e){};
			if(conn != null) try{ conn.close(); } catch(SQLException e){};
		}
		return cnt;
	}
/////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public List<VO> displayAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<VO> boardList = new ArrayList<>();
	try {
		conn = Util.getConnection();
		String sql = "select *from jdbc_board order by board_no desc";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			VO vo = new VO();
			vo.setBoard_no(rs.getInt("board_no"));
			vo.setBoard_title(rs.getString("board_title"));
			vo.setBoard_writer(rs.getString("board_writer"));
			vo.setBoard_date(rs.getString("board_date"));
			vo.setBoard_cnt(rs.getInt("board_cnt"));
			vo.setBoard_content(rs.getString("board_content"));
			boardList.add(vo);
		}
	} catch (SQLException e) {
		boardList = null;
		e.printStackTrace();
	} finally{
		if(rs != null) try{ rs.close(); } catch(SQLException e){};
		if(stmt != null) try{ stmt.close(); } catch(SQLException e){};
		if(conn != null) try{ conn.close(); } catch(SQLException e){};
	}
	return boardList;
}
////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<VO> search(String word) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<VO> boardList = new ArrayList<>();
		
		try {
			conn = Util.getConnection();
			
			String sql = "select * from jdbc_board where board_title like '%" + word + "%'"
							+ "order by board_no desc";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				VO Vo = new VO();
				Vo.setBoard_no(rs.getInt("board_no"));
				Vo.setBoard_title(rs.getString("board_title"));
				Vo.setBoard_writer(rs.getString("board_writer"));
				Vo.setBoard_date(rs.getString("board_date"));
				Vo.setBoard_cnt(rs.getInt("board_cnt"));
				Vo.setBoard_content(rs.getString("board_content"));
				boardList.add(Vo);
				}
			} catch (SQLException e) {
				boardList = null;
				e.printStackTrace();
			} finally{
				if(rs != null) try{ rs.close(); } catch(SQLException e){};
				if(stmt != null) try{ stmt.close(); } catch(SQLException e){};
				if(conn != null) try{ conn.close(); } catch(SQLException e){};
			}
			return boardList;
		}
	
////////////////////////////////////////////////////////////////////////////////////
	@Override
	public VO displayOne(int boardNo) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		VO Vo = new VO();
		
		try {
			conn = Util.getConnection();
			
			String sql = "select * from jdbc_board where board_no = " + boardNo;
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Vo.setBoard_no(rs.getInt("board_no"));
				Vo.setBoard_title(rs.getString("board_title"));
				Vo.setBoard_writer(rs.getString("board_writer"));
				Vo.setBoard_date(rs.getString("board_date"));
				Vo.setBoard_cnt(rs.getInt("board_cnt"));
				Vo.setBoard_content(rs.getString("board_content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null) try{ rs.close(); } catch(SQLException e){};
			if(stmt != null) try{ stmt.close(); } catch(SQLException e){};
			if(conn != null) try{ conn.close(); } catch(SQLException e){};
		}
		return Vo;
	}
/////////////////////////////////////////////////////////////////////////
	@Override
	public int update(VO boardVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt =0;
		
		try {
			conn = Util.getConnection();
			String sql = "update jdbc_board set board_title = ?,"
							+ "board_content = ? where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getBoard_title());
			pstmt.setString(2, boardVO.getBoard_content());
			pstmt.setInt(3, boardVO.getBoard_no());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(pstmt != null) try{ pstmt.close(); } catch(SQLException e){};
			if(conn != null) try{ conn.close(); } catch(SQLException e){};
		}
		return cnt;
	}
		
	//////////////////////////////////////////////////////////////
	@Override
	public int upCnt(int boardNo) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = Util.getConnection();
			String sql = "update jdbc_board set board_cnt = board_cnt + 1 where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(pstmt != null) try{ pstmt.close(); } catch(SQLException e){};
			if(conn != null) try{ conn.close(); } catch(SQLException e){};
		}
		return cnt;
	}
	@Override
	public int deleteBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt =0;
		
		try {
			conn = Util.getConnection();
			
			String sql = "delete from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(pstmt != null) try{ pstmt.close(); } catch(SQLException e){};
			if(conn != null) try{ conn.close(); } catch(SQLException e){};
		}
		return cnt;
	}

}




