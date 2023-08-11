package co.yedam.array;

import java.util.*;

class Member{
	String name;
	int score;
}

public class ScoreApp {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		boolean run = true;
		int studentNum = 0;
		//int[] scores = null;
		Member[] m = null;
		
		while(run) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("1.학생수 | 2.이름, 점수입력(이름 점수) | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------------------");
			System.out.print("선택 >> ");
			
			int selNo = Integer.parseInt(scn.nextLine());
			
			switch(selNo) {
				case 1 :
					System.out.print("학생수를 입력하세요.");
					studentNum = Integer.parseInt(scn.nextLine());
					m = new Member[studentNum];
					break;
				case 2 :
					if( m.length < 1 ) {
						System.out.println("학생수를 먼저 입력하세요!!");
						break;
					}
					
					
					for( int i = 0; i < studentNum; i++ ) {
						Member mebmer = new Member();
						System.out.print("name / score[" + i + "]");
						
						String[] data = scn.nextLine().split(" ");
						mebmer.name = data[0];
						mebmer.score = Integer.parseInt(data[1]);
						
						m[i] = mebmer;
					}
					break;
				case 3 :
					for( int i = 0; i < m.length; i++ ) {
						System.out.println("이름 : " + m[i].name + ", 점수 : " + m[i].score);
					}
					break;
				case 4 :
					int maxSco = 0;
					int sum = 0;
					for( int i = 0; i < m.length; i++ ) {
						if( maxSco < m[i].score ) {
							maxSco = m[i].score;
						}
						sum += m[i].score;
					}
					
					double avg = sum / studentNum;
					System.out.println("최고 점수 : " + maxSco);
					System.out.println("평균 점수 : " + avg);
					break;
				case 5 :
					run = false;
					break;
			}
		}
		System.out.println("프로그램 종료!!");
	}
}
