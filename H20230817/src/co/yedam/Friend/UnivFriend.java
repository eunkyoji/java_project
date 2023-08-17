package co.yedam.Friend;

public class UnivFriend extends Friend {
	private String univ;
	private String najor;
	
	public UnivFriend(String name, String phone, String univ, String najor) {
		super(name, phone);
		this.univ = univ;
		this.najor = najor;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getNajor() {
		return najor;
	}

	public void setNajor(String najor) {
		this.najor = najor;
	}
	
	@Override
	public String showInfo() {
		// TODO Auto-generated method stub
		return super.showInfo() + ", 학교 : " + univ + ", 전공 : " + najor;
	}
}
