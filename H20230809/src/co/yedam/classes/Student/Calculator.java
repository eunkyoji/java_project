package co.yedam.classes.Student;

public class Calculator {
	double	pi	= 3.14;	// 인스턴스 멤버
	
	// 인스턴스 멤버 - 사용 시점에 선언되어 져야 사용할 준비가 되어 짐
	public double sum(double n1, double n2) {
		return n1 + n2;
	}
	
	public double minus(double n1, double n2) {
		return n1 - n2;
	}
	
	// class가 메모리에 로딩될때 사용할 준비가 되어 있는 상태
	public static double multi(double n1, double n2) {
		return n1 * n2;
	}
}
