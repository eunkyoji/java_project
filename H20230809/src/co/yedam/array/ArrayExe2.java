package co.yedam.array;

public class ArrayExe2 {
	public static void main(String[] args) {
		
		//정수를 담을 수 있는 공간 5개를 담을 수 있도록
		int[] intAry = new int[5];
		
		// 1 ~ 100 임의의 값
		for( int i = 0; i <= 4; i++ ) {
			int num = (int)(Math.random() * 100 + 1);
			intAry[i] = num;
			
			System.out.println(intAry[i]);
		}
		
		int num1, num2, num3;
		num1 = 56;
		num2 = 72;
		num3 = 67;
		if( num1 > num2 ) {
			if(num1 > num3) {
				System.out.println("num1 = " + num1);
			} else {
				System.out.println("num3 = " + num3);
			}
		} else if( num2 > num3 ) {
			System.out.println("num2 = " + num2);
		} else {
			System.out.println("num3 = " + num3);
		}
		
		int[] intNum = {num1, num2, num3};
		int max = 0;
		for( int i = 0; i <= intNum.length - 1; i++) {
			if( max < intNum[i]) {
				max = intNum[i];
			}
		}
		System.out.println("Max = " + max);
		
		// 배열의 값의 합과 평균을 구하시오
		int sum = 0;
		
		for( int i = 0; i < intAry.length-1; i++ ) {
			int num = (int)(Math.random() * 100 + 1);
			intAry[i] = num;
			sum += intAry[i]; 
		}
		System.out.println("intAry의 합은 = " + sum);
		
		double avg = sum / intAry.length;
		System.out.println("intAry의 평균은 = " + avg);
		
	}
}
