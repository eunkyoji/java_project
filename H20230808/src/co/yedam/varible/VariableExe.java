package co.yedam.varible;

public class VariableExe {	//Class명은 대문자로 시작
	public static void main(String[] args) {
		//변수선언
		//정수형 변수의 유형 : byte(1byte), short(2byte), int(4btye), long(8byte)
		//첫번째 비트는 음, 양수의 기호를 나타냄
		//byte : -128 ~ 127
		//short : -32768 ~ 32767
		//int : -2147483648 ~2147483647
		//long : -2147483648
		int num1 = 1;	// 초기화
		int num2 = 2147483647; // int의 최대값
		
//		num1 = 10;		//변경된 값
//		num2 = 20;
		
		int result = num1 + num2;	// 범위의 값을 넘기면 -값으로 넘어감
		System.out.println("result :: " + result);
		System.out.println("Short.MIN_VALUE :: " + Short.MIN_VALUE);
		System.out.println("Integer.MIN_VALUE :: " + Integer.MIN_VALUE);
		
		byte b1 = 10;
		byte b2 = 20;
		
		//byte b3 = b1 + b2;	//Type mismatch: cannot convert from int to byte : 정수의 연산은 int로 정의 됨
		int b3 = b1 + b2;
		
		int i1 = 100;
		byte b4 = 10;
		
		b3 = i1 + (int)b4; // 큰 데이터 유형에 맞게 데이터 유형은 변경 시켜줌 : 자동 형 변환하여 연산.
		
		// 실수타입 
		// float, double
		double dbl1 = 10.23223;
		double dbl2 = 20;
		double dbl3 = dbl1 + dbl2;
		
		// float : 근사치로 하여 값을 담아줌
		// 정확한 값으로 계산하지 못하여 근사치 값으로 나타냄
		float f1 = 10.1f; //float type의 실수형을 나타내기 위해 숫자뒤에 f를 붙여 줌
		float f2 = 10.001f;
		float f3 = f1 + f2;
		System.out.println("f3 :: " + f3);
	}
}
