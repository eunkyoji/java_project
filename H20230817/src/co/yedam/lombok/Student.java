package co.yedam.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private int 	stdNo;
	private	String 	stdName;
	private int 	score;
	
}
