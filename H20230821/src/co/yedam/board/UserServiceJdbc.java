package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceJdbc implements UserService {
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	
	
	public User checkLogin(User user) {
		conn = Dao.conn();
		query = "SELECT * FROM users WHERE user_id = ? AND user_pw = ?";
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPw());
			rs = psmt.executeQuery();
			
			if( rs.next() ) {
				User nuser = new User();
				nuser.setId(rs.getString("user_id"));
				nuser.setPw(rs.getString("user_pw"));
				nuser.setNm(rs.getString("user_nm"));
				
				return nuser;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
