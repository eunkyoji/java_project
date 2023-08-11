package co.yedam.classes.friend;

import java.util.Date;

//public class Friend extends Object{	// 모든 class는 Object라는 class를 상속 받아서 생성된다.
public class Friend{
	private String	name;
	private String	phone;
	//private Date	birth;
	private String	birth;
	
	public Friend(String name, String phone, String birth) {
		//super();	//부모 class
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + ", birth=" + birth + "]";
	}
	
}
