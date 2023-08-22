package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceJdbc implements BoardService{

	// Connection 객체 - DB 접근 객체
	// PreparedStatment 객체 - Query 실행을 위한 객체
	// ResultSet 객체 - 조회한 정보를 담아 놓는 객체
	// String query - query를 담아 놓기 위한 변수
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	
	
	@Override
	public boolean add(Board board) {
		return false;
	}

	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<Board>();
		conn = Dao.conn();
		query = "SELECT * FROM board";
		try {
			psmt = conn.prepareStatement(query);
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
		}
		return list;
	}

	@Override
	public int getTotal() {
		return 0;
	}

	@Override
	public boolean modify(Board board) {
		query = "UPDATE board SET brd_content = '" + board.getBrdContent() + "' WHERE brd_no = " + board.getBrdNo();
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate();
			if( r == 1 ) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		}
		return null;
	}

	@Override
	public void save() {
		
	}
	
}
