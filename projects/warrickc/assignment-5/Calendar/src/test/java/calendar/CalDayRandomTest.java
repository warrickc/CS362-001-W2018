package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import org.junit.Test;


import static org.junit.Assert.*;



	/* Random Test Generator for CalDay class. */

public class CalDayRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/* Generate Random Tests that tests CalDay Class. */
	@Test
	public void radnomtest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		
		System.out.println("Start testing...");

		try {

			for (int iteration = 0; elapsed < TestTimeout; iteration++) {

				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				int startDay = ValuesGenerator.getRandomIntBetween(random,-1,40);
				int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
				int startYear = ValuesGenerator.RandInt(random);


				int NumDaysInMonth = CalendarUtil.NumDaysInMonth(startYear, startMonth - 1);
				if (startDay > NumDaysInMonth) continue;

				GregorianCalendar day = new GregorianCalendar(startYear, startMonth, startDay);
				CalDay cal = new CalDay(day);


				for (int i = 0; i < NUM_TESTS; i++) {

					int startHour = ValuesGenerator.getRandomIntBetween(random,-1,30);
					int startMinute = ValuesGenerator.getRandomIntBetween(random,-1,75);

					String title = "Birthday Party";
					String description = "This is my birthday party.";

					//Construct a new Appointment object with the initial data
					Appt appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
					cal.addAppt(appt);
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
			}
		} catch(NullPointerException e){

		}
	}
}
