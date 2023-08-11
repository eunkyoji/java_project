package co.yedam.classes.board;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BoardApp {
	private Board[] boards = new Board[20];
	private Scanner scn = new Scanner(System.in);
	
	int count 	= 0;
	int no		= 1;
	
	public BoardApp() {
		
	}
	
	private void addBoard() {
		System.out.printf("제목을 입력하세요.");
		String title = scn.nextLine();
		
		System.out.printf("이름을 입력하세요");
		String name = scn.nextLine();
		
		System.out.println("내용을 입력하세요");
		String content = scn.nextLine();
		
		// 현재 날짜 구하기
        LocalDate now = LocalDate.now();
        
     // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        
        String date = now.format(formatter);
        
        Board board = new Board(no, title, content, name, date);
        
        for( int i = 0; i < boards.length; i++ ) {
        	if( boards[i] == null ) {
        		boards[i] = board;
        		no++;
        		break;
        	}
        }
	}
	
	private void list() {
		String[] titles = {"글번호", "제목", "작성자", "작성일"};
		for( int t = 0; t < titles.length; t++ ) {
			if( t == 1 ) {
				System.out.printf("%10s", titles[t]);
			} else {
				System.out.printf("%5s", titles[t]);
			}
		}
		
		System.out.println();
		System.out.println("==========================================");
		
		count = 0;
		for( int i = 0; i < boards.length; i++ ) {
			if( boards[i] != null) {
				System.out.printf("%5d %10s %5s %5s", boards[i].getNo(), boards[i].getTitle(),
									boards[i].getName(), boards[i].getDate());
				System.out.println();
				count++;
			}
		}
	}
	
	private void detail() {
		System.out.printf("글 번호를 입력하세요.");
		int num = Integer.parseInt(scn.nextLine());
		count = 0;
		for( int i = 0; i < boards.length; i++) {
			if( boards[i].getNo() == num ) {
				System.out.println(boards[i].toString());
				
				count++;
				break;
			}
		}
		
		if( count < 1 ) {
			System.out.println("등록되지 않은 글번호입니다.");
		}
	}
	
	private void edit() {
		System.out.printf("수정하려는 글 번호를 입력하세요");
		int num = Integer.parseInt(scn.nextLine());
		System.out.println();
		System.out.printf("1.제목수정 2. 내용수정");
		int number = Integer.parseInt(scn.nextLine());
		
		switch(number) {
			case 1 :
			case 2 :
				break;
			default :	
			System.out.println("잘못 입력하셨습니다.");
			System.out.printf("1.제목수정 2. 내용수정");
			number = Integer.parseInt(scn.nextLine());
		}
		
		count = 0;
		for( int i = 0; i < boards.length; i++ ) {
			if( boards[i] != null && boards[i].getNo() == num ) {
				if( number == 1 ) {
					System.out.print("변경할 제목을 입력하세요.");
					String title = scn.nextLine();
					boards[i].setTitle(title);
					count++;
					break;
				} else {
					System.out.print("내용을 입력하세요.");
					String content = scn.nextLine();
					boards[i].setContent(content);
					count++;
					break;
				}
			}
		}
		
		if( count < 1 ) {
			System.out.println("등록되지 않은 글번호입니다.");
		}
	}
	
	private void del() {
		System.out.print("삭제 할 글 번호를 입력하세요.");
		int no = Integer.parseInt(scn.nextLine());
		
		count = 0;
		for( int i = 0; i < boards.length; i++ ) {
			if( boards[i] != null && boards[i].getNo() == no ) {
				boards[i] = null;
				
				no--;
				count++;
				break;
			}
		}
		if( count < 1 ) {
			System.out.println("등록되지 않은 글번호입니다.");
		}
	}
	
	public void start() {
		BoardApp app = new BoardApp();
		Scanner scn = app.scn;
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.상세보기 4.수정 5.삭제 9.종료");
			System.out.println("선택 >> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
				case Menu.ADD :
					addBoard();
					break;
				case Menu.LIST :
					list();
					break;
				case Menu.Detail :
					detail();
					break;
				case Menu.EDIT :
					edit();
					break;
				case Menu.DEL :
					del();
					break;
				case Menu.EXIT :
					run = false;
					System.out.println("프로그램을 종료합니다.");
					break;
			}
		}
	}
}
