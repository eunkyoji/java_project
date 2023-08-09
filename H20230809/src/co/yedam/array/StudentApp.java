package co.yedam.array;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		
		Student[] students = new Student[10];
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		//1.등록, 2. 조회, 3. 목록조회
		while(run) {
			System.out.println("1.등록 2.조회 3.목록 4.종료");
			System.out.println("선택 >> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			int idx = 0;
			
			Student s1 = new Student();
			
			switch(menu) {
				case 1 :	//이름과 점수를 입력
					System.out.println("학생의 이름을 입력하세요.");
					s1.name = scn.nextLine();
					System.out.println("학생의 점수를 입력하세요.");
					s1.score = Integer.parseInt(scn.nextLine());
					
					
					students[idx] = s1;
					
					if( idx == 9 ) {
						System.out.println("학생 정보 입력을 더이상 할 수 없습니다.");
						continue;
					}
					continue;
					
					
				case 2 :	// 이름을 입력하면 점수를 출력
					System.out.println("학생 이름을 입력하세요.");
					String name = scn.nextLine();
					int score = 0;
					for( int i = 0; i < students.length; i++ ){
						if( students[i].name.equals(name)){
							score = students[i].score;
						}
					}
					
					System.out.println(name + " 학생의 점수는 " + score + "점 입니다.");
				case 3 :	//전체 이름과 점수를 출력
					for( int i = 0; i < students.length; i++ ) {
						System.out.println(students[i].name + " 학생의 점수는 " + students[i].score);
					}
				case 4 :	//종료
					run = false;
			}
			
			System.out.println("End of Program");
		}
	}
}
