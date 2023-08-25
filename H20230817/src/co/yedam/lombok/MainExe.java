package co.yedam.lombok;

import javax.annotation.processing.SupportedSourceVersion;

public class MainExe {
	public static void main(String[] args) {
		Student s1 = new Student(101, "hwang", 80);
		s1.setStdNo(101);
		s1.setStdName("hong");
		s1.setScore(90);
		
		System.out.println(s1.toString());
	}
}
