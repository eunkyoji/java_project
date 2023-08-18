package co.yedam.api;

public class StringExe2 {
	public static void main(String[] args) {
		String file = "C:/Dev/temp/비숑.jpg";
		System.out.println(StringUtils.getFileName(file));
		
		String ssn = "0105264656324";
		String sex = StringUtils.checkGender(ssn);
		System.out.println(sex);
	}
}
