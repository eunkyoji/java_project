package co.yedam.abstracts;

public class MainExe {
	public static void main(String[] args) {
		//Animal animal = new Animal("");	// 추상메소드로 선언되었을 경우 앞과 같이 선언 할 수 없다.
		Animal animal = new Dog("멍멍이");
		animal.sound();
		
		animal = new Cat("야옹이");
		animal.sound();
	}
}
