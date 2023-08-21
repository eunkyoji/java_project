package co.yedam.generic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("홍길동");
		set.add("김길동");
		set.add("박길동");
		set.add("홍길동");	// 동일한 값은 저장하지 않는다.
		
		//set.remove("홍길동");
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String val = iter.next();
			System.out.println(val);
		}
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(11);
		
		Set<Integer> iset = new HashSet<>();
		for( Integer no : list ) {
			iset.add(no);
		}
		
		for( Integer no : iset ) {
			System.out.println(no);
		}
	}
}
