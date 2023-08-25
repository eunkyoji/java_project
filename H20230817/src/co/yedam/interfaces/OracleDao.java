package co.yedam.interfaces;

public class OracleDao implements Dao{
	@Override
	public void inset() {
		System.out.println("Oracle 입력기능");
	}

	@Override
	public void update() {
		System.out.println("Oracle 수정기능");
	}

	@Override
	public void delete() {
		System.out.println("Oracle 삭제기능");
	}

	@Override
	public void select() {
		System.out.println("Oracle 조회기능");
	}
}
