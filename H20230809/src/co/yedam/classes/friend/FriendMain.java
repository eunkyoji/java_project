package co.yedam.classes.friend;

public class FriendMain {
	public static void main(String[] args) {
		
		//System.out.println(args[0] + args[1] + args.length);
		
		//FriendApp.start(); static void 로 선언시 (정적 메소드)
		
		//모든 class는 인스턴스가 있어야 한다.
		//void로 선언시 인스턴스로 선언되어 인스턴스를 선언해 주어야 함.
		FriendApp app = new FriendApp();
		app.start();
	}
}
