package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.User;

public class UserServiceJdbc implements UserService {

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
	public User checkLogin(User user) {
		query = "select * from users where user_id=? and user_pw=?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserPw());
			rs = psmt.executeQuery(); // select
			if (rs.next()) {
				User nuser = new User();
				nuser.setUserId(rs.getString("user_id"));
				nuser.setUserNm(rs.getString("user_nm"));
				nuser.setUserPw(rs.getString("user_pw"));

				return nuser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

	@Override
	public User checkId(User user) {
		query = "SELECT * FROM users WHERE user_id = " + user.getUserId();
		conn  = Dao.conn();
		
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			if( rs.next() ) {
				User nuser = new User();
				nuser.setUserId(rs.getString("user_id"));
				nuser.setUserPw(rs.getString("user_pw"));
				nuser.setUserId(rs.getString("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean setPassword(User user) {
		query = "UPDATE users SET user_pw = ? WHERE user_id = ?";
		conn = Dao.conn();
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getUserPw());
			psmt.setString(2, user.getUserId());
			
			int r = psmt.executeUpdate();
			if( r == 1 ) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean userSave() {
		// TODO Auto-generated method stub
		return true;
	}

}
