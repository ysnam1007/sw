package day7;

import java.util.Calendar;

public class TestCalendar {
	public void test1() {
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		System.out.println(year);
		int month=cal.get(Calendar.MONTH);
		System.out.println(month);
	}

}
