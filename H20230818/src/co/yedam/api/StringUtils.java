package co.yedam.api;

public class StringUtils {
	static String checkGender(String ssn) {
		//주민번호 구분해서 남자, 여자, 오류 케이스 판별.
		String secondNum = null;
		System.out.println("length :: " + ssn.length());
		String jumin = ssn.trim();
		
		if( jumin.length() > 13 ) {
			secondNum = jumin.substring(7);
		} else {
			secondNum = jumin.substring(6);
		}
		
		int year = Integer.valueOf(ssn.substring(0,2));
		boolean before2000 = year > 23;
		char chr = secondNum.charAt(0);
		
		String gen = "오류";
		if( before2000 && (chr == '3' || chr == '4') ) {
			return gen;
		}
		if( !before2000 && (chr == '1' || chr == '2') ) {
			return gen;
		}
		
		char s = secondNum.charAt(0);
		String sex = null;
		switch(s){
			case '1' :
			case '3' :
				sex = "남자";
				System.out.println(sex);
				break;
			case '2' :
			case '4' :
				sex = "여자";
				break;
			default :
				System.out.println("잘못 입력된 주민번호입니다.");
				break;
		}
		System.out.println("s :: " + s);
		return sex;
	}
	
	static String getFileName(String filePath) {
		//전체경로에서 파일명만 추출.
		String data[] = filePath.split("/");
		String fileNm = null;
		for( int i = 0; i < data.length; i++ ) {
			if( i == (data.length - 1)) {
				fileNm = data[i];
			}
		}
		return fileNm;
	}
}
