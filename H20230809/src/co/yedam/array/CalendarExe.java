package co.yedam.array;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

public class CalendarExe {
	public static void main(String[] args) {
		int month = 4;
		
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		//달력. 31까지
		for( int i = 0; i < days.length; i++ ) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();
		
		int space = getFirstDay(month);
		for( int i = 0; i < space; i++) {
			System.out.printf("%4s", " ");
		}
		
		for( int i = 1; i <= getLastDate(month); i++ ) {
			System.out.printf("%4d", i);
			if( (i + space) % 7 == 0 ) {
				System.out.println();
			}
		}
		
		getFirstDay();
	}
	
	public static void getFirstDay() {
		int year = 2023;
		int month = 1;
		int day = 1;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd day");
		Calendar cal = Calendar.getInstance();
		
		month = cal.get(Calendar.MONTH);
		
		cal.set(year, month - 1, day);
		
		int dya = cal.getFirstDayOfWeek();
		System.out.println("month ::: " + (month + 1));
	}
	
	public static int getFirstDay(int month) {
		int day = 0;
		int totalDays = 0;
		for( int i = 0; i <= month; i++ ) {
			totalDays += getLastDate(i);
		}
		return day;
	}
	
	public static int getLastDate(int month) {
		// 1-31, 2-28, 3- 31
		//Date day = new Date();
		int lastDate = 31;
		
		switch(month) {
			case 4 :
			case 6 :
			case 9 :
			case 11 :
				lastDate = 30;
				break;
			case 2 :
				lastDate = 28;
		}
		
		return lastDate;
		
	}
}