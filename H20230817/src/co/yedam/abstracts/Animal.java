package co.yedam.abstracts;

public abstract class Animal {
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//추상메소드 - 구현부분이 없는 메소드
	public abstract void sound();
}
