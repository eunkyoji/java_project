package co.yedam.array;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		
		Student[] students = new Student[10];
		Scanner scn = new Scanner(System.in);
		
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.score = 85;
		s1.gender = Gender.MEN;
		
		Student s2 = new Student();
		s2.name = "김길동";
		s2.score = 80;
		s1.gender = Gender.WOMEN;
		
		Student s3 = new Student();
		s3.name = "박길동";
		s3.score = 90;
		s1.gender = Gender.MEN;
		
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		
		boolean run = true;
		int idx = 0;
		
		//1.등록, 2. 조회, 3. 목록조회
		while(run) {
			System.out.println("1.등록 2.조회 3.목록 4.남학생정보 5.키 6.종료");
			System.out.println("선택 >> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			if( isNumeric(menu) == true ) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요!!");
				continue;
			}
			
			//Student s1 = new Student();
			String nm = "";
			int score = 0;
			switch(menu) {
				case 1 :	//이름과 점수를 입력
					
					if( idx == 9 ) {
						System.out.println("학생 정보 입력을 더이상 할 수 없습니다.");
						continue;
					}
					
					System.out.println("학생의 이름을 입력하세요.");
					s1.name = scn.nextLine();
					System.out.println("학생의 점수를 입력하세요.");
					s1.score = Integer.parseInt(scn.nextLine());	//문자열 '123'을 숫자 타입으로 변경
					System.out.println("학생의 키를 입력하세요.");
					s1.height = Double.parseDouble(scn.nextLine());
					
					students[idx] = s1;
					
					idx++;
					continue;
				case 2 :	// 이름을 입력하면 점수를 출력
					System.out.println("학생 이름을 입력하세요.");
					String name = scn.nextLine();
					if( students.length > 0 ) {
						for( int i = 0; i < students.length; i++ ){
							if( students[i] != null ){
								if( students[i].name.equals(name) ) {
									score = students[i].score;
									nm = students[i].name;
								} else {
									nm = null;
								}
							}
						}
						if( nm == null ) {
							System.out.println("등록된 학생이 없습니다.");
						} else {
							System.out.println(name + " 학생의 점수는 " + score + "점 입니다.");
						}
					} else {
						System.out.println("등록된 학생이 없습니다.");
					}	
					continue;
				case 3 :	//전체 이름과 점수를 출력
					if( students.length > 0 ) {
						for( int i = 0; i < students.length; i++ ) {
							if( students[i] != null ) {
								nm = students[i].name;
								score = students[i].score;
							} else {
								nm = null;
							}
						}
						
						if( nm != null ) {
							System.out.println("이름 : " + nm + ", 점수 : " + score );
						} else {
							System.out.println("등록된 학생이 없습니다.");
						}
					}  else {
						System.out.println("등록된 학생이 없습니다.");
					}
					continue;
				case 4 :
					if( students.length > 0 ) {
						for( int i = 0; i < students.length; i++ ) {
							if( students[i] != null && students[i].gender == Gender.MEN) {
								nm = students[i].name;
								score = students[i].score;
							} else {
								nm = null;
							}
						}
						
						if( nm != null ) {
							System.out.println("이름 : " + nm + ", 점수 : " + score );
						} else {
							System.out.println("등록된 학생이 없습니다.");
						}
					}  else {
						System.out.println("등록된 학생이 없습니다.");
					}
					continue;
				case 5 :
					double maxHeight = 0;
					if( students.length > 0 ) {
						for( int i = 0; i < students.length; i++ ){
							if( students[i] != null ){
								if( maxHeight < students[i].height ) {
									maxHeight = students[i].height;
									nm = students[i].name;
								}
							}
						}
						System.out.println(nm + " 학생의 키가 가장 크며, 학생의 키는 " + maxHeight + "입니다.");
					} else {
						System.out.println("등록된 학생이 없습니다.");
					}
					continue;
				case 6 :	//종료
					System.out.println("종료 합니다.");
					run = false;
			}
			
			System.out.println("End of Program");
		}
	}

	private static boolean isNumeric(int menu) {
		// TODO Auto-generated method stub
		return false;
	}
}
