package co.yedam.classes.Student;

import co.yedam.classes.friend.FriendApp;

public class FriendMain {
	public static void main(String[] args) {
		//FriendApp.start(); static void 로 선언시 (정적 메소드)
		
		//void로 선언시 인스턴스로 선언되어 인스턴스를 선언해 주어야 함.
		FriendApp app = new FriendApp();
		app.start();
	}
}
