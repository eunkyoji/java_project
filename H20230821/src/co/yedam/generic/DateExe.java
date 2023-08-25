package co.yedam.generic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(today.toString());
		System.out.println(sdf.format(today));	// Date => String
		
		String strTime = "2023-09-01";
		Date newDate;
		try {
			newDate = sdf.parse(strTime);	// String => Date
			System.out.println(newDate.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
