package co.yedam.array;

import java.util.Scanner;

public class TodoApp {
	public static void main(String[] args) {
		// 등록, 완료, 조회(날짜), 미완료
		// 등록 : 2 할일 0812
		// 완료 : 1 2 4 상태를 true로
		// 조회(날짜입력) : 해당 날짜의 날짜, 할일 조회
		// 미완료 : 미완료된 목록 조회 / 순번을 기준으로 정렬하여 보여줌
		//sortSample();
		
		Scanner scn = new Scanner(System.in);
		
		boolean run = true;
		
		while(run) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("1.학생수 | 2.이름, 점수입력(이름 점수) | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------------------");
			System.out.print("선택 >> ");
		}
	}
	
	public static void sortSample() {
		int[] intAry = {33, 24, 45, 54, 73, 98, 12};
		
		for( int j = 0; j < intAry.length - 1; j++ ) {
			for( int i = 0; i < intAry.length - 1; i++ ) {
				if( intAry[i] > intAry[i + 1] ) {
					int tmp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = tmp;
				}
			}
		}
		for( int num : intAry ) {
			System.out.print(num + " ");
		}
	}
}
