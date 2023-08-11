package co.yedam.classes.Student;

public class StudentExe {	//실행 class
	public static void main(String[] args) {
		
		Student s1 = new Student();
//		s1.stdNo 	= 100;
//		s1.stdName	= "Hong";
//		s1.score	= 80;
		s1.setStdNo(100);
		s1.setStdName("Hong");
		s1.setScore(-80);
		
		s1.stdInfo();
		
		System.out.println("이름 : " + s1.getStdName());
		
		Student s2 = new Student(101, "Hwang", 70);
		s2.stdInfo();
	}
}
