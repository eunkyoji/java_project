package co.yedam.Friend;

public class Friend {
	//친구 연락처 정보.
	
	//학교친구 -- 이름, 연락처, 학교이름, 전공정보
	//회사친구 -- 이름, 연락처, 회사명, 부서정보
	//친구    -- 이름, 연락처
	
	//Friend -- 이름, 연락처
	//UnivFriend -- 학교, 전공
	//CompFriend -- 회사, 부서
	//FriendApp  -- C(reate)R(ead)U(pdate)D(elete)
	//MainExe    -- main 클래스
	
	private String name;
	private String phone;
	
	public Friend(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	// getter/setter
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String showInfo() {
		return "이름 : " + name + ", 연락처 : " + phone;
	}
}
