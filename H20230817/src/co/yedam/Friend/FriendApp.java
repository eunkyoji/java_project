package co.yedam.Friend;

import java.util.Scanner;

public class FriendApp {
	//배열 > 컬랙션 > 파일 > DB
	Friend[] friends = new Friend[10];
	Scanner scn = new Scanner(System.in);
	
	//컨트롤
	public void start() {
		boolean run = true;
		int menu = -1;
		
		while(run) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.print("선택 >> ");
			
			menu = Integer.parseInt(scn.nextLine()); // 3 엔터
			scn.nextLine();
			
			switch(menu) {
				case 1 :
					addFriend();
					break;
				case 2 :
					search();
					break;
				case 3 :
					modify();
					break;
				case 4 :
					remove();
					break;
				case 5 :
					System.out.println("종료합니다.");
					run = false;
					break;
				default :
					System.out.println("잘못된 메뉴입니다.");
					break;
			}
			
		}
	}
	
	//
	private String printString(String msg) {
		System.out.print(msg + " >> ");
		return scn.nextLine();
	}
	
	//등록
	private void addFriend() {
		System.out.println("1.학교 2.회사 3.기타");
		System.out.print("선택 >> ");
		int subMenu = Integer.parseInt(scn.nextLine());
		scn.nextLine();
		
		Friend friend = null;
		
		String name		= printString("이름입력");
		String phone	= printString("연락처입력");
		
		if( subMenu == 1 ) {
			String univ 	= printString("학교입력");
			String major	= printString("전공입력");
			friend = new UnivFriend(name, phone, univ, major);
			
		} else if( subMenu == 2 ) {
			String comp = printString("회사입력");
			String dept = printString("부서입력");
			friend = new CompFriend(name, phone, comp, dept);
			
		} else {
			friend = new Friend(name, phone);
		}
		
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] == null ) {
				friends[i] = friend;
				break;
			}
		}
	}
	
	//조회
	private void search() {
		String name = printString("이름입력");
		System.out.println("name ::: " + name);

		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null && friends[i].getName().equals(name) ) {
				System.out.println(friends[i].showInfo());
				break;
			} else if( friends[i] != null && name.equals("") ){
				System.out.println(friends[i].showInfo());
			}
		}
	}
	
	//수정 : 연락처 수정. 이름으로 검색
	private void modify() {
		String name = printString("이름입력");
		int count = 0;
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null && !name.equals(null) && friends[i].getName().equals(name) ) {
				String phone = printString("전화번호입력");
				if( !phone.equals(phone) ) {
					friends[i].setPhone(phone);
				} else {
					System.out.println("입력되지 않았습니다.");
				}
				count++;
				break;
			}
		}
		
		if( count < 1 ) {
			System.out.println("등록된 이름이 없습니다.");
		}
	}
	
	//삭제
	private void remove() {
		String name = printString("이름입력");
		int count = 0;
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null && !name.equals(null) && friends[i].getName().equals(name) ) {
				friends[i] = null;
				count++;
				break;
			}
		}
		
		if( count < 1 ) {
			System.out.println("등록된 이름이 없습니다.");
		}
	}
}
