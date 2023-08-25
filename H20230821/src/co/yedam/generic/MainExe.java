package co.yedam.generic;

public class MainExe {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.set("Hello");
		String result = box.get();
		//String result = (String) box.get(); //Object로 선언되어졌을 경우 타입에 대하여 캐스팅해 주어야 한다.
		
		Box<Integer> ibox = new Box<Integer>();
		ibox.set(10);	//(Integer)
		result = (String) box.get();
	}
}
