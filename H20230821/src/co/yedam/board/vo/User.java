package co.yedam.board.vo;

import java.io.Serializable;

public class User implements Serializable {
	String id;
	String pw;
	String nm;
	
	public User() {
		
	}
	
	public User(String id, String pw, String nm) {
		super();
		this.id = id;
		this.pw = pw;
		this.nm = nm;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
}
