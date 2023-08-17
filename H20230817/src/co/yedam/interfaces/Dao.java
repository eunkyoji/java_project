package co.yedam.interfaces;

public interface Dao {
	//규칙선언
	static final double pi = 3.14;	//상수
	
	abstract void inset();
	void update();
	void delete();
	void select();
}
