package co.yedam.varible;

public class VariableExe2 {	//Class명은 대문자로 시작
	public static void main(String[] args) {
		String str = "홍길동";
		str = "김길동";
		
		// 홍길동, 20
		// class type을 선언하여 하나의 변수에 여러 형태의 데이터를 담을 수 있음
		Person hong = new Person();
		hong.name 	= "홍길동";
		hong.age	= 20;
		hong.weight = 67.8;
		
		//hong = "홍길동"; 일반 문자열 타입으로 hong에 담을 수 없다.
		hong = new Person(); // 새로 선언하여 기존의 값을 모두 초기화 한다.
		
		System.out.println("이름은 " + hong.name + ", 나이는 " + hong.age + ", 몸무게는 " + hong.weight + "입니다.");
		
		VariableExe3 exe3 = new VariableExe3();
		exe3.showInfo();
		exe3.helloMsg();
	}
}
