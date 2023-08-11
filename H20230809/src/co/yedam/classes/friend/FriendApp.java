package co.yedam.classes.friend;

import java.util.*;

//접근지시자(access modifier)
public class FriendApp {

	private Friend[] friends = new Friend[10];
	private Scanner scn = new Scanner(System.in);
	
	int count = 0;

	public FriendApp() {
		
	}

	private void addFriend() {
		System.out.println("이름 연락처 생년월");
		String[] data = scn.nextLine().split(" ");

//		SimpleDateFormat format = new SimpleDateFormat("yymmdd");
//		Date birth = null; //String => Date
//		try {
//			birth = format.parse(data[2]);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		final int num  = 0;//final을 선언하면 값을 변경 할 수 없다.
		//num =  1;
		
		Friend friend = new Friend(data[0], data[1], data[2]);

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
	}// addFriend End

	private void list() {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].toString());
			}
		}
	}
	
	private void findFriend() {
		System.out.println("조회 할 친구의 이름을 입력하세요.");
		String name = scn.nextLine();
		count = 0;
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null && friends[i].getName().equals(name) ) {
				System.out.println(friends[i].toString());
				count++;
				break;
			}
		}
		
		if( count < 1 ) {
			System.out.println("등록된 친구목록에 없습니다.");
		}
	}
	
	private void editFriend() {
		System.out.println("수정 할 친구의 이름을 입력하세요.");
		String name = scn.nextLine();
		
		count = 0;
		for( int i = 0; i < friends.length; i++ ) {
			if(friends[i] != null && friends[i].getName().equals(name) ) {
				System.out.println("수정 할 전화번호를 입력하세요.");
				String phon = scn.nextLine();
				friends[i].setPhone(phon);
				
				System.out.println("정상 처리 되었습니다.");
				count++;
				break;
			}
		}
		if( count < 1 ) {
			System.out.println("친구목록 등록되어 있지 않습니다.");
		}
	}
	
	private void delFriend() {
		System.out.println("삭제 할 친구 이름을 입력하세요.");
		String name = scn.nextLine();
		
		count = 0;
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null && friends[i].getName().equals(name) ) {
				friends[i] = null;
				
				count++;
				System.out.println("정상 처리 되었습니다.");
				break;
			}
		}
		
		if( count < 1 ) {
			System.out.println("친구목록 등록되어 있지 않습니다.");
		}
	}
	
	//private 선언 시 외부에서 접근 불가능 
	//static void start() {
	//public void 는 다른 패키지에서도 사용 할수 있도록 해줌
	//void, 또는 기본으로 선언되었을 경우 다른 패키지에서 접근 불가
	public void start() {	
		FriendApp app = new FriendApp();
		Scanner scn = app.scn;
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.조회(이름) 4.수정 5.삭제 9.종료");
			System.out.println("선택 >> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
				case Menu.ADD :
					app.addFriend();
					break;
				case Menu.LIST :
					app.list();
					break;
				case Menu.SEARCH :
					app.findFriend();
					break;
				case Menu.EDIT :
					app.editFriend();
					break;
				case Menu.DEL :
					app.delFriend();
					break;
				case Menu.EXIT :
					run = false;
					System.out.println("종료합니다.");
					break;
			}	// end of switch
		}	// end of while
	}	// end of start

}
