package co.yedam.board.control;

import java.util.List;
import java.util.Scanner;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImpl;
import co.yedam.board.service.BoardServiceJdbc;
import co.yedam.board.service.ReplyService;
import co.yedam.board.service.ReplyServiceImpl;
import co.yedam.board.service.UserService;
import co.yedam.board.service.UserServiceImpl;
import co.yedam.board.service.UserServiceJdbc;
import co.yedam.board.vo.Board;
import co.yedam.board.vo.Reply;
import co.yedam.board.vo.User;
import co.yedam.mailing.SendMail;

public class BoardApp {

	Scanner scn = new Scanner(System.in);
	BoardService service = new BoardServiceImpl();
	UserService uservice = new UserServiceImpl();
	
//	BoardService service = new BoardServiceJdbc();
//	UserService uservice = new UserServiceJdbc();
	
	String logId;// 로그인정보 저장.

	public void start() {
		int count = 0;
		while (true) {
			// id/ pw
			String id = printString("id");
			String pw = printString("pass");
			User user = new User();
			user.setUserId(id);
			user.setUserPw(pw);

			user = uservice.checkLogin(user);
			
			if (user != null) {
				System.out.println(user.getUserNm() + ", 환영합니다..");
				logId = id;
				break;
			} else {
				count++;
				System.out.println("로그인 실패..");
			}
			
			if( count == 3 ) {
				System.out.println("아이디 : ");
				String uid = scn.nextLine();
				System.out.println("uid ::: " + uid);
				user.setUserId(uid);
				user.setUserPw("12345");
				uservice.setPassword(user);
				sendMail();
				
				count = 0;
			}
		}

		boolean run = true;
		while (run) {
			System.out.println("1.글등록 2.목록 3.수정 4.삭제 5.상세조회 9.종료");
			System.out.print("선택>> ");

			int menu = scn.nextInt();
			scn.nextLine();

			switch (menu) {
			case 1: // 등록.
				register();
				break;

			case 2: // 목록.
				boardList();
				break;

			case 3: // 수정.
				modify();
				break;

			case 4:
				remove();
				break;

			case 5:
				search();
				break;

			case 9:
				System.out.println("종료합니다.");
				service.save();
				uservice.userSave();
				run = false;
			}
		}
		System.out.println("end of prog.");
	}// end of start.

	private String printString(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}
	
	void sendMail() {
		System.out.println("수신자 이메일 : ");
		String to = scn.nextLine();
		
		System.out.println("제목 : ");
		String title = scn.nextLine();
		
		System.out.println("내용 : ");
		StringBuilder sb = new StringBuilder();
		sb.append("<p>비밀번호 초기화 메일입니다.</p>");
		sb.append("<p>12345</p>");
		String content = scn.nextLine();
		sb.append("<p>" + content + "</p>");
		sb.append("<b>Bye!!</b>");
		content = sb.toString();
		
		SendMail sendMail = new SendMail();
		sendMail.sendMail(to, title, content);
		
	}

	void register() {
		String title = printString("제목입력");
		String content = printString("내용입력");
		String writer = logId;// printString("작성자입력");
		Board board = new Board(title, content, writer);

		if (service.add(board)) {
			System.out.println("등록성공!!");
		} else {
			System.out.println("등록실패!!");
		}
	}

	void boardList() {
		int page = 1;
		while (true) {
			List<Board> list = service.list(page);
			System.out.println("글번호   제목      작성자");
			System.out.println("-----------------------");
			for (Board b : list) {
				System.out.println(b.listInfo());
			}
			// 4 > 1page, 9>2page, 19>4page
			int totalCnt = service.getTotal();
			int lastPage = (int) Math.ceil(totalCnt / 5.0);
			for (int i = 1; i <= lastPage; i++) {
				if (page == i) {
					System.out.print("[" + i + "]");
				} else {
					System.out.printf(" %d ", i);
				}
			}
			System.out.println();
			System.out.print("조회페이지 입력(exit: 9)>> ");
			page = scn.nextInt();
			if (page == 9) {
				break;
			}
		}
	}

	void modify() {
		String brdNo = printString("번호입력");
		if (!service.getResponseUser(Integer.parseInt(brdNo)).equals(logId)) {
			System.out.println("권한없음!!");
			return;
		}
		String content = printString("내용입력");
		Board brd = new Board();
		brd.setBrdNo(Integer.parseInt(brdNo));
		brd.setBrdContent(content);
		if (service.modify(brd)) {
			System.out.println("수정성공!!");
		} else {
			System.out.println("수정실패!!");
		}
	}

	void remove() {
		String brdNo = printString("번호입력");
		if (!service.getResponseUser(Integer.parseInt(brdNo)).equals(logId)) {
			System.out.println("권한없음!!");
			return;
		}
		if (service.remove(Integer.parseInt(brdNo))) {
			System.out.println("삭제성공!!");
		}
	}

	void search() {
		String brdNo = printString("번호입력");
		Board result = service.search(Integer.parseInt(brdNo));
		if (result == null) {
			System.out.println("해당글번호가 없습니다.");
		} else {
			System.out.println(result.showInfo());

			ReplyApp rapp = new ReplyApp(Integer.parseInt(brdNo));
			rapp.start(); // 댓글의 컨트롤 역할.
		}
	}

	//////////////////////////////////
	class ReplyApp { // 중첩클래스.
		// 필드.
		private ReplyService rservice = new ReplyServiceImpl();
		//private ReplyService rservice = new ReplyServiceJdbc();
		private int brdNo;

		// 생성자.
		ReplyApp(int brdNo) {
			this.brdNo = brdNo;
		}

		// 메소드.
		void start() {
			boolean run = true;
			while (run) {
				replyList();

				System.out.println("  < 1.댓글등록 2.댓글삭제 9.이전메뉴 >");
				System.out.print("  선택>> ");

				int subMenu = Integer.parseInt(scn.nextLine());
				switch (subMenu) {
				case 1:
					add();
					break;

				case 2:
					delete();
					break;

				case 9:
					System.out.println("이전 메뉴로 이동합니다.");
					rservice.save();
					run = false;
				}
			}
		} // end of replyControl().

		void replyList() {
			List<Reply> rlist = rservice.replyList(brdNo);
			System.out.println("  댓글번호 댓글내용     작성자");
			System.out.println("  ------------------------");
			for (Reply reply : rlist) {
				System.out.println(reply);
			}
		}

		void add() {
			String content = printString("  댓글내용");
			Reply reply = new Reply(brdNo, content, logId);
			if (rservice.addReply(reply)) {
				System.out.println("등록성공!!");
			}
		}

		void delete() {
			String replyNo = printString("  댓글번호");
			if (rservice.delReply(Integer.parseInt(replyNo))) {
				System.out.println("등록성공!!");
			}
		}

	} // end of ReapyApp.

} // end of BoardApp.
