package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	// First test an invalid CalDay.
	@Test
	public void test01()  throws Throwable  {

		// Construct our CalDay.
		CalDay calDay = new CalDay();

		// assertions
		assertFalse(calDay.isValid());
	}

	// Now let's make a real CalDay.
	@Test
	public void test02()  throws Throwable  {

		int year = 2018;
		int month = 2;
		int day = 2;

		// Construct the CalDay object.
		CalDay calDay = new CalDay(new GregorianCalendar(year, month, day));

		// assertions
		assertTrue(calDay.isValid());
		assertEquals(year, calDay.getYear());
		assertEquals(month, calDay.getMonth());
		assertEquals(day, calDay.getDay());
	}

	// Testing addAppt using 2 appointments. Tried with just one, but it didn't hit the other branch.
	@Test
	public void test03()  throws Throwable {

		int year = 2018;
		int month = 2;
		int day = 2;

		// Construct our CalDay.
		CalDay calDay = new CalDay(new GregorianCalendar(year, month, day));

		// Create the first appointment.
		int startHour=12;
		int startMinute=30;
		int startDay=2;
		int startMonth=02;
		int startYear=2018;
		String title="Appointment Title";
		String description="Appointment Description";

		// Construct a new Appointment object with the initial data
		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		// Create the second appointment.
		int startHour2=11;
		int startMinute2=30;
		int startDay2=2;
		int startMonth2=02;
		int startYear2=2018;
		String title2="Appointment Title";
		String description2="Appointment Description";

		// Construct a new Appointment object with the initial data
		Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title2, description2);

		// Now add the appointments.
		calDay.addAppt(appt1);
		calDay.addAppt(appt2);

		// assertions
		assertEquals(calDay.getSizeAppts(), 2);
	}

	// Testing toString.
	@Test
	public void test04()  throws Throwable {

		int year = 2018;
		int month = 2;
		int day = 2;

		// Construct our CalDay.
		CalDay calDay = new CalDay(new GregorianCalendar(year, month, day));

		// Create the first appointment.
		int startHour=12;
		int startMinute=30;
		int startDay=2;
		int startMonth=02;
		int startYear=2018;
		String title="Appointment Title";
		String description="Appointment Description";

		// Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		// Add the appointment.
		calDay.addAppt(appt);

		// assertions
		assertEquals("\t --- 7/7/2017 --- \n" + " --- -------- Appointments ------------ --- \n" + "\t2/6/2017 at 8:20pm ,Appointment Title, Appointment Description\n" + " \n", calDay.toString());
	}

	// Last test to cover invalid.
	@Test
	public void test05()  throws Throwable {

		// Construct our CalDay.
		CalDay calDay = new CalDay();

		// assertions
		assertFalse(calDay.isValid());
		assertNull(calDay.iterator());
	}
}
