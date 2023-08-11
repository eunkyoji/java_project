package co.yedam.classes.Student;

public class Main {
	public static void main(String[] args) {
//		Calculator cal = new Calculator();	// 인스턴스
//		
//		double sum = cal.sum(20, 40);
//		System.out.println(sum);
		
		double result = Calculator.multi(10, 20);
		System.out.println(result);
	}
	
	public void start() {
		Main main = new Main();
		main.main(null);
	}
}
