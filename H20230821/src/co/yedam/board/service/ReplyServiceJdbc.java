package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.Reply;

public class ReplyServiceJdbc implements ReplyService{
	
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
	public boolean add(Reply reply) {
		conn = Dao.conn();
		query = "INSERT INTO board_reply(reply_no, brd_no, reply_content, reply_writer)"
				+ "VALUES((SELECT NVL(MAX(reply_no), 0) + 1 FROM board_reply WHERE brd_no = ?), ?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, reply.getBrdNo());
			psmt.setInt(2, reply.getBrdNo());
			psmt.setString(3, reply.getReplyContent());
			psmt.setString(4, reply.getReplyWriter());
			
			int r = psmt.executeUpdate();
			if( r == 1) {
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
	public List<Reply> list(int page, int brdNo) {
		List<Reply> list = new ArrayList<Reply>();
		System.out.println("brdNo :: " + brdNo);
		conn = Dao.conn();
		query = "SELECT *"
				+ "FROM ("
				+ "		  SELECT rownum rn, a.* "
				+ "         FROM ("
				+ "				   SELECT * "
				+ "					 FROM board_reply"
				+ "					WHERE brd_no = ?"			
				+ "                 ORDER BY brd_no) a "
				+ "		   WHERE rownum <= (? * 5) ) b "
				+ "WHERE b.rn > (? - 1) * 5 ";
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			psmt.setInt(2, page);
			psmt.setInt(3, page);
			rs = psmt.executeQuery();
			
			while( rs.next() ) {
				Reply reply = new Reply();
				reply.setReplyNo(rs.getInt("reply_no"));
				reply.setBrdNo(rs.getInt("brd_no"));
				reply.setReplyContent(rs.getString("reply_content"));
				reply.setReplyWriter(rs.getString("reply_writer"));
				
				list.add(reply);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return null;
	}

	@Override
	public boolean modify(Reply reply) {
		query = "UPDATE board SET reply_content = ? WHERE reply_no = ? AND brd_no = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, reply.getReplyContent());
			psmt.setInt(2, reply.getReplyNo());
			psmt.setInt(3, reply.getBrdNo());
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
	public boolean remove(int replyNo, int brdNo) {
		query = "DELETE FROM board_reply "
				   + "WHERE reply_no = " + replyNo + " AND brd_no = " + brdNo;
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
	public void save() {
		
	}

	@Override
	public String getResponseUser(int replyNo, int brdNo) {
		conn = Dao.conn();
		query= "SELECT reply_writer FROM board_reply WHERE reply_no = " + replyNo + " AND brd_no = " + brdNo;
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();	// select
			if( rs.next() ) {
				return rs.getString("reply_writer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

	@Override
	public int getTotal() {
		conn = Dao.conn();
		query = "SELECT count(*) cnt FROM board_reply";
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
		return 0;
	}
}
