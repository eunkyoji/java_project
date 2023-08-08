package Operator;

public class OperatorExe {
	public static void main(String[] args) {
		
		int x, y;
		y = x = 2;
		
		int result = x++ + 10; //연산을 먼저하고 증가
		System.out.println("result x ::: " + result);
		System.out.println("x ::: " + x);
		
		result = ++y + 10;	// 증가를 시키고 연산을 함
		System.out.println("result y ::: " + result);
		
		String str = "";
		//삼항 연산자.
		if( x >= 10 ) {
			str = "x는 10이상.";
		} else {
			str = "x는 10미만.";
		}
		
		//삼항연산
		str = (x >= 10) ? "x는 10이상." : "x는 10미만.";
		
		System.out.println("str :: " + str);
	}
}
