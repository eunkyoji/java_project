package co.yedam.board.vo;

public class User {
	private String userId;
	private String userPw;
	private String userNm;

	public User() {
	}

	public User(String userId, String userPw, String userNm) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userNm = userNm;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

}
