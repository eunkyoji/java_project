package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.Board;

public class BoardServiceJdbc implements BoardService {

	// Connection 객체.
	// PreparedStatement 객체.
	// ResultSet 객체.
	// String 쿼리.
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;

	void disconn() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean add(Board board) {
		query = "insert into board (brd_no, brd_title, brd_content, brd_writer) "
				+ "values ( (select nvl(max(brd_no), 0) + 1 from board) ,?,?,?)";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, board.getBrdTitle());
			psmt.setString(2, board.getBrdContent());
			psmt.setString(3, board.getBrdWriter());

			int r = psmt.executeUpdate();// insert, update, delete
			if (r == 1) {
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
		query = "select *  " //
				+ "from (select rownum  rn, a.*  " //
				+ "      from (select * from board " //
				+ "            order by brd_no) a " //
				+ "      where rownum <= (? * 5) ) b " //
				+ "where b.rn > (? - 1) * 5";// sql
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, page);
			psmt.setInt(2, page);

			rs = psmt.executeQuery();
			while (rs.next()) {
				// rs -> list
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdWriter(rs.getString("brd_writer"));
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
		query = "select count(*) as cnt from board";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery(); // select
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return 0;
	}

	@Override
	public boolean modify(Board board) {
//		query = "update board set brd_content = '" //
//				+ board.getBrdContent() + "' where brd_no = " + board.getBrdNo();
		query = "update board set brd_content = ? where brd_no = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, board.getBrdContent());
			psmt.setInt(2, board.getBrdNo());
			int r = psmt.executeUpdate();// insert, update, delete
			if (r == 1) {
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
		query = "delete from board where brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate();// insert, update, delete
			if (r == 1) {
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
		query = "select * from board where brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery(); // select
			if (rs.next()) {
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setWriteDate(rs.getDate("write_date"));
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
		query = "select brd_writer from board where brd_no = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery(); // select
			if (rs.next()) {
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
