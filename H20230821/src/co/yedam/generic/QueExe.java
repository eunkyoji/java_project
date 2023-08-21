package co.yedam.generic;

import java.util.LinkedList;
import java.util.Queue;

public class QueExe {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();
		que.offer("One");
		que.offer("Two");
		que.offer("Three");
		
		while( !que.isEmpty() ) {
			String val = que.poll();
			System.out.println(val);
		}
	}
}
