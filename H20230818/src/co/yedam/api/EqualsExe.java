package co.yedam.api;

class Member{
	private int memberId;
	private String memberName;
	
	public Member(int memberId, String memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		//return super.toString();
		return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
	}

	@Override
	public int hashCode() {
		//return super.hashCode();
		return memberId;
	}
	
	@Override
	public boolean equals(Object obj) {
		Member target = (Member) obj;
		if(this.memberId == target.memberId && this.memberName.equals(target) ) {
			return true;	// 논리적 동일
		} else {
			return false;
		}
	}
}

public class EqualsExe {
	public static void main(String[] args) {
		String str1 = new String("Hong");
		String str2 = new String("Hong");
		
		Member mem1 = new Member(101, "Hong");
		Member mem2 = new Member(102, "Hwang");
		
		System.out.println(mem1.equals(mem2));
	}
}
