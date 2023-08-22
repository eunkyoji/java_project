package co.yedam.board;

import java.util.List;
import java.util.Scanner;

public class BoardApp {
	Scanner scn = new Scanner(System.in);
	//BoardService service = new BoardServiceImpl();
	BoardService service = new BoardServiceJdbc();
	UserService uservice = new UserServiceImpl();
	User user = new User();
	String logId;
	
	public void start() {
		
		// id/pw
		
		boolean run = true;
//		while(true){
//			String id = printString("아이디");
//			String pw = printString("비밀번호");
//			
//			user.setId(id);
//			user.setPw(pw);
//			
//			if(uservice.checkLogin(user)) {
//				logId = id;
//				break;
//			}
//			System.out.println("로그인 실패...");
//		}
		
		while(run) {
			
			System.out.println("1.글등록 2.목록 3.수정 4.삭제 5.상세조회 9.종료");
			System.out.println("선택 >> ");
			
			int menu = scn.nextInt();
			scn.nextLine();
			
			switch(menu) {
				case 1 :	// 글등록
					register();
					break;
				case 2 :	// 글목록
					boardList();
					break;
				case 3 :	// 글 내용 수정
					modify();
					break;
				case 4 :	// 글 번호 기준 삭제
					remove();
					break;
				case 5 :	// 상세조회
					search();
					break;
				case 9 :	// 종료
					System.out.println("종료합니다.");
					service.save();
					run = false;
					break;
				default :
					System.out.println("잘못 입력하셨습니다.");
					break;
			}
			System.out.println("end of prog");
		}
	}// end of start
	
	private String printString(String msg) {
		System.out.println(msg + " >> ");
		return scn.nextLine();
	} // end of printString
	
	// 등록
	void register() {
		String title	= printString("제목입력");
		String content	= printString("내용입력");
		String writer	= logId;
		
		Board board = new Board(title, content, writer);
		if( service.add(board) ) {
			System.out.println("정상 등록 되었습니다.");
		}
	}
	
	// 목록
	void boardList() {
		int page = 1;
		while(true) {
			List<Board> list = service.list(page);
			System.out.println("글번호 \t 제목 \t\t 작성자\n");
			for( Board b : list ) {
				System.out.println(b.listInfo());
			}
			
			// 4 > 1page, 9 > 2page, 19 > 4page
			int totalCnt = service.getTotal();
			int lastPage = (int) Math.ceil(totalCnt / 5.0);
			String p = "";
			for( int i = 1; i <= lastPage; i++ ) {
				//System.out.printf("%3d", i);
				if( page == i ) {
					p += "[" + i + "]" + "  ";
				} else {
					p += i + "  ";
				}
			}
			System.out.print(p);
			System.out.println();
			System.out.print("조회할 페이지를 입력(exit : 99) >>");
			page = scn.nextInt();
			
			if( page == 99) {
				break;
			}
		}
	}
	
	// 수정
	void modify() {
		String brdNo	= printString("번호입력");
		String content	= printString("내용입력");
		
		Board brd = new Board();
		brd.setBrdNo(Integer.parseInt(brdNo));
		brd.setBrdContent(content);
		
		if( service.modify(brd) ) {
			System.out.println("정상 수정 되었습니다.");
		}
	}
	
	// 삭제
	void remove() {
		String brdNo	= printString("번호입력");
		
		if( service.remove(Integer.parseInt(brdNo)) ) {
			System.out.println("정상 삭제 되었습니다.");
		}
	}
	
	// 상세조회
	void search() {
		String brdNo	= printString("번호입력");
		Board result = service.search(Integer.parseInt(brdNo));
		if( result == null ) {
			System.out.println("없는 번호");
		} else {
			System.out.println(result.showInfo());
		}
	}
}

