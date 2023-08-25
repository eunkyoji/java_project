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
		Todo[] todo = new Todo[10];
		int idx = 0;
		
		while(run) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.등록(번호 할일 날짜) | 2.완료 | 3.조회 | 4.미완료 조회 | 5.종료");
			System.out.println("------------------------------------------------------");
			System.out.print("선택 >> ");
			
			int num = Integer.parseInt(scn.nextLine());
			if( isNumeric(num) == true || (num == 0 || num > 5) ) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요!!");
				continue;
			}
						
			switch(num) {
				case 1 :
					System.out.println("업무와 등록일을 입력하세요.(ex :번호 공부 0812)");
					Todo t = new Todo();
					String[] data = scn.nextLine().split(" ");
					int nn = Integer.parseInt(data[0]);
					for( int i = 0; i < todo.length; i++ ) {
						if( todo[i] != null && todo[i].no == nn ){
							System.out.println("동일한 번호가 존재합니다. 다시 입력해주세요");
							break;
						} else if( todo[i] == null ) {
							t.no = nn;
							t.todo = data[1];
							t.dueDate = data[2];
							t.done = false;
							
							todo[idx] = t;
							
							idx++;
							break;
						}
					}
					
					break;
				case 2 :
					System.out.println("완료시킬 업무 번호를 입력하세요.");
					String[] no = scn.nextLine().split(" ");
					
//					if( no.length == 1 ) {
//						for( int i = 0; i < todo.length; i++ ) {
//							if( todo[i] != null && todo[i].no == Integer.parseInt(no[0]) ) {
//								if( todo[i].done == false ) {
//									todo[i].done = true;
//									System.out.println("정상 처리 되었습니다.");
//									break;
//								}
//							}
//						}
//					} else {
						for( int i = 0; i < no.length; i++ ) {
							for( int j = 0; j < todo.length; j++ ) {
								if( todo[i] != null && todo[i].no == Integer.parseInt(no[j]) ) {
									if( todo[i].done == false ) {
										todo[i].done = true;
										System.out.println(no[j] + "이 정상 처리 되었습니다.");
									}
								}
							}
						}
//					}
					break;
				case 3 :
//					System.out.println("조회 할 업무 번호를 입력하세요!!");
//					numNo = Integer.parseInt(scn.nextLine());
//					for( int i = 0; i < todo.length; i++ ) {
//						if( todo[i] != null && todo[i].no == numNo ) {
//							System.out.printf("%d. 업무 : %s, 등록일 : %s, 처리현황 : %s", numNo, todo[i].todo,
//												todo[i].dueDate, todo[i].done == true ? "완료" : "미완료");
//						} else {
//							System.out.println("등록된 업무가 없습니다.");
//							break;
//						}
//					}
					
					System.out.println("업무 등록일을 입력하세요.");
					String date = scn.nextLine();
					int count = 0;
//					for( int i = 0; i < todo.length; i++ ) {
//						if( todo[i] != null && todo[i].dueDate.equals(date) ) {
//							System.out.printf("%d. 업무명 : %s, 등록일 : %s, 처리현황 : %s", 
//									todo[i].no, todo[i].todo, todo[i].dueDate, todo[i].done == true ? "완료" : "미완료");
//							System.out.println();
//							count++;
//						}
//					}
//					
					for( int i = 0; i < todo.length; i++ ) {
						if( todo[i] != null ) {
							count++;
						}
					}
					
					
					for( int i = 0; i < count-1; i++ ) {
						Todo tmp = new Todo();
						if( todo[i].no < todo[i + 1].no ) {
							tmp = todo[i];
							todo[i+1] = todo[i];
							todo[i+1] = tmp;
						}
					}
					
					count = 0;
					for( int j = 0; j < todo.length; j++ ) {
						if( todo[j] != null && todo[j].dueDate.equals(date)) {
							System.out.printf("%d. 업무명 : %s, 등록일 : %s, 처리현황 : %s", 
									todo[j].no, todo[j].todo, todo[j].dueDate, todo[j].done == true ? "완료" : "미완료");
							System.out.println();
							count++;
						}
					}
					
					if( count < 1 ) {
						System.out.println("해당 날짜에 등록된 업무가 없습니다.");
					}
					
					break;
				case 4:
					count = 0;
					for( int i = 0; i < todo.length; i++ ) {
						if( todo[i] != null && todo[i].done == false ) {
							count++;
						}
					}
					
					if( count < 1 ) {
						System.out.println("미완료된 업무가 없습니다.");
						break;
					}
					
					int[] intAry = new int[count];
					int index = 0;
					for( int j = 0; j < todo.length; j++ ) {
						if( todo[j] != null && todo[j].done == false ) {
							intAry[index] = todo[j].no;
							index++;
						}
					}
					
					int[] sortNum = sortSample(intAry);
					for( int i = 0; i < intAry.length; i++ ) {
						for( int j = 0; j < todo.length; j++ ) {
							if(todo[j] != null && todo[j].no == intAry[i] ) {
								System.out.println(todo[j].no + ". 업무명 : " + todo[j].todo
										+ ", 등록일 : " + todo[j].dueDate);
							}
						}
					}
					break;					
				case 5 :
					run = false;
					break;
			}
		}
		System.out.println("프로그램 종료!!");
	}
	
	private static boolean isNumeric(int num) {
		// TODO Auto-generated method stub
		return false;
	}

	public static int[] sortSample(int[] intAry) {
		//int[] intAry = {33, 24, 45, 54, 73, 98, 12};
		
		for( int j = 0; j < intAry.length - 1; j++ ) {
			for( int i = 0; i < intAry.length - 1; i++ ) {
				if( intAry[i] > intAry[i + 1] ) {
					int tmp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = tmp;
				}
			}
		}
		
		return intAry;
	}
}
