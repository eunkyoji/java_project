package co.yedam.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExe {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		long start = System.currentTimeMillis();
		for( int i = 0; i < 100000; i++ ) {
			list.add(0, "" + i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("ArrayList : " + (end-start) + " ms");
		
		list = new LinkedList<>();
		start = System.currentTimeMillis();
		for( int i = 0; i < 100000; i++ ) {
			list.add(0, "" + i);
		}
		end = System.currentTimeMillis();
		
		System.out.println("LinkedList : " + (end-start) + " ms");
	}
}
