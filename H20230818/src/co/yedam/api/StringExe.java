package co.yedam.api;

import java.io.UnsupportedEncodingException;

public class StringExe {
	public static void main(String[] args) {
		
		byte[] bytes = {104, 101, 108, 108, 111};
		String str = null;
		
		try {
			str = new String(bytes, 0, 3, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
	}
}
