package co.yedam.array;

class Student{
	String name;
	int score;
}

public class ArrayExe3 {
	public static void main(String[] args) {
		
		Student[] students = new Student[3];
		
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.score = 85;
		
		Student s2 = new Student();
		s2.name = "김길동";
		s2.score = 80;
		
		Student s3 = new Student();
		s3.name = "박길동";
		s3.score = 90;
		
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		
		System.out.println(students[0].name + " 성적은 : " + students[0].score);
		
		int max1 = 0;
		String name1 = "";
		for( int i = 0; i < students.length; i++ ) {
			if( max1 < students[i].score) {
				max1 = students[i].score;
				name1 = students[i].name;
			}
		}
		
		System.out.println("전체 최고 점수는 " + max1 + "점이고, 이름은 " + name1 +" 입니다.");
		
		String[] names = {"홍길동", "김길동", "박길동", "최길동"};
		int[] scores = {85, 88, 92, 75};
		
		int max = 0;
		String name = "";
		for( int i = 0; i <= scores.length - 1; i++ ) {
			if( max < scores[i] ) {
				max = scores[i];
				name = names[i];
			}
		}
		System.out.println("전체 최고 점수는 " + max + "점이고, 이름은 " + name +" 입니다.");
		
	}
}
