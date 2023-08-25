package co.yedam.thread;

import java.awt.Toolkit;

public class WorkThread extends Thread{
	@Override
	public void run() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();	// 소리를 내는 기능
		for( int i = 0; i < 5; i++ ) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
