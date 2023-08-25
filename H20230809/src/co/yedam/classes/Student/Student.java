package co.yedam.classes.Student;

public class Student {
	//filed
	private int		stdNo;		// 초기값 : 0
	private String	stdName;	// 초기값 : null
	private int		score;
	
	//생성자 : 필드 값 초기화
	Student(){
		// 기본 생성자
	}
	
	Student(int stdNo){	// 
		this.stdNo 		= stdNo;
	}
	
	Student(int stdNo, String stdName, int score){	// 
		this.stdNo 		= stdNo;
		this.stdName	= stdName;
		this.score		= score;
	}
	
	// 메소드
	void stdInfo() {
		System.out.println("학번 : " + stdNo + ", 학생이름 : " + stdName + ", 점수 : " + score);
	}
	
	void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	
	void setStdName(String stdName) {
		this.stdName	= stdName;
	}
	
	void setScore(int score) {
		if( score < 0 ) {
			this.score	= 0;
		} else {
			this.score = score;
		}
	}
	
	// getter
	public int getStdNo() {
		return stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public int getScore() {
		return score;
	}
	
	
}
