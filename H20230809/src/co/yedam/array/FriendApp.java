package co.yedam.array;

import java.util.Scanner;

public class FriendApp {
	static Friend[] friends = new Friend[10];
	static Scanner scn = new Scanner(System.in);
	static String name;
	static String phone;
	static Gender gender;
	
	// boolean checkFriend(String name){}
	public static boolean checkFriend(String name){
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null && friends[i].name.equals(name) ) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void init() {
		for( int i = 0; i < 5; i++ ) {
			Friend f = new Friend();
			f.name = "test" + i;
			f.phone = "010-1234-567" + i;
			f.gender = i % 2 == 0 ? Gender.MEN : Gender.WOMEN;
			
			friends[i] = f;
		}
	}
	
	public static void printMenu() {
		System.out.println("1.추가 2.수정 3.삭제 4.조회 5.전체조회 6.종료");
		System.out.println("선택 >> ");
	}
	
	public static void add(){
		int count = 0;
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null ) {
				count++;
			}
		}
		
		if( count == 10 ) System.out.println("더이상 추가 할 수 없습니다.");
		
		System.out.println("입름을 입력하세요.");
		name = scn.nextLine();
		System.out.println("연락처를 입력하세요.");
		phone = scn.nextLine();
		System.out.println("성별(1:남자, 2:여자)을 선택하세요.");
		
		int choice = Integer.parseInt(scn.nextLine());
		if( choice > 2 ) {
			System.out.println("잘못입력 하셨습니다.");
			System.out.println("성별(1:남자, 2:여자)을 선택하세요.");
			choice = Integer.parseInt(scn.nextLine());
		}
		
		if( choice == 1) {
			gender = Gender.MEN;
		} else {
			gender = Gender.WOMEN;
		}
		
		Friend fnd = new Friend();
		fnd.name = name;
		fnd.phone = phone;
		fnd.gender = gender;
		
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] == null ) {
				friends[i] = fnd;
				break;
			}
		}
		System.out.println("정상적으로 등록되었습니다.");
	}
	
	public static void edit() {
		System.out.println("연락처를 변경할 사람의 이름을 입력하세요.");
		name = scn.nextLine();
		if(!checkFriend(name)) {
			System.out.println("등록된 이름이 없습니다.");
			return;	// 메소드의 실행 중지
		}
		System.out.println("변경할 연락처를 입력하세요.");
		phone = scn.nextLine();
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null ) {
				if( friends[i].name.equals(name) ) {
					friends[i].phone = phone;
					break;
				}
			}
		}
		System.out.println("정상적으로 수정 되었습니다.");
	}
	
	public static void del() {
		System.out.println("삭제 할 사람의 이름을 입력하세요.");
		name = scn.nextLine();
		if(!checkFriend(name)) {
			System.out.println("등록된 이름이 없습니다.");
			return;
		}
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null ) {
				if( friends[i].name.equals(name) ) {
					friends[i] = null;
					break;
				}
			}
		}
		System.out.println("정상적으로 삭제 되었습니다.");
	}
	
	public static void search() {
		System.out.println("조회 할 사람의 이름을 입력하세요.");
		name = scn.nextLine();
		if(!checkFriend(name)) {
			System.out.println("등록된 이름이 없습니다.");
			return;
		}
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null ) {
				if( friends[i].name.equals(name) ) {
					friends[i].showInfo();
					break;
				}
			}
		}
		System.out.println("정상적으로 조회 되었습니다.");
	}
	
	public static void list() {
		if( friends.length > 0 ) {
			for( int i = 0; i < friends.length; i++ ) {
				if( friends[i] != null ) {
					friends[i].briefInfo();
				}
			}
		} else {
			System.out.println("등록된 정보가 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		init();
		
		// 추가, 수정, 삭제, 조회, 목록조회
		boolean run = true;
		
		while(run) {
			printMenu();
			
			int menu = Integer.parseInt(scn.nextLine());
			if( isNumeric(menu) == true ) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요!!");
				continue;
			}
			
			switch(menu) {
				case 1 :	//입력
					add();
					continue;
				case 2 :	// 수정
					edit();
					break;
				case 3 :	//삭제
					del();
					break;
				case 4 :
					search();
					break;
				case 5 :
					list();
					break;
				case 6 :
					System.out.println("정상 종료 되었습니다.");
					run = false;
					break;
				default :
					System.out.println("메뉴를 다시 선택하세요.");
			}
		}
	}

	private static boolean isNumeric(int menu) {
		// TODO Auto-generated method stub
		return false;
	}
}
