package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.Board;

public class BoardServiceJdbc implements BoardService{

	// Connection 객체 - DB 접근 객체
	// PreparedStatment 객체 - Query 실행을 위한 객체
	// ResultSet 객체 - 조회한 정보를 담아 놓는 객체
	// String query - query를 담아 놓기 위한 변수
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	
	
	void disconn() {
		try {
			if( rs != null ) {
				rs.close();
			}
			if( psmt != null ) {
				psmt.close();
			}
			if( conn != null ) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean add(Board board) {
		conn = Dao.conn();
//		query= "INSERT INTO board(brd_no, brd_title, brd_content, brd_writer)"
//				+ "VALUES((SELECT NVL(MAX(brd_no), 0) + 1 FROM board), '" + board.getBrdTitle() + "', '" + board.getBrdContent() + "', '" + board.getBrdWriter() + "'";
		query= "INSERT INTO board(brd_no, brd_title, brd_content, brd_writer)"
				+ "VALUES((SELECT NVL(MAX(brd_no), 0) + 1 FROM board), ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, board.getBrdTitle());
			psmt.setString(2, board.getBrdContent());
			psmt.setString(3, board.getBrdWriter());
			int r = psmt.executeUpdate();
			if( r == 1 ) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return false;
	}

	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<Board>();
		
		conn = Dao.conn();
		query = "SELECT * "
				+ "  FROM "
				+ "    (SELECT rownum rn, a.* "
				+ "    FROM "
				+ "        (SELECT * FROM board "
				+ "          ORDER BY brd_no) a "
				+ "    WHERE rownum <= (? * 5) ) b "
				+ " WHERE b.rn > (? - 1)* 5"; 
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, page);
			psmt.setInt(2, page);
			rs = psmt.executeQuery();
			while(rs.next()) {
				//rs -> list
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
//				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdWriter(rs.getString("brd_writer"));
//				board.setWriteDate(rs.getDate("write_date"));
//				board.setUpdateDate(rs.getDate("update_date"));
				
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	@Override
	public int getTotal() {
		conn = Dao.conn();
		query = "SELECT count(*) cnt FROM board";
		int count = 0;
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			if( rs.next() ) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return count;
	}

	@Override
	public boolean modify(Board board) {
		//query = "UPDATE board SET brd_content = '" + board.getBrdContent() + "' WHERE brd_no = " + board.getBrdNo();
		query = "UPDATE board SET brd_content = ? WHERE brd_no = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, board.getBrdContent());
			psmt.setInt(2, board.getBrdNo());
			int r = psmt.executeUpdate();
			if( r == 1 ) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		query = "DELETE FROM board "
			   + "WHERE brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate(); // insert, update, delete
			if( r == 1 ) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public Board search(int brdNo) {
		query = "SELECT * FROM board WHERE brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();	// select
			
			if( rs.next() ) {
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdWriter(rs.getString("brd_writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setUpdateDate(rs.getDate("update_date"));
				
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

	@Override
	public void save() {
		
	}
	
	@Override
	public String getResponseUser(int brdNo) {
		conn = Dao.conn();
		query= "SELECT brd_writer FROM board WHERE brd_no = " + brdNo;
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();	// select
			if( rs.next() ) {
				return rs.getString("brd_writer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}
	
}
