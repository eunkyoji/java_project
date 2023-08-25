package co.yedam;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("첫번째 정수를 입력하세요.");
		int num1 = Integer.parseInt(scn.nextLine());
		System.out.println("두번째 정수를 입력하세요.");
		int num2 = Integer.parseInt(scn.nextLine());
		
		int sum2 = 0;
		int sum3 = 0;
		
		int startNm = 0;
		int endNm	= 0;
		
		if( num1 < num2 ) {
			startNm = num1;
			endNm	= num2;
		} else {
			startNm = num2;
			endNm	= num1;
		}
		
		for( int i = startNm; i < endNm; i++ ) {
			if( (i % 2) == 0 ) {
				sum2 += i;
			} else if( (i % 3) == 0 ) {
				sum3 += i;
			}
		}
		
		System.out.println(startNm + " ~ " + endNm + " 사이의 2의 배수 합은 : " + sum2);
		System.out.println(startNm + " ~ " + endNm + " 사이의 3의 배수 합은 : " + sum3);
	}
}
