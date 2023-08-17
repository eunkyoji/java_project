package co.yedam;

import java.util.Scanner;

public class Ex05 {
	static Friend[] friends = new Friend[10];
	static Scanner scn = new Scanner(System.in);
	
	public static void printMenu() {
		System.out.println("1.추가 2.목록 3.전화번호수정 4.삭제 5.종료");
		System.out.println("선택 >> ");
	}
	
	public static void register() {
		System.out.println("이름을 입력하세요.");
		String name = scn.nextLine();
		System.out.println("전화번호를 입력하세요.");
		String phone = scn.nextLine();
		System.out.println("생년월일을 입력하세요.");
		String birth = scn.nextLine();
		System.out.println("키를 입력하세요.");
		double height = Double.parseDouble(scn.nextLine());
		
		Friend friend = new Friend();
		friend.name = name;
		friend.phone = phone;
		friend.birth = birth;
		friend.height = height;
		
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] == null ) {
				friends[i] = friend;
				
				break;
			}
		}
	}
	
	public static void list() {
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null ) {
				System.out.println("이름 : " + friends[i].getName() + ", 전화번호 : " + friends[i].getPhone() + ", 생년월일 : " + friends[i].getBirth() + ", 키 : " + friends[i].getHeight());
			}
		}
	}
	
	public static void modify() {
		System.out.println("연락처를 수정 할 친구 이름을 입력하세요.");
		String name = scn.nextLine();
		
		int count = 0;
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null && friends[i].getName().equals(name) ) {
				System.out.println("연락처를 입력하세요.");
				String phone = scn.nextLine();
				friends[i].setPhone(phone);
				count++;
				break;
			}
		}
		
		if( count < 1 ) {
			System.out.println("등록된 이름이 없습니다.");
		}
	}
	
	public static void remove() {
		System.out.println("삭세 할 이름을 입력하세요.");
		String name = scn.nextLine();
		
		int count = 0;
		for( int i = 0; i < friends.length; i++ ) {
			if( friends[i] != null && friends[i].getName().equals(name) ) {
				friends[i] = null;
				System.out.println("삭제되었습니다.");
				count++;
				break;
			}
		}
		
		if( count < 1 ) {
			System.out.println("등록된 이름이 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		
		boolean run = true;
		
		while(run) {
			printMenu();
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
				case 1 :
					register();
					break;
				case 2 :
					list();
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
}
