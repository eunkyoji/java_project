package co.yedam.varible;

public class VariableExe3 {	//Class명은 대문자로 시작
	
	int num = 100; // 전역변수
	
	public void showInfo() { 
		int num = 100 + this.num;// 전역변수일 경우 this.을 이용하여 사용 가능
		System.out.println("num1 :: " + num);
		int num1 = 200; //local 변수는 선언된 실행 블럭 안에서만 유효함.
	}
	
	public void printNum() {
		//System.out.println("num :: " + num1);	// Block 이외에 선언된 값은 사용 할 수 없음.
	}
	
	public void helloMsg() {
		int num = 200 + this.num;
		System.out.println("num2 :: " + num);
	}
}
