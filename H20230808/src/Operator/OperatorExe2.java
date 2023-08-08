package Operator;

import java.util.Scanner;

/*
 *  은행 App.
 */
public class OperatorExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int balance = 0;	// 10만원 이상 불가, -금액 불가
		boolean run = true;
		
		while(run) {
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			System.out.println("선택 >> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			if( menu == 1 ) {
				Scanner in = new Scanner(System.in);
				System.out.println("입금액 입력 >> ");
				
				//코드작성
				int inNum = Integer.parseInt(in.nextLine());
				int sum = 0;
				sum = balance + inNum;
				if( sum > 100000 ) {
					System.out.println("잔액이 10만원을 초과 합니다.");
				} else {
					balance = sum;
					System.out.println("입금이 완료되었습니다.");
				}
				
			} else if( menu == 2 ) {
				Scanner out = new Scanner(System.in);
				System.out.println("출금액 입력 >> ");
				
				//코드작성
				int outNum = Integer.parseInt(out.nextLine());
				int sum = 0;
				sum = balance - outNum;
				if( sum < 0 ) {
					System.out.println("잔액이 부족합니다.");
				} else {
					balance = sum;
					System.out.println("출금이 완료되었습니다.");
				}
			} else if( menu == 3 ) {
				//코드작성
				System.out.println("현재 잔액은 " + balance + " 입니다.");
			} else if( menu == 4 ) {
				//코드작성
				System.out.println("종료합니다.");
				break;
			}
		}
		System.out.println("end of prog.");
	}
}
