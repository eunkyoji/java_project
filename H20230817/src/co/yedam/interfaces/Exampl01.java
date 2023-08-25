package co.yedam.interfaces;

public class Exampl01 {
	public static void main(String[] args) {
		int[][] intAry = new int[5][5];	// intAry[0]
		
		System.out.println(intAry[2][2]);
//		for( int n = 1; n <= 25; n++ ) {
//			
//		}
		int m = 1;
		for( int i = 0; i < 5; i++ ) {
			for( int j = 0; j < 5; j++ ) {
				intAry[i][j] = m;
				m++;
				System.out.printf("%3d", intAry[i][j]);
			}
			System.out.println();
		}
		System.out.println("1=============================");
		
		for( int i = 0; i < 5; i++) {
			for( int j = 0; j < 5; j++ ) {
				System.out.printf("%3d", intAry[j][i]);
			}
			System.out.println();
		}
		System.out.println("2=============================");
		
		for( int r = 4; r >= 0; r-- ) {
			for( int c = 0; c < 5; c++ ) {
				System.out.printf("%3d", intAry[c][r]);
			}
			System.out.println();
		}
		System.out.println("3=============================");
		
		for( int r = 4; r >= 0; r-- ) {
			for( int c = 0; c < 5; c++ ) {
				System.out.printf("%3d", intAry[r][c]);
			}
			System.out.println();
		}
		System.out.println("4=============================");
	}
}
