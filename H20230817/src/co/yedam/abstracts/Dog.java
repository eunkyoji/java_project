package co.yedam.abstracts;

public class Dog extends Animal{
	
	public Dog(String name) {
		super(name);
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}
}
