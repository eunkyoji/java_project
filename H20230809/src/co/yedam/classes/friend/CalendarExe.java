package co.yedam.classes.friend;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		cal.set(2023, 1, 3);
		
//		System.out.println(Calendar.DAY_OF_WEEK);
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
//		System.out.println(cal.getActualMaximum(Calendar.DATE));
		
		CalendarApp app = new CalendarApp();
		app.showCalendar(2002, 6);
	}
}
