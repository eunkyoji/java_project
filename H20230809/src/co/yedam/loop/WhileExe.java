package co.yedam.loop;

public class WhileExe {
	public static void main(String[] args) {
		
		boolean run = true;
		while (run) {
			int tmp = (int)(Math.random() * 100);
			if( tmp > 90 ) {
				//break;
				run = false;
			}
			System.out.println(tmp);
		}
		System.out.println("End");
		
		// 1부터 10까지 출력
		for( int i = 1; i <= 10; i++ ) {
			System.out.println(i);
		}
		
		// 1부터 100까지의 합을 출력
		int sum = 0;
		for( int i = 1; i <= 100; i++ ) {
			sum += i;
		}
		System.out.println("1부터 100까지의 합 = " + sum);
		
		for(float x = 0.1f; x <= 1.0f; x+=0.1f) {
			System.out.println(x);
		}
		
		for( int i = 2; i <= 9; i++ ) {
			System.out.println("*** " + i + "단 ***");
			for( int j = 1; j <= 9; j++ ) {
				System.out.println(i + " X " + j + " = " + i * j);
			}
		}
		
		int i = 1;
		while(i <= 10) {
			System.out.println(i);
			i++;
		}
		
		sum = 0;
		i = 1;
		while( i <= 100 ) {
			sum += i;
			i++;
		}
		System.out.println("1 ~ " + (i-1) + " 합 : " + sum);
		
		while(true) {
			int num = (int)(Math.random() * 6) + 1;
			System.out.println(num);
			if( num == 6 ) {
				break;
			}
		}
		System.out.println("Program Out");
		
		Outter: for( char upper = 'A'; upper <= 'Z'; upper++ ) {
			for( char lower = 'a'; lower <= 'z'; lower++ ) {
				System.out.println(upper + " - " + lower);
				if(lower == 'g') {
					break Outter;
				}
			}
		}
		System.out.println("프로그램 실행 종료");
		
		for( int j = 1; j <= 10; j++ ) {
			if( j % 2 != 0 ) {
				continue;
			}
			System.out.println(j);
		}
		
		for( int j = 1; j <= 4; j++ ) {
			String str = "";
			for( int k = 1; k <= j; k++ ) {
				str += "*";
			}
			System.out.println(str);
		}
		System.out.println("End ===========");
		
		for( int n = 4; n >= 1; n-- ) {
			String str = "";
			int k = 1;
			for( k = 1; k <= 4 - n; k++ ) {
				str += " ";
			}
			
			for( int m = k; m <= 4 ; m++ ) {
				str += "*";
			}
			System.out.println(str);
		}
		System.out.println("End ===========");
		
		for( int n = 0; n <= 4; n++ ) {
			String str = "";
			int k = 1;
			for( k = 1; k <= 4 - n; k++ ) {
				str += " ";
			}
			
			for( int m = k; m <= 4 ; m++ ) {
				str += "*";
			}
			System.out.println(str);
		}
	}
}
