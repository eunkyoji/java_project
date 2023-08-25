package co.yedam.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FriendApp {
	//추가, 수정, 삭제, 목록
	Map<String, String> userList = new HashMap<>();
	
	List<Friend> friends = new ArrayList<Friend>();
	Scanner scn = new Scanner(System.in);
	
	private boolean userCheck() {
		System.out.println("아이디를 입력하세요 >>");
		String id = scn.nextLine();
		System.out.println("비밀번호를 입력하세요 >>");
		String pw = scn.nextLine();
		
		boolean boo = true;
		Set<String> keyset = userList.keySet();
		if( userList.containsKey(id) ) {
			if( userList.get(id).equals(pw) ) {
				boo = true;
			} else {
				boo = false;
			}
		}
		
		System.out.println("boo : " + boo);
		return boo;
	}
	
	//생성자
	public FriendApp() {
		userList.put("user1", "1234");
		userList.put("user2", "5678");
		userList.put("user3", "9087");
	}
	
	public void start() {
		
		boolean run = true;
		while(true) {
			if(userCheck()) {
				break;
			}
			System.out.println("로그인 실패...");
		}
		while(run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("선택 >> ");
			int menu = -1;
			
			try {
				menu = scn.nextInt();
			} catch(Exception e) {
				System.out.println("메뉴를 다시 선택하세요.");
				continue;
			} finally {
				scn.nextLine();
			}
			scn.nextLine();
			
			switch(menu) {
				case 1 :
					add();
					break;
				case 2 :
					edit();
					break;
				case 3 :
					del();
					break;
				case 4 :
					list();
					break;
				case 5 :
					System.out.println("종료합니다.");
					run = false;
					break;
				default :
					System.out.println("잘 못 입력하셨습니다.");
					break;
			}
		}
	}
	
	private void add() {
		System.out.println("이름을 입력하세요.");
		String name = scn.nextLine();
		System.out.println("전화번호를 입력하세요.");
		String phone = scn.nextLine();
		System.out.println("생년월일을 입력하세요.(ex:1999-12-21)");
		String bir = scn.nextLine();
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birth = null;
		try {
			birth = sdf.parse(bir);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Friend firend = new Friend(name, phone, birth);
		
		friends.add(firend);
	}
	
	private void edit() {
		System.out.println("수정 할 친구 이름을 입력하세요.");
		String name = scn.nextLine();
		
		int count = 0;
		for( int i = 0; i < friends.size(); i++ ) {
			if( friends.get(i).getName().equals(name) ) {
				System.out.println("변경 할 전화번호를 입력하세요.");
				String phone = scn.nextLine();
				friends.get(i).setPhone(phone);
				count++;
				break;
			}
		}
		
		if( count < 1 ) {
			System.out.println("등록된 친구가 없습니다.");
		} else {
			System.out.println("정상 처리 되었습니다.");
		}
	}
	
	private void del() {
		System.out.println("삭제 할 친구 이름을 입력하세요.");
		String name = scn.nextLine();
		
		int count = 0;
		for( int i = 0; i < friends.size(); i++ ) {
			if( friends.get(i).getName().equals(name) ) {
				friends.remove(i);
				break;
			}
		}
	}
	
	private void list() {
		for( Friend fri : friends) {
			//System.out.printf("이름 : %s, 연락처 : %s, 생년월일 : %t \n", fri.getName(), fri.getPhone(), fri.getBirth());
			System.out.println(fri.toString());
		}
//		for( int i = 0; i < friends.size(); i++ ) {
//			System.out.println("이름 : " + friends.get(i).getName() + ", 연락처 : " + friends.get(i).getPhone() + ", 생년월일 : " + friends.get(i).getBirth());
//		}
	}
}
