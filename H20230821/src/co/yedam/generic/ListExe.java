package co.yedam.generic;

import java.util.ArrayList;
import java.util.List;

public class ListExe {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		//Interpace
		
		list.add("Hello");
		list.add(new String("World"));
		list.add("Good");
		
		String result = list.get(0); // 배열의경우 ary[0]
		System.out.println(result);
		
		for( int i = 0; i < list.size(); i++ ) {	//컬랙션의 경우 length가 아닌 size를 사용
			System.out.println(list.get(i));
		}
		
		list.set(1, "result");
		System.out.println("===== 수정 후 =====");
		list.remove(1);	// 해당 위치의 값만 삭제
		list.clear();	// 모든 요소를 삭제
		
		for( String str : list ) {
			System.out.println(str);
		}
	}
}
