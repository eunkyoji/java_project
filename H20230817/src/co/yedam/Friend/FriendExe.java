package co.yedam.Friend;

public class FriendExe {
	public static void main(String[] args) {
		//name, phone
		// 배열선언[5]. 인스턴스 3명
		// name = "홍길동";
		
		Friend[] friends = new Friend[5];
		
		friends[0] = new Friend("홍길동", "010-1111-1111");
		friends[1] = new Friend("박수민", "010-2222-2222");
		friends[2] = new Friend("정재륜", "010-3333-3333");
		
		String name = "홍길동";
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null && friends[i].getName().equals(name) ) {
				System.out.println(friends[i].showInfo());
			}
		}
		
		
	}
}
