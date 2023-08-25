package co.yedam.interfaces;

public class MysqlDao implements Dao {

	@Override
	public void inset() {
		System.out.println("Mysql 입력기능.");
	}

	@Override
	public void update() {
		System.out.println("Mysql 수정기능.");
	}

	@Override
	public void delete() {
		System.out.println("Mysql 삭제기능.");
	}

	@Override
	public void select() {
		System.out.println("Mysql 조회기능.");
	}

}
