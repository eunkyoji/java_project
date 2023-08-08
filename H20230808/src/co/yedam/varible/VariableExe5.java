package co.yedam.varible;

import java.io.IOException;
import java.util.Scanner;

/*
 * Scanner 클래스 활용.
 */

public class VariableExe5 {	//Class명은 대문자로 시작
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);	// 스캐너(키보드 입력)
		
		String numStr = "123";
		int num = Integer.parseInt(numStr);	//문자열 "123"을 정수형 123으로 변환.
		System.out.println(num);
		
		//String number = "123a"; 실행시 => at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
		
		int sum = 0;
		
		while(true) {
			System.out.println("정수값을 입력: 종료하려면 quit를 입력하세요. >>>>");
			String result = scan.nextLine();//입력값을 문자열로 반환.
			System.out.printf("입력값은 %s 입니다. \n", result);
			
			if( result.equals("quit") ) {
				break;
			}
			
			// 입력값이 100보다 크거나 0보다 작으면 합계에서 제외
			// 범위 안에 값만 합계 되도록
			int num1 = Integer.parseInt(result);

			if( num1 < 0 || num1 > 100 ) {
				continue;
			}
			sum = sum + num1;
			
		}
		System.out.println("입력한 값의 합계는 " + sum);
		System.out.println("end of prog.");
	}
}
// end of class