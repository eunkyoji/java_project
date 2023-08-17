package co.yedam;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("첫번째 정수를 입력하세요.");
		int num1 = Integer.parseInt(scn.nextLine());
		System.out.println("두번째 정수를 입력하세요.");
		int num2 = Integer.parseInt(scn.nextLine());
		
		if( num1 > num2 ){
			System.out.println("두 정수 중 가장 큰 값은 : " + num1);
		} else {
			System.out.println("두 정수 중 가장 큰 값은 : " + num2);
		}
	}
}
