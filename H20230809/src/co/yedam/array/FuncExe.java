package co.yedam.array;

public class FuncExe {
	public static void main(String[] args) {
		printStar();
		printStar(3);
		printString(5, "※");
		
		int n3 = sum(30, 20);
		System.out.println(n3);
		
		int[] intAry = {5, 3, 6, 7, 9, 2};
		int n4 = sumAry(intAry);
		System.out.println(n4);
		
		//getFriend("홍길동", "010-1234-2222", Gender.MEN).showInfo();
		Friend f = getFriend("홍길동", "010-1234-2222", Gender.MEN);
		f.showInfo();
	}
	
	public static void printStar() {
		System.out.println("*");
	}
	
	public static void printStar(int times) {
		for( int i = 0; i < times; i++ ) {
			System.out.println("*");
		}
	}
	
	public static void printString(int times, String str) {
		for( int i = 0; i < times; i++ ) {
			System.out.println(str);
		}
	}
	
	public static int sum(int n1, int n2) {
		int result = n1 + n2;
		return result;
	}
	
	public static int sumAry(int[] arry) {
		int sum = 0;
		for( int i = 0; i < arry.length; i++ ) {
			sum += arry[i];
		}
		return sum;
	}
	
	public static Friend getFriend(String name, String phone, Gender gender) {
		Friend f = new Friend();
		f.name = name;
		f.phone = phone;
		f.gender = gender;
		return f;
	}
}
