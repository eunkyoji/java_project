package co.yedam.loop;

public class ForExe {
	public static void main(String[] args) {
		int sum = 0;
		
		sum = sum + 1;
		sum = sum + 2;
		sum = sum + 3;
		sum = sum + 4;
		sum = sum + 5;
		
		System.out.println("sum1 = " + sum);
		
		sum = 0;
		for( int i = 0; i <= 5; i++ ) {
			sum = sum + i;
		}
		
		System.out.println("sum2 = " + sum);
	}
}
