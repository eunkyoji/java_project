package co.yedam.interfaces;

import java.util.Scanner;

public class MainExe {
	public static void main(String[] args) {
		Dao dao = new OracleDao();
	//  인터페이스 = 구현객체 
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int menu = -1;
		
		while(run) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.print("선택 >> ");
			
			menu = Integer.parseInt(scn.nextLine()); // 3 엔터
			scn.nextLine();
			
			switch(menu) {
				case 1 :
					dao.inset();
					break;
				case 2 :
					dao.select();
					break;
				case 3 :
					dao.update();
					break;
				case 4 :
					dao.delete();
					break;
				case 5 :
					System.out.println("종료합니다.");
					run = false;
					break;
				default :
					System.out.println("잘못된 메뉴입니다.");
					break;
			} // end of switch
			
		}// end of while
	}// end of main
}// end of class
