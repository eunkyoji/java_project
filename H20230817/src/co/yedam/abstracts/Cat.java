package co.yedam.abstracts;

public class Cat extends Animal {
	
	public Cat(String name) {
		super(name);
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("야용");
	}
}
