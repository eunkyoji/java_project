package co.yedam.codition;

public class ConditionExe {
	public static void main(String[] args) {
		//임의의 수
		int score = 0;
		score = (int)(Math.random() * 3) + 1;
		String grade = "";
		
		switch(score) {
			case 1 :
				grade = "가위";
				break;
			case 2 :
				grade = "바위";
				break;
			default :
				grade = "보";
		}
		
		System.out.printf("%d는 %s 입니다. \n", score, grade);
		
		int num = 97;
		byte b1 = 2;
		byte b2 = 2;
		int result = b1 + b2;	// 작은 값은 자동으로 자동 형 변환이 일어남, 큰값에서 작은 값으로 갈때는 형변환을 설정해 줘야함.
		char chr = 6500;
		System.out.println(chr);
		
		System.out.println("어떤 혜택을 원하세요?");
		char grade1 = (char)(Math.random() * 4 + 66);
		
		System.out.println(grade1 + "\n");
		System.out.println(grade1 == 'A');

		switch(grade1) {
			case 'A' :
				System.out.println("VVIP혜택을 받으실수 있습니다.");
				break;
			case 'B' :
				System.out.println("VIP혜택을 받으실수 있습니다.");
				break;
			case 'C' :
				System.out.println("우수 회원 혜택을 받으실수 있습니다.");
				break;
			case 'D' :
				System.out.println("일반 회원 혜택을 받으실수 있습니다.");
				break;
			default :
				System.out.println("혜택이 없습니다.");
		}
		System.out.println("감사합니다.");
	}
}
