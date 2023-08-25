package co.yedam.classes.friend;

import java.util.Calendar;

public class CalendarApp {
	public void showCalendar(int year, int month) {
		// Sun Mon Tue Wed Thr Fri Sat
		Calendar cal = Calendar.getInstance();

		cal.set(year, month - 1, 1);

		int start = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		//달력. 31까지
		for( int i = 0; i < days.length; i++ ) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();
		
		for( int i = 0; i < start-1; i++) {
			System.out.printf("%4s", " ");
		}
		
		for( int i = 1; i <= lastDay; i++ ) {
			System.out.printf("%4d", i);
			if( (i + start-1) % 7 == 0 ) {
				System.out.println();
			}
		}
		
//		System.out.println(start);
//		System.out.println(lastDay);
		
	}
}
