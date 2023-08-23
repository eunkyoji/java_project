package co.yedam.board;

import java.util.List;
import java.util.Scanner;

public class BoardApp {
	Scanner scn = new Scanner(System.in);
	//BoardService service = new BoardServiceImpl();
	BoardService service = new BoardServiceImpl();
	UserService uservice = new UserServiceImpl();
	ReplyService rservice = new ReplyServiceImpl();
	User user = new User();
	String logId;
	
	public void start() {
		
		// id/pw
		
		boolean run = true;
		while(true){
			String id = printString("아이디");
			String pw = printString("비밀번호");
			
			user.setId(id);
			user.setPw(pw);
			user = uservice.checkLogin(user);
			if( user != null ) {
				System.out.println(user.getNm() + "님 환영합니다.");
				logId = id;
				break;
			}
			System.out.println("로그인 실패...");
		}
		
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
			System.out.println("글번호 \t 제목 \t\t\t 작성자\n");
			System.out.println("------------------------------------------");
			for( Board b : list ) {
				System.out.println(b.listInfo());
			}
			System.out.println("------------------------------------------");
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
			System.out.print("조회할 페이지를 입력(exit : 0) >>");
			page = scn.nextInt();
			
			if( page == 0) {
				break;
			}
		}
	}
	
	// 수정
	void modify() {
		String brdNo	= printString("번호입력");
		String userNm 	= service.getResponseUser(Integer.parseInt(brdNo));
		if( userNm.equals(logId) ) {
			String content	= printString("내용입력");
			
			Board brd = new Board();
			brd.setBrdNo(Integer.parseInt(brdNo));
			brd.setBrdContent(content);
			
			if( service.modify(brd) ) {
				System.out.println("정상 수정 되었습니다.");
			} else {
				System.out.println("수정 실패");
			}
		} else {
			System.out.println("권한이 없습니다.");
		}
		
	}
	
	// 삭제
	void remove() {
		String brdNo	= printString("번호입력");
		String userNm 	= service.getResponseUser(Integer.parseInt(brdNo));
		if( userNm.equals(logId) ) {
			if( service.remove(Integer.parseInt(brdNo)) ) {
				System.out.println("정상 삭제 되었습니다.");
			}
		} else {
			System.out.println("권한이 없습니다.");
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
			System.out.println("-----------------------------------------");
			ReplyApp rapp = new ReplyApp(Integer.parseInt(brdNo));
			rapp.start(); // 댓글의 컨트롤 역할.
			System.out.println("-----------------------------------------");
		}
		
		reply(Integer.parseInt(brdNo));
	}
	
	void printReply(int brdNo) {
		int page = 1;
		while(true) {
			List<Reply> list = rservice.list(page, brdNo);
			if( list != null ) {
				for( Reply b : list ) {
					System.out.println(b.toString());
				}
			}	
			// 4 > 1page, 9 > 2page, 19 > 4page
			int totalCnt = rservice.getTotal();
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
			System.out.print("조회할 페이지를 입력(exit : 0) >>");
			
			page = scn.nextInt();
			
			if( page == 0) {
				break;
			}
			
		}
	}
	
	void reply(int brdNo) {
		boolean run = true;
		while(run) {
			System.out.println("1.댓글달기 2. 수정, 3.삭제 9.종료");
			System.out.println("선택 >> ");
			int menu = scn.nextInt();
			scn.nextLine();
			
			switch(menu) {
				case 1 :
					String msg = printString("댓글입력 ");
					Reply reply = new Reply(brdNo, msg, logId);
					rservice.add(reply);
					System.out.println("등록완료!!");
					break;
				case 2 :
					String replyNo	= printString("번호입력");
					String userNm 	= rservice.getResponseUser(Integer.parseInt(replyNo), brdNo);
					if( userNm.equals(logId) ) {
						String content	= printString("내용입력");
						
						Reply rep = new Reply();
						rep.setReplyNo(Integer.parseInt(replyNo));
						rep.setReplyContent(content);
						rep.setBrdNo(brdNo);
						
						if( rservice.modify(rep) ) {
							System.out.println("정상 수정 되었습니다.");
						} else {
							System.out.println("수정 실패");
						}
					} else {
						System.out.println("권한이 없습니다.");
					}
					break;
				case 3 :
					replyNo	= printString("번호입력");
					userNm 	= rservice.getResponseUser(Integer.parseInt(replyNo), brdNo);
					if( userNm.equals(logId) ) {
						if( rservice.remove(Integer.parseInt(replyNo), brdNo) ) {
							System.out.println("정상 삭제 되었습니다.");
						}
					} else {
						System.out.println("권한이 없습니다.");
					}
					break;
				case 9 :
					System.out.println("댓글 종료.");
					run = false;
					break;
				default :
					System.out.println("잘못 입력하셨습니다.");
					break;
			}
		}
		
	}
	
	//원본 글에 대한 댓글번호, 원번글번호, 내용, 작성자
	class ReplyApp{
		private ReplyService rservice = new ReplyServiceImpl();
		private int brdNo;
		
		ReplyApp(int brdNo){
			this.brdNo = brdNo;
		}
		
		void start() {
			boolean run = true;
			while(run) {
				System.out.println("1.댓글달기 2. 수정, 3.삭제 9.종료");
				System.out.println("선택 >> ");
				int menu = scn.nextInt();
				scn.nextLine();
				
				switch(menu) {
					case 1 :
						add();
						break;
					case 2 :
						modifiy();
						break;
					case 3 :
						delete();
						break;
					case 9 :
						System.out.println("댓글 종료.");
						rservice.save();
						run = false;
						break;
					default :
						System.out.println("잘못 입력하셨습니다.");
						break;
				}
			}
		}
		
		
		
		void add() {
			String msg = printString("댓글입력 ");
			Reply reply = new Reply(brdNo, msg, logId);
			rservice.add(reply);
			System.out.println("등록완료!!");
		}
		
		void modifiy() {
			String replyNo	= printString("번호입력");
			String userNm 	= rservice.getResponseUser(Integer.parseInt(replyNo), brdNo);
			if( userNm.equals(logId) ) {
				String content	= printString("내용입력");
				
				Reply rep = new Reply();
				rep.setReplyNo(Integer.parseInt(replyNo));
				rep.setReplyContent(content);
				rep.setBrdNo(brdNo);
				
				if( rservice.modify(rep) ) {
					System.out.println("정상 수정 되었습니다.");
				} else {
					System.out.println("수정 실패");
				}
			} else {
				System.out.println("권한이 없습니다.");
			}
		}
		
		void delete() {
			String replyNo	= printString("번호입력");
			String userNm 	= rservice.getResponseUser(Integer.parseInt(replyNo), brdNo);
			if( userNm.equals(logId) ) {
				if( rservice.remove(Integer.parseInt(replyNo), brdNo) ) {
					System.out.println("정상 삭제 되었습니다.");
				}
			} else {
				System.out.println("권한이 없습니다.");
			}
		}
	}
	
}

