package co.yedam;

public class Ex03 {
	public static void main(String[] args) {
		int[] intAry = new int[5];
		
		for( int i = 0; i <= 4; i++ ) {
			intAry[i] = (int)(Math.random() * 10) + 1;
			//System.out.println(intAry[i]);
		}
		
		int max = 0;
		int min = 0;
		for( int j = 0; j < intAry.length; j++ ) {
			if( j == 0 ) {
				max = intAry[j];
				min = intAry[j];
			}
			if( intAry[j] > max ) {
				max = intAry[j];
			}
			
			if( intAry[j] < min ) {
				min = intAry[j];
			}
		}
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
}

