package co.yedam.generic;

//T: type parameter
//<T> Generic.
public class Box<T> {	// Box를 사용하는 시점에 타입을 정하도록하는 것
	T obj;
	
	T get() {
		return obj;
	}
	
	void set(T obj) {
		this.obj = obj;
	}
}
