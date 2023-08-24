package co.yedam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardApp {
	List<Board> boardList = new ArrayList<>();
	Scanner scn = new Scanner(System.in);
	
	BoardApp(){
		init();
	}
	//파일 읽어오기
	public void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/temp/boardList.dat");
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			boardList = (List<Board>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//파일 저장하기
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/boardList.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(boardList);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		boolean run = true;
		
		while(run) {
			System.out.println("1.추가 2.수정 3.조회 4.삭제 5.목록 9.종료");
			System.out.println("선택 >> ");
			
			int menu = scn.nextInt();
			scn.nextLine();
			
			switch(menu) {
				case 1 :	// 추가
					register();
					break;
				case 2 :	// 수정
					modify();
					break;
				case 3 :	// 조회
					search();
					break;
				case 4 :	// 삭제
					remove();
					break;
				case 5 :	// 목록
					list();
					break;
				case 9 :	// 종료
					System.out.println("종료합니다.");
					save();
					run = false;
					break;
				default :
					System.out.println("잘못 입력하셨습니다.");
					break;
			}
		}
		System.out.println("end of prog");
	}
	
	private String printString(String msg) {
		System.out.println(msg + " >> ");
		return scn.nextLine();
	} // end of printString
	
	//글번호 최대값 구하기
	private int getMaxNo() {
		int brdNo = 0;
		for( int i = 0; i < boardList.size(); i++ ) {
			if( boardList.get(i).getBrdNo() > brdNo ) {
				brdNo = boardList.get(i).getBrdNo();
			}
		}
		return brdNo + 1;
	}
	
	//오늘 날짜 가져오기
	private Date getDate() {
		Date today = new Date();
		return today;
	}
	
	// 등록
	void register() {
		String title 	= printString("제목 ");
		String content 	= printString("내용 ");
		String writer 	= printString("작성자 ");
		
		Board board = new Board(getMaxNo(), title, content, writer, getDate());
		if( boardList.add(board) ) {
			System.out.println("정상 등록 되었습니다.");
		}
	}
	
	// 수정
	void modify() {
		int 	brdNo 	= Integer.parseInt(printString("수정 할 글 번호 "));
		String 	content = printString("내용 ");
		
		for( int i = 0; i < boardList.size(); i++ ) {
			if( boardList.get(i).getBrdNo() == brdNo ) {
				boardList.get(i).setBrdContent(content);
				System.out.println("수정이 완료되었습니다.");
				break;
			}
		}
	}
	
	//상세조회
	void search() {
		int brdNo	= Integer.parseInt(printString("조회 할 글 번호 "));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for( int i = 0; i < boardList.size(); i++ ) {
			if( boardList.get(i).getBrdNo() == brdNo ) {
				System.out.println("[작성자] " + boardList.get(i).getBrdWriter() + "\t" + "[작성일] " + sdf.format(boardList.get(i).getWriteDate()) 
									+ "\n[제 목] " + boardList.get(i).getBrdTitle() + "\n[내 용] " + boardList.get(i).getBrdContent());
				break;
			}
		}
	}
	
	// 삭제
	void remove() {
		int brdNo	= Integer.parseInt(printString("삭제 할 글 번호 "));
		for( int i = 0; i < boardList.size(); i++ ) {
			if( boardList.get(i).getBrdNo() == brdNo ) {
				boardList.remove(i);
				System.out.println("삭제가 완료되었습니다.");
				break;
			}
		}
	}
	
	// 목록보기
	void list() {
		System.out.println("글번호 \t 제목 \t\t 작성자 \t 작성일");
		System.out.println("-----------------------------------------------------");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for( int i = 0; i < boardList.size(); i++ ) {
			
			System.out.println("[" + boardList.get(i).getBrdNo() + "]\t" + boardList.get(i).getBrdTitle() 
								+ "\t       "+ boardList.get(i).getBrdWriter() + "\t " + sdf.format(boardList.get(i).getWriteDate()));
		}
	}
}
