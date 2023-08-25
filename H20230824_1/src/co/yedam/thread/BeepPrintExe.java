package co.yedam.thread;

import java.awt.Toolkit;

public class BeepPrintExe {
	public static void main(String[] args) {
		
		//쓰레드 생성 : 멀티 환경으로 실행하기위해
		
		Thread beep;
		// 1. Runnable 인터페이스를 구현하는 객체를 Thread(생성자 매개값)
		beep = new Thread(new BeepTask());
		// 2. Thread를 상속하는 클래스를 작성.
		beep = new WorkThread();
		// 1-1. Runnable 인터페이스를 구현하는 익명객체 생성
		// 		Functional Interface.(구현할 메소드가 한개만 존재)
		//beep = new Thread(new Runnable() {	// 추상 메소드가 하나 올수 있다.
		beep = new Thread(() -> {
			//@Override
			//public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();	// 소리를 내는 기능
				for( int i = 0; i < 5; i++ ) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			//}
		});
		
		beep.start();
		
		for( int i = 0; i < 5; i++ ) {
			System.out.println("띵!!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
